package com.example.logisticaapi.domain.exception;

public class NegocioExeption extends RuntimeException{
    private static final long serialVersionUID = 1L;
    public NegocioExeption(String message){
        super(message);
    }
}
