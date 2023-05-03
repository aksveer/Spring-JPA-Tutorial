package com.springdemo.jpa.springjpatutorial.repository;

import com.springdemo.jpa.springjpatutorial.entity.Course;
import com.springdemo.jpa.springjpatutorial.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class CouseRepositoryTest {

    @Autowired
    private CourseRepository courseRepository;

    @Test
    public void getAllCourses(){
        List<Course> courses = courseRepository.findAll();
        System.out.println(courses);
    }

    @Test
    public void createCourseWithTeacher(){
        Teacher teacher = Teacher.builder()
                .firstName("Adbul")
                .lastName("Bari")
                .build();
    }
}
