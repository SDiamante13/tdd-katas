package com.wundawash.laundry;

public class NextElementIsNotSetupException extends RuntimeException {

    private static final String GENERATOR_DOES_NOT_HAVE_NEXT = "Generator does not have next element";

    public NextElementIsNotSetupException() {
        super(GENERATOR_DOES_NOT_HAVE_NEXT);
    }
}
