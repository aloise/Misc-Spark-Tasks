name := "wikipedia"

scalaVersion := "2.11.8"

scalacOptions ++= Seq("-deprecation")

courseId := "e8VseYIYEeWxQQoymFg8zQ"

resolvers += Resolver.sonatypeRepo("releases")

// grading libraries
libraryDependencies += "junit" % "junit" % "4.10" % "test"
libraryDependencies ++= assignmentsMap.value.values.flatMap(_.dependencies).toSeq

// include the common dir
commonSourcePackages += "common"

assignmentsMap := {
  val depsSpark = Seq(
    "org.apache.spark" %% "spark-core" % "2.1.0"
  )
  Map(
    "example" -> Assignment(
      packageName = "example",
      dependencies = Seq(),
      options = Map("Xmx"->"1540m", "grader-memory"->"2048")),
    "wikipedia" -> Assignment(
      packageName = "wikipedia",
      dependencies = depsSpark,
      options = Map("Xmx"->"1540m", "grader-memory"->"2048", "totalTimeout" -> "900", "grader-cpu" -> "2")),
    "stackoverflow" -> Assignment(
      packageName = "stackoverflow",
      dependencies = depsSpark,
      options = Map("Xmx"->"1540m", "grader-memory"->"2048", "totalTimeout" -> "900", "grader-cpu" -> "2")),
    "timeusage" -> Assignment(
      packageName = "timeusage",
      dependencies = depsSpark :+ ("org.apache.spark" %% "spark-sql" % "2.1.0"),
      options = Map("Xmx"->"1540m", "grader-memory"->"2048", "totalTimeout" -> "900", "grader-cpu" -> "2"))
  )
}

