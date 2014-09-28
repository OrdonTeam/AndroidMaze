package com.ordonteam.commons

import groovy.transform.CompileStatic

@CompileStatic
class UtilGroovy {

    public static <T> T getRandom(Set<T> set, Random random) {
        return set.toList().get(random.nextInt(set.size()))
    }

}