sbtPlugin := true

name := "my-sbt-plugin-depends-on-another"

version := "0.1.2.1"

organization := "test20140913"

addSbtPlugin("net.virtual-void" % "sbt-dependency-graph" % "0.7.5")
