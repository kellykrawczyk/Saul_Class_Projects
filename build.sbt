name := "useSaul"

version := "1.0"

scalaVersion := "2.11.7"
resolvers += "CogcompSoftware" at "http://cogcomp.cs.illinois.edu/m2repo/"

libraryDependencies ++= Seq("edu.illinois.cs.cogcomp" % "saul-examples_2.11" % "0.5.4" withSources)

libraryDependencies ++= Seq(
  "org.scala-lang" % "scala-reflect" % "2.11.7",
  "org.scala-lang.modules" % "scala-xml_2.11" % "1.0.4"
)