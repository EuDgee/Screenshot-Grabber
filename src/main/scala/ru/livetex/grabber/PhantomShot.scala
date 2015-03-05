package ru.livetex.grabber

import sys.process._

object PhantomShot {
  def make(id: String, siteUrl: String, width: Number, height: Number, format: String, folder: String) {
    val script = "./node_modules/phantomjs/bin/phantomjs ./src/main/javascript/grab-screenshot.js "
    val params = List(siteUrl, id, width.toString, height.toString, format, folder).reduce(_ + " " + _)
    (script + params) !
  }
}
