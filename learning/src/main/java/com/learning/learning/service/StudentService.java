package com.learning.learning.service;

import com.learning.learning.model.Student;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class StudentService {

    private final List<Student> students = new ArrayList<>();
    private final AtomicInteger idSequence = new AtomicInteger(1);

    public StudentService() {
        students.add(new Student(idSequence.getAndIncrement(), "Rahul", 20));
        students.add(new Student(idSequence.getAndIncrement(), "Anita", 22));
    }

    public synchronized List<Student> getAllStudents() {
        return Collections.unmodifiableList(new ArrayList<>(students));
    }

    public synchronized Student createStudent(Student student) {
        if (student.getId() == null) {
            student.setId(idSequence.getAndIncrement());
        }

        students.add(student);
        return student;
    }
}
