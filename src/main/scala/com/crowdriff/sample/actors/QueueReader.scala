package com.crowdriff.sample.actors

import akka.actor.{ActorLogging, Actor}
import scala.collection.mutable

class QueueReader(queue: mutable.Queue[Int]) extends Actor with ActorLogging {
  import QueueReader._

  def receive: Actor.Receive = {

    case QueueReadRequest =>
      if(!queue.isEmpty) {
        val number = queue.dequeue()
        log.debug(s"Sending message ($number) to requester (${sender.path.toString})")
        sender ! QueueMessage(number)
      }
      else {
        sender ! Finished
      }

    case _ =>
      log.error("QueueReader got an unexpected message")

  }
}

object QueueReader {
  case object QueueReadRequest
  case class QueueMessage(number: Int)
  case object Finished
}