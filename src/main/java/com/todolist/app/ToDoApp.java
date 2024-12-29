package com.todolist.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.naming.AuthenticationException;
import javax.naming.Context;
import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import javax.naming.directory.*;
import java.util.Enumeration;
import java.util.Properties;
import java.util.logging.LogManager;
import java.util.logging.Logger;

@SpringBootApplication
public class ToDoApp {


    public static void main(String[] args) {
        SpringApplication.run(ToDoApp.class, args);
    }
}