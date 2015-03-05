package ru.livetex.grabber

import org.scalatest.FlatSpec

import scala.reflect.io.File
import scala.util.Random

class PhantomJsSpec extends FlatSpec {
  "Phantom Script" should "make a screenshot by id and valid site name" in {
    val ID = (1 + Random.nextInt(23423423)).toString
    val site = "http://www.livetex.ru"

    val fileName = ID + ".jpg"
    File(fileName).delete()

    PhantomShot.make(ID, site)
    assert(File(fileName).exists, "No valid screenshot for" + site)

    File(fileName).delete()
  }
}
