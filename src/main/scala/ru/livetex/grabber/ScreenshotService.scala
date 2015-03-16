package ru.livetex.grabber

import akka.actor.ActorSystem
import akka.event.LoggingAdapter
import akka.http.model.StatusCodes._
import akka.http.server.Directives._


trait ScreenshotService {
  implicit val system: ActorSystem
  val log: LoggingAdapter

  val routes = {
    get {
      pathPrefix("screenshot") {
        parameters('id, 'url) { (id: String, url: String) =>
          complete {
            log.debug("Request parsed: id=" + id + " url=" + url)
            acquireScreenshot(id, url)
            OK
          }
        }
      }
    }
  }

  def acquireScreenshot(id: String, url: String): Unit = {
    log.warning(
      "Change default implementation of ScreenshotService.acquireScreenshot")
  }
}
