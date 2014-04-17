import sbt._

object Version {
  val scala           = "2.10.3"
  val akka            = "2.2.3"
}

object Library {
  val jsr305         = "com.google.code.findbugs"  %  "jsr305"                % "2.0.1"
  val log4j          = "log4j"                     %  "log4j"                 % "1.2.17"

  val akkaActor      = "com.typesafe.akka"         %% "akka-actor"            % Version.akka
  val akkaAgent      = "com.typesafe.akka"         %% "akka-agent"            % Version.akka
  val akkaSlf4j      = "com.typesafe.akka"         %% "akka-slf4j"            % Version.akka

  val guava          = "com.google.guava"          %  "guava"                 % "16.0.1"
  val jodaTime       = "joda-time"                 %  "joda-time"             % "2.3"
  val jodaConvert    = "org.joda"                  %  "joda-convert"          % "1.6"

  val junit          = "junit"                     %  "junit"                 % "4.11"
  val scalatest      = "org.scalatest"             %% "scalatest"             % "1.9.1"
  val akkaTestKit    = "com.typesafe.akka"         %% "akka-testkit"          % Version.akka
}

object Dependencies {
  import Library._

  val akkaSkeleton = List(
    jsr305,
    log4j,
    akkaActor,
    akkaAgent,
    akkaSlf4j,
    guava,
    jodaTime,
    jodaConvert,
    junit % "test",
    scalatest % "test",
    akkaTestKit % "test"
  )
}