package com.ordonteam.model.controllers

import pl.polidea.robospock.RoboSpecification

class BotControllerSpec extends RoboSpecification {

    def "clicking right from player: move player right"() {
        expect:
        new BotController()
    }
}