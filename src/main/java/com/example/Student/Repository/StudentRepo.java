package com.example.Student.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Student.Entity.Student;

@Repository
public interface StudentRepo extends JpaRepository<Student,Integer> {

	List<Student> findByCollegeId(Integer collegeId);
}
