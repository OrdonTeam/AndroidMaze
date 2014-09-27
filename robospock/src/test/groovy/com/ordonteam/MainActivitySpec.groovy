package com.ordonteam

import pl.polidea.robospock.RoboSpecification

class MainActivitySpec extends RoboSpecification {

    def "groovy finds getter itself; no need to call them directly"() {
        expect:
        1==1
    }
}