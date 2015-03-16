package ru.livetex.grabber

import akka.actor.{Actor, ActorLogging}

class PhantomShotActor() extends Actor with ActorLogging {
  val width = context.system.settings.config.getNumber("screenshot.width")
  val height = context.system.settings.config.getNumber("screenshot.height")
  val format = context.system.settings.config.getString("screenshot.format")
  val folder = context.system.settings.config.getString("screenshot.folder")

  log.debug("Phantom Screenshot Actor started.")

  def receive = {
    case Message.AcquireScreenshot(id, url) =>
      log.debug("Acquiring a screenshot, url=" + url + " id=" + id)
      PhantomShot.make(id, url, width, height, format, folder)
      log.debug("Screenshot acquired and saved, url=" + url + " id=" + id)
  }
}
