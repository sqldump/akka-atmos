package com.crowdriff.sample

import akka.actor.{Props, ActorSystem}
import scala.collection.mutable
import com.crowdriff.sample.actors.{MessageProcessor, QueueReader}

object Main extends App {

  val system = ActorSystem("sampleSystem")

  // Make a dummy queue and put some messages in it
  val fakeQueue = mutable.Queue[Int]()
  (1 to 10).foreach(fakeQueue.enqueue(_))

  val queueReader = system.actorOf(Props(classOf[QueueReader], fakeQueue), "queueReader")
  val messageProcessor = system.actorOf(Props(classOf[MessageProcessor], queueReader), "messageProcessor")

}