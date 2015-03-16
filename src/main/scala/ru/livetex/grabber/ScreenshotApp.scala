package ru.livetex.grabber

import akka.actor.{Props, ActorSystem}
import akka.event.Logging
import akka.http.Http
import akka.routing.FromConfig
import akka.stream.ActorFlowMaterializer
import com.typesafe.config.ConfigFactory


object ScreenshotApp extends App with ScreenshotService {
  override implicit val system = ActorSystem()
  implicit val executor = system.dispatcher
  implicit val materializer = ActorFlowMaterializer()

  val config = ConfigFactory.load()
  override val log = Logging(system, getClass)

  PhantomShot.checkScript()
  startHttp()
  val screenshotActor = system.actorOf(FromConfig.props(Props[PhantomShotActor]),
      name = "PhantomShotActor")
  val urlCheckerActor = system.actorOf(URLCheckerActor.props(screenshotActor),
      name = "URLCheckerActor")

  def startHttp() = {
    Http()
      .bind(interface = config.getString("http.interface"), port = config.getInt("http.port"))
      .startHandlingWith(routes)
  }

  override def acquireScreenshot(id: String, url: String): Unit = {
    log.debug("Starting a screenshot acquiring from ScreenshotApp, url=" + url + " id=" + id)
    urlCheckerActor ! Message.CheckURL(id, url)
  }
}
