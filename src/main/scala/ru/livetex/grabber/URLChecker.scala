package ru.livetex.grabber

import scala.io.Source
import scala.util.Try

object URLChecker {
  val defaultScheme = "http://"
  val schemes = List(defaultScheme, "https://")

  def check(url: String) = {
    Try {
      Source.fromURL(url)
    }.isSuccess
  }

  def correct(url: String) = {
    if (schemes.count(url.startsWith) > 0) {
      url
    } else {
      defaultScheme + url
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
