package com.crowdriff.sample.actors

import akka.actor.{ActorRef, Actor, ActorLogging}
import com.crowdriff.sample.actors.QueueReader.{QueueMessage, QueueReadRequest, Finished}

class MessageProcessor(queueReader: ActorRef) extends Actor with ActorLogging {

  override def preStart() {
    log.debug("Processor preStart")
    requestWork()
  }

  def receive: Actor.Receive = {
    case msg: QueueMessage =>
      log.debug(s"Processing message ${msg.number}")
      requestWork()

    case Finished =>
      log.debug("Finished processing the queue!")
      context.system.shutdown()
  }

  private def requestWork(): Unit = {
    queueReader ! QueueReadRequest
  }

}
