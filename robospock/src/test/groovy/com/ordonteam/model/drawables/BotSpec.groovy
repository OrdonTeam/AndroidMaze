package com.ordonteam.model.drawables

import pl.polidea.robospock.RoboSpecification

class BotSpec extends RoboSpecification {

    def "groovy finds getter itself; no need to call them directly"() {
        expect:
        new Bot() != null
    }
}