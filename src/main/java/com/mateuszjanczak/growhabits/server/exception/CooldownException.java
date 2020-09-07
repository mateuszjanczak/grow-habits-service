package com.mateuszjanczak.growhabits.server.exception;

public class CooldownException extends RuntimeException {

    public CooldownException(String message) {
        super(message);
    }

}
