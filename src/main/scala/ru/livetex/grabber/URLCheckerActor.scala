package ru.livetex.grabber

import akka.actor.{Props, Actor, ActorLogging, ActorRef}

class URLCheckerActor(screenshotActor: ActorRef) extends Actor with ActorLogging {
  def receive = {
    case Message.CheckURL(id, url) =>
      log.debug("Checking URL=" + url + " for id=" + id)
      URLChecker.getCorrectURL(url).foreach(
        screenshotActor ! Message.AcquireScreenshot(id, _))
  }
}

object URLCheckerActor {
  def props(screenshotActor: ActorRef) = Props(new URLCheckerActor(screenshotActor))
}
