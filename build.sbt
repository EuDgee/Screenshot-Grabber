name := "Screenshot-Grabber"

version := "0.0.1-SNAPSHOT"

scalaVersion := "2.11.5"

resolvers += "Typesafe Repository" at "http://repo.typesafe.com/typesafe/releases/"

libraryDependencies += "com.typesafe.akka" %% "akka-actor" % "2.3.9"

libraryDependencies += "org.scalatest" % "scalatest_2.11" % "2.2.1" % "test"

libraryDependencies += "com.typesafe.akka" %% "akka-testkit" % "2.3.9" % "test"

libraryDependencies += "org.seleniumhq.selenium" % "selenium-java" % "2.44.0" % "test"

libraryDependencies += "com.github.detro" % "phantomjsdriver" % "1.2.0" % "test"
