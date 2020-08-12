package com.Student.StudentData.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Student.StudentData.domain.StudentDetails;

public interface StudentDetailsRepo extends JpaRepository<StudentDetails, Integer> {

}
