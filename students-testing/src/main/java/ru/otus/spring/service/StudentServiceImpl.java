package ru.otus.spring.service;

import org.springframework.stereotype.Service;
import ru.otus.spring.domain.Student;
import ru.otus.spring.service.exceptions.StudentInfoReadException;

@Service
public class StudentServiceImpl implements StudentService {

    private static final String MSG_KEY_ASK_STUDENT_NAME = "ASK_STUDENT_NAME";
    private static final String MSG_KEY_ASK_STUDENT_LASTNAME = "ASK_STUDENT_LASTNAME";
    private final MessageService ms;

    public StudentServiceImpl(MessageService ms) {
        this.ms = ms;
    }

    public Student getStudent() throws StudentInfoReadException {

        try {
            String studentName = ms.readLn(MSG_KEY_ASK_STUDENT_NAME);
            String studentLastName = ms.readLn(MSG_KEY_ASK_STUDENT_LASTNAME);
            return new Student(studentName, studentLastName);
        } catch(Exception e) {
            throw new StudentInfoReadException("Student info read filed", e);
        }
    };
}
