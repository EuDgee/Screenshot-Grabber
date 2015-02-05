package ru.livetex.grabber

import org.scalatest.FeatureSpec

class ScenarioSpec extends FeatureSpec {
  feature("Screenshot grabbing") {
    info("As a user I want to be able to get website`s screenshot")
    info("by providing url to it and get this screenshot via png file")
    scenario("User provides valid url") {pending}

    scenario("User provides url with https protocol") {pending}

    scenario("User provides url not to site`s main page") {pending}

    scenario("User provides invalid url") {pending}

    scenario("User provides inaccesible url") {pending}
  }

  feature("Simultaneous access") {
    info("As a user I want to be able to request different screenshots simultaneously")
    scenario("n simultaneous requests") {pending}
  }
}
