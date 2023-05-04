package com.springdemo.jpa.springjpatutorial.repository;

import com.springdemo.jpa.springjpatutorial.entity.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.LongSummaryStatistics;

@SpringBootTest
public class CouseRepositoryTest {

    @Autowired
    private CourseRepository courseRepository;

    @Test
    public void getAllCourses() {
        List<Course> courses = courseRepository.findAll();
        System.out.println(courses);
    }

    @Test
    public void createCourseWithTeacher() {
        Teacher teacher = Teacher.builder()
                .firstName("Yo")
                .lastName("Chang")
                .build();

        Course course = Course.builder()
                .courseTitle("Go")
                .credit(5)
                .teacher(teacher)
                .build();

        courseRepository.save(course);
    }

    @Test
    public void findAllPagination() {
        Pageable firstPageWithThreeRecords = PageRequest.of(0, 3);
        Pageable secondPageWithTwoRecords = PageRequest.of(1, 2);

        List<Course> courses = courseRepository.findAll(secondPageWithTwoRecords).getContent();

        System.out.println("courses = " + courses);

        long totalElements = courseRepository.findAll(secondPageWithTwoRecords).getTotalElements();
        System.out.println("totalElements = " + totalElements);

        int totalPages = courseRepository.findAll(secondPageWithTwoRecords).getTotalPages();

        System.out.println("totalPages = " + totalPages);
    }

    @Test
    public void findAllWithSorting() {
        Pageable sortByTitle = PageRequest.of(0,
                2,
                Sort.by("courseTitle"));
        Pageable sortByCreditsDesc = PageRequest.of(0,
                2,
                Sort.by("credit").descending());

        Pageable getSortByTitleCreditsDesc = PageRequest.of(0,
                2,
                Sort.by("courseTitle").descending()
                        .and(Sort.by("credit")
                        ));
        List<Course> courses = courseRepository.findAll(getSortByTitleCreditsDesc)
                .getContent();

        System.out.println("courses = " + courses);

    }
    @Test
    public void findByTitleContaining(){
        Pageable pageable = PageRequest.of(0,10);

        List<Course> courses = courseRepository.findByCourseTitleContaining(
                "D",
                pageable).getContent();

        System.out.println("courses = " + courses);
    }
    @Test
    public void addCourseWithStudent(){
/*        CourseMaterial courseMaterial = CourseMaterial.builder()
                .url("google.com")
                .build();*/

        Teacher teacher = Teacher.builder()
                .firstName("Chat")
                .lastName("GPT")
                .build();

        Guardian guardian = Guardian.builder()
                .name("Bhat Senior")
                .email("bharsenior@gmail.com")
                .build();

        Student student = Student.builder()
                .firstName("Akshay")
                .lastName("Bhat")
                .emailId("bhat@gmail.com")
                .guardian(guardian)
                .build();
        Course course = Course.builder()
                .courseTitle("AI")
                //.courseMaterial(courseMaterial)
                .teacher(teacher)
                .credit(12)
                .build();

        course.addStudent(student);

        courseRepository.save(course);
    }
}
