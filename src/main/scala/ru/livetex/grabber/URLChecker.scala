package ru.livetex.grabber

import scala.io.Source

object URLChecker {
  val schemes = List("http://", "https://")

  def check(url: String) = {
    try {
      Source.fromURL(url)
      true
    } catch {
      case _: Exception => false
    }
  }

  def correct(url: String) = {
    if (schemes.count(url.startsWith) > 0) {
      url
    } else {
      schemes.head + url
    }
  }

  def getCorrectURL(url: String): Option[String] = {
    val corrected = correct(url)
    check(corrected) match {
      case true => Some(corrected)
      case false => None
    }
  }
}
