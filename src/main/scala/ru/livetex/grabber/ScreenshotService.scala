package ru.livetex.grabber

import akka.actor.ActorSystem
import akka.event.LoggingAdapter
import akka.http.model.StatusCodes._
import akka.http.server.Directives._


trait ScreenshotService {
  implicit val system: ActorSystem
  val log: LoggingAdapter

  val routes = {
    pathPrefix("screenshot") {
      (get & path(Segments(2))) {
        case List(id, url) => complete {
          log.debug("Request parsed: id=" + id + " url=" + url)
          acquireScreenshot(id, url)
          OK
        }

        case _ => complete(BadRequest)
      }
    }
  }

  def acquireScreenshot(id: String, url: String): Unit = {
    log.warning(
      "Change default implementation of ScreenshotService.acquireScreenshot")
  }
}
