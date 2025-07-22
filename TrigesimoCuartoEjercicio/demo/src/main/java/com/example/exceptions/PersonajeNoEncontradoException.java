package com.example.exceptions;

public class PersonajeNoEncontradoException extends RuntimeException{
    public PersonajeNoEncontradoException(String mensaje) {
        super(mensaje);
    }
}
