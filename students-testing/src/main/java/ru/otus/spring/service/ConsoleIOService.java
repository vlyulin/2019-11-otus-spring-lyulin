package ru.otus.spring.service;

import org.springframework.stereotype.Service;

import java.util.Scanner;

@Service
public class ConsoleIOService implements IOService {

    private final Scanner sc;

    public ConsoleIOService() {
        sc = new Scanner(System.in);
    }

    @Override
    public void printLn(String msg) {
        System.out.println(msg);
    }

    @Override
    public String readLn() {
        return sc.next();
    }

    @Override
    public String readLn(String msg) {
        printLn(msg);
        return readLn();
    }
}
