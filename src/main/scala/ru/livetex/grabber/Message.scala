package ru.livetex.grabber

object Message {
  case class CheckURL(id:String, url: String)
  case class AcquireScreenshot(id:String, url: String)
}
