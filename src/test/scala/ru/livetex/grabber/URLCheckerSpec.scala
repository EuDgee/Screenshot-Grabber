package ru.livetex.grabber

import org.scalatest.FlatSpec

class URLCheckerSpec extends FlatSpec {
  "URL Checker" should "check URL correctness and accessibility" in {
    assert(URLChecker.correct("www.google.com") == "http://www.google.com")
    assert(URLChecker.correct("https://www.livetex.ru") == "https://www.livetex.ru")
    assert(URLChecker.correct("somesite.com/1/2") == "http://somesite.com/1/2")

    assert(URLChecker.check("noreal.site.site") == false)
    assert(URLChecker.check("http://noreal.site.site") == false)
    assert(URLChecker.check("http://noreal.site.site") == false)
    assert(URLChecker.check("http://www.livetex.ru") == true)

    assert(URLChecker.getCorrectURL("livetex.ru") == Some("http://livetex.ru"))
    assert(URLChecker.getCorrectURL("http://noreal.site.site") == None)
  }
}
