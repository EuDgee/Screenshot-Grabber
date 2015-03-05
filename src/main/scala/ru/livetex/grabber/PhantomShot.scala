package ru.livetex.grabber

import sys.process._

object PhantomShot {
  def make(id: String, siteUrl: String) {
    val script = "./node_modules/phantomjs/bin/phantomjs ./src/main/javascript/grab-screenshot.js"
    (script + " " + siteUrl + " " + id) !
  }
}
