package ru.netology;

public class AlreadyExistsException extends RuntimeException{
    public AlreadyExistsException(String msg){
        super(msg);
    }
}
