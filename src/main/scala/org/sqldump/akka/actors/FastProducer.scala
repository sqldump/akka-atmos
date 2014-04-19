package org.sqldump.akka.actors

import akka.actor.{ActorRef, ActorLogging, Actor}
import org.sqldump.akka.actors.SlowConsumer.Stop

class FastProducer(val slow: ActorRef) extends Actor with ActorLogging {
  import FastProducer._

  override def preStart() {
    self ! Start
  }

  override def receive: Actor.Receive = {
    case Start =>
      log.info("Starting FastProducer")
      for(i <- 1 to 1000) {
        slow ! i
      }
      slow ! Stop
      log.info("Stopping FastProducer")
      context.stop(self)
  }

}

object FastProducer {
  case object Start
}