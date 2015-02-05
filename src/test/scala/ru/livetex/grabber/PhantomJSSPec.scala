package ru.livetex.grabber

import org.scalatest.FlatSpec
import ru.livetex.grabber.browser.PhantomJs

class PhantomJsSpec extends FlatSpec {
  "PhantomJs" should "start" in {
    val browser = new PhantomJs
  }

  it should "navigate to websites" in {
    val browser = new PhantomJs
    browser goTo "www.google.com"
    assert(browser.title == "Google", "sheck for title in google.com")
  }

  it should "grab a screenshot to a file" in {pending}
}
