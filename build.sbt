import AssemblyKeys._

organization := "org.sqldump"

name := "akkaAtmos"

version := "0.1.0-SNAPSHOT"

scalaVersion := "2.10.3"

resolvers ++= List(
  "Sonatype OSS Snapshots" at "https://oss.sonatype.org/content/repositories/snapshots"
)

libraryDependencies ++= Dependencies.akkaAtmos

assemblySettings

atmosSettings

atmosTestSettings

mergeStrategy in assembly <<= (mergeStrategy in assembly) { 
  (old) => {
  	case PathList("com", xs @ _*) => MergeStrategy.first
    case PathList("javax", xs @ _*) => MergeStrategy.first
    case PathList("org", xs @ _*) => MergeStrategy.first
    case x => old(x)
  }
}

test in assembly := {}
