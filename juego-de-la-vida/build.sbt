ThisBuild / scalaVersion := "3.3.4"
ThisBuild / version      := "0.1.0"

lazy val root = (project in file("."))
  .settings(
    name := "juego-de-la-vida",
    libraryDependencies += "org.scalatest" %% "scalatest" % "3.2.19" % Test
  )
