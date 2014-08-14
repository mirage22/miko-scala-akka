name := "miko-scala-akka"

version := "1.0"

libraryDependencies ++= Seq(
  "com.typesafe.akka" %% "akka-actor" % "2.4-SNAPSHOT",
  "com.typesafe.akka" %% "akka-testkit" % "2.4-SNAPSHOT",
  "org.slf4j" % "jcl-over-slf4j" % "1.7.7" ,
  "org.slf4j" % "slf4j-api" % "1.7.7" ,
  "org.slf4j" % "slf4j-log4j12" % "1.7.7",
  "org.apache.logging.log4j" % "log4j" % "2.0" excludeAll(
      ExclusionRule(organization = "com.sun.jdmk"),
      ExclusionRule(organization = "com.sun.jmx"),
      ExclusionRule(organization = "javax.jms")
      ),
  "org.scalatest" % "scalatest_2.11" % "2.2.1" % "test",
  "junit" % "junit" % "4.11" % "test"
)

resolvers += "Akka Snapshot Repository" at "http://repo.akka.io/snapshots/"