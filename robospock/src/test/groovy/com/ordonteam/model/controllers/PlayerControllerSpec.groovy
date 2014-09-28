package com.ordonteam.model.controllers

import pl.polidea.robospock.RoboSpecification

class PlayerControllerSpec extends RoboSpecification {

    def "groovy finds getter itself; no need to call them directly"() {
        expect:
        1==1
    }
}