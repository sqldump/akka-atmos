/**
 * This actor keeps a running total of all Ints it receives.
 */
package com.crowdriff.sample

import akka.actor.{ActorLogging, Actor}

class SummingActor extends Actor with ActorLogging {

	def receive: Actor.Receive = newSum(0)

  private def newSum(sum: Int): Actor.Receive = {
    case i: Int =>
      context.become(newSum(sum + i))
      log.debug(s"Sum = ${sum + i}")

    case _ =>
      log.error(new Exception("Unexpected message"), "This actor can only receive Ints")
  }

}