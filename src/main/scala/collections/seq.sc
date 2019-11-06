case class Film(name: String, yearOfRelease: Int, imdbRating: Double)

case class Director(firstName: String, lastName: String, yearOfBirth: Int, films: Seq[Film])

val memento = Film("Memento", 2000, 8.5)
val darkKnight = Film("Dark Knight", 2008, 9.0)
val inception = Film("Inception", 2010, 8.8)
val highPlainsDrifter = Film("High Plains Drifter", 1973, 7.7)
val outlawJoseyWales = Film("The Outlaw Josey Wales", 1976, 7.9)
val unforgiven = Film("Unforgiven", 1992, 8.3)
val granTorino = Film("Gran Torino", 2008, 8.2)
val invictus = Film("Invictus", 2009, 7.4)
val predator = Film("Predator", 1987, 7.9)
val dieHard = Film("Die Hard", 1988, 8.3)
val huntForRedOctober = Film("The Thomas Crown Affair", 1999, 6.8)
val thomasCrownAffair = Film("The Hunt for Red October", 1990, 7.6)

val eastwood = Director("Clint", "Eastwood", 1930, Seq(highPlainsDrifter, outlawJoseyWales, unforgiven, granTorino, invictus))
val mcTiernan = Director("John", "McTiernan", 1951, Seq(predator, dieHard, huntForRedOctober, thomasCrownAffair))
val nolan = Director("Christopher", "Nolan", 1970, Seq(memento, darkKnight, inception))
val someGuy = Director("Just", "Some Guy", 1990, Seq())

val directors = Seq(eastwood, mcTiernan, nolan, someGuy)

// Accept a parameter numberOfFilms of type Int — find all directors who have directed more than numberOfFilms:
def films(numberOfFilms: Int): Seq[Director] = directors.filter(_.films.size > numberOfFilms)
films(3)

def bornBefore(year: Int): Seq[Director] = directors.filter(_.yearOfBirth < year)
bornBefore(1950)

def filmsAndBornBefore(numberOfFilms: Int, year: Int): Seq[Director] =
  directors.filter(director => director.yearOfBirth < year && director.films.length > numberOfFilms)
filmsAndBornBefore(4, 1970)

def sortByAge(ascending: Boolean = true): Seq[Director] =
  if (ascending) directors.sortWith(_.yearOfBirth < _.yearOfBirth)
  else directors.sortWith(_.yearOfBirth > _.yearOfBirth)
sortByAge()

def sortByAgeV2(ascending: Boolean = true): Seq[Director] =
  directors.sortWith { (a, b) =>
    if (ascending) a.yearOfBirth < b.yearOfBirth
    else a.yearOfBirth > b.yearOfBirth
  }
sortByAgeV2(false)

// Nolan films
nolan.films.map(_.name)

// Cinephile
directors.flatMap(_.films.map(_.name))

// Vintage McTiernan
mcTiernan.films.foldLeft(Int.MaxValue)((a, b) => a.min(b.yearOfRelease))

mcTiernan.films.sortWith { (a, b) => a.yearOfRelease < b.yearOfRelease }.headOption

// High Score Table
directors.flatMap(_.films).sortWith(_.imdbRating > _.imdbRating)

val films = directors.flatMap(_.films)
val avg = films.map(_.imdbRating).sum / films.size

// Tonight’s Lis􏰂ngs
directors.foreach { director =>
  director.films.foreach { film =>
    println(s"Tonight only! ${film.name} by ${director.firstName} ${director.lastName}!")
  }
}

// From the Archives
directors.filter(_.films.nonEmpty).map { director =>
  director.lastName -> director.films.foldLeft(Int.MaxValue)((a, b) => a.min(b.yearOfRelease))
}

directors.flatMap { director =>
  director.films.sortWith { (a, b) => a.yearOfRelease < b.yearOfRelease }.headOption
}