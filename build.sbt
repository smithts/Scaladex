name := """Scaladex"""
organization := "com.6221.group9"

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.13.3"

libraryDependencies += guice
libraryDependencies += "org.scalatestplus.play" %% "scalatestplus-play" % "5.0.0" % Test
libraryDependencies += ws
libraryDependencies += "org.webjars" % "jquery-ui" % "1.12.1"

// Adds additional packages into Twirl
//TwirlKeys.templateImports += "com.6221.group9.controllers._"

// Adds additional packages into conf/routes
// play.sbt.routes.RoutesKeys.routesImport += "com.6221.group9.binders._"
