package com.springdemo.jpa.springjpatutorial.repository;

import com.springdemo.jpa.springjpatutorial.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Long> {
}
