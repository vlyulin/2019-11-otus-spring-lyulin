package ru.otus.spring.service;

import org.springframework.stereotype.Service;
import ru.otus.spring.domain.Person;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

@Service
public class PersonServiceImpl implements PersonService {

    private final InteractionService console;

    public PersonServiceImpl(InteractionService console) {
        this.console = console;
    }

    public Person getStudent() {
        String studentName = "Noname";
        String studentLastName = "Noname";

        console.printTag("ASK_STUDENT_NAME");
        try {
            studentName = console.readLine();
            if( studentName.isEmpty() || studentName.isBlank() ) {
                studentName = "Noname";
                console.printTag("NONAME", studentName);
            }
        } catch (IOException e) {
            studentName = "Noname";
            console.printTag("NONAME",e.toString());
        }

        console.printTag("ASK_STUDENT_LASTNAME");
        try {
            studentLastName = console.readLine();
            if( studentLastName.isEmpty() || studentLastName.isBlank() ) {
                studentLastName = "Noname";
            }
        } catch (IOException e) {
            studentLastName = "Noname";
            console.printTag("NONAME",e.toString());
        }
        return new Person(studentName, studentLastName);
    };
}
