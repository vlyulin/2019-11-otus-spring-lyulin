package ru.otus.spring.service;

import ru.otus.spring.domain.Student;
import ru.otus.spring.service.exceptions.StudentInfoReadException;

public interface StudentService {
    // Person get();
    Student getStudent() throws StudentInfoReadException;
}
