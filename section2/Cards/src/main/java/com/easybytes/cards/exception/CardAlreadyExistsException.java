package com.easybytes.cards.exception;

/**
 * This class is used to throw an exception when a card with the same card number or mobile number already exists.
 * It extends the RuntimeException class and takes a message as a parameter.
 * The message is passed to the parent class using the super keyword.
 * This is useful because the parent class can handle the message and the exception can be thrown with the message.
 * The exception is then caught and handled by the exception handler.
 */
public class CardAlreadyExistsException extends RuntimeException {

    public CardAlreadyExistsException(String message) {
        super(message);
    }
}
