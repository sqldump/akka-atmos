package org.sqldump.akka

import akka.actor.{Props, ActorSystem}
import org.sqldump.akka.actors.{FastProducer, SlowConsumer}

object Main extends App {

  val system = ActorSystem("sys")
  val slow = system.actorOf(Props[SlowConsumer], name="slowConsumer")
  system.actorOf(Props(classOf[FastProducer], slow), name="fastProducer")

}
