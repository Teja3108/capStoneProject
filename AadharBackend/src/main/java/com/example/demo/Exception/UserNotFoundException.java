package com.example.demo.Exception;

public class UserNotFoundException extends RuntimeException{
public UserNotFoundException(int id) {
super("User with id " + id + " is not Found.Pls Give another id!!");
}
}
