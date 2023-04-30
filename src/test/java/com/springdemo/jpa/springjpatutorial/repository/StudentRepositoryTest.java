package com.springdemo.jpa.springjpatutorial.repository;

import com.springdemo.jpa.springjpatutorial.entity.Guardian;
import com.springdemo.jpa.springjpatutorial.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class StudentRepositoryTest {
    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void saveStudent(){
        Guardian guardian = Guardian.builder()
                .email("Dbveer@gmail.com")
                .name("DB Veer")
                .mobile("7895462154")
                .build();

        Student student = Student.builder()
                .emailId("Akshay@gmail.com")
                .firstName("Akshay")
                .lastName("Veer")
                .guardian(guardian)
                .build();

        Guardian gaudian1 = Guardian.builder()
                .mobile("8446685152")
                .name("ShivgamiDevi")
                .email("ShivgamiDevi@gmail.com")
                .build();

        Student student1 = Student.builder()
                .emailId("Amruta@gmail.com")
                .firstName("Amruta")
                .lastName("Veer")
                .guardian(gaudian1)
                .build();

        List<Student> listOfStudents= new ArrayList<Student>();
        listOfStudents.add(student);
        listOfStudents.add(student1);

        studentRepository.saveAll(listOfStudents);
    }

    @Test
    public void printStudentByFirstName(){
        List<Student> studentList = studentRepository.findByFirstName("Akshay");
        System.out.println("Student is :" + studentList );
    }

    @Test
    public void printStudentByFirstNameContaining(){
        List<Student> studentList = studentRepository.findByFirstNameContaining("A");
        System.out.println("Students are :" + studentList);
    }

    @Test
    public void printStudentBasedOnGuardianName(){
        List<Student> studentList = studentRepository.findByGuardianName("ShivgamiDevi");
    }

    @Test
    public void printStudentByEmailId(){
        System.out.println(studentRepository.getStudentByEmailAddress("Akshay@gmail.com"));
    }

}
