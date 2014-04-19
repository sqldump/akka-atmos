package org.sqldump.akka.actors

import akka.actor.{ActorLogging, Actor}

class SlowConsumer extends Actor with ActorLogging {
  import SlowConsumer._

  override def receive: Receive = {
    case i: Int =>
      // Received an Int, sleep for 250ms
      Thread.sleep(250)

    case Stop =>
      context.system.shutdown()

    case _ =>
      log.info("Unknown message received")
  }
}

object SlowConsumer {
  case object Stop
}