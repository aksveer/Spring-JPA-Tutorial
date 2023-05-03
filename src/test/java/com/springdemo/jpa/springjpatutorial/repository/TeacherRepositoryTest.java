package com.springdemo.jpa.springjpatutorial.repository;

import com.springdemo.jpa.springjpatutorial.entity.Course;
import com.springdemo.jpa.springjpatutorial.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class TeacherRepositoryTest {

    @Autowired
    private TeacherRepository teacherRepository;

    @Test
    public void saveTeacher(){
        Course courseDBA = Course.builder()
                .courseTitle("DBA")
                .credit(6)
                .build();

        Course courseNet = Course.builder()
                .courseTitle(".Net")
                .credit(6)
                .build();

        Teacher teacher = Teacher.builder()
                .firstName("Abdul")
                .lastName("Bari")
                .courses(List.of(courseDBA, courseNet))
                .build();

        teacherRepository.save(teacher);
    }
}

