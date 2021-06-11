package br.com.fiap.traveller.dao.exceptions;

public class EntityNotFoundException extends Exception{
    public EntityNotFoundException(String message) {
        super(message);
    }
}
