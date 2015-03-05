package ru.livetex.grabber

import akka.actor.{Actor, ActorLogging}

class PhantomShotActor extends Actor with ActorLogging {
  def receive = {
    case Message.AcquireScreenshot(id, url) =>
      log.debug("Acquiring a screenshot, url=" + url + " id=" + id)
      PhantomShot.make(id, url)
      log.debug("Screenshot acquired and saved, url=" + url + " id=" + id)
  }
}
