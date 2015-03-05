package ru.livetex.grabber

import akka.actor.{Props, Actor, ActorLogging}

class PhantomShotActor(width: Number, height: Number, format: String, folder: String)
    extends Actor with ActorLogging {

  def receive = {
    case Message.AcquireScreenshot(id, url) =>
      log.debug("Acquiring a screenshot, url=" + url + " id=" + id)
      PhantomShot.make(id, url, width, height, format, folder)
      log.debug("Screenshot acquired and saved, url=" + url + " id=" + id)
  }
}

object PhantomShotActor {
  def props(width: Number, height: Number, format: String, folder: String) =
      Props(new PhantomShotActor(width, height, format, folder))
}
