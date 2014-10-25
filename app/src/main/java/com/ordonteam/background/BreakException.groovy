package com.ordonteam.background

import groovy.transform.CompileStatic

@CompileStatic
class BreakException extends RuntimeException {

    BreakException() {
        super("BREAK")
    }
}
