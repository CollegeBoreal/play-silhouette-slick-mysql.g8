organization := "ca.collegeboreal"

name := "PlaySlickOauth2"

description := "Example Play App set up to use Slick with MySQL and Evolutions under Silhouette oAuth2 scheme"

version := "1.0-SNAPSHOT"

scalaVersion := "2.12.6"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

/*
* Workaround for https://github.com/sbt/sbt/issues/630 when running travis tests on the template.
* If desired, you can remove this line and rename the /tests/ folder to /test/
* You will need to do something different with the scripted test file /test
**/
scalaSource in Test := baseDirectory.value / "tests"

libraryDependencies ++= Seq(
  guice,
  ws,
  "commons-io" % "commons-io" % "2.6",
  "org.scalatestplus.play" %% "scalatestplus-play" % "3.1.2" % Test,
  "com.typesafe.akka" %% "akka-testkit" % "2.5.11" % Test,
  "org.mockito" % "mockito-core" % "2.18.0" % Test
)

scalacOptions ++= Seq(
    "-unchecked"
  , "-deprecation"
  , "-feature"
  , "-language:postfixOps"
  , "-language:reflectiveCalls"
)



