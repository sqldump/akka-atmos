package com.crowdriff.sample

import akka.actor.{Props, ActorSystem}

object Main extends App {
  val system = ActorSystem("akka-skeleton")
  val summingActor = system.actorOf(Props[SummingActor], "summingActor")

  summingActor ! 2
  summingActor ! 3
  summingActor ! 5
  summingActor ! 7
  summingActor ! 11

  system.shutdown()
}