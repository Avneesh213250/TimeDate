package com.Student.StudentData.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.Student.StudentData.domain.StudentDetails;
import com.Student.StudentData.service.StudentDetailsService;

@RestController
@CrossOrigin
public class StudentDetailsController {
    
	@Autowired
	StudentDetailsService timeService;
	
	@GetMapping("getStudentDetailsById/{id}")
	public ResponseEntity<StudentDetails> getStudentDetailsById(@PathVariable Integer id) {
		return ResponseEntity.ok(timeService.findById(id));
	}
	
	@PostMapping("/saveStudentDetails")
	public ResponseEntity<StudentDetails> saveStudentDetails(@RequestBody StudentDetails StudentDetails){
		System.out.println(StudentDetails);
		return ResponseEntity.ok(timeService.save(StudentDetails));
	}
	
	@SuppressWarnings("rawtypes")
	@DeleteMapping("/deleteStudentDetails/{id}")
	public ResponseEntity deleteById(@PathVariable Integer id){
		timeService.deleteStudentDetailsId(id);
		return  ResponseEntity.ok().build();
	}
	
	@PutMapping("/updateStudentDetails/{id}")
	public ResponseEntity<StudentDetails> updateById(@RequestBody StudentDetails sales ,@PathVariable Integer id){
		return ResponseEntity.ok(timeService.updateById(id, sales));
	}
	
	@GetMapping("/getAllStudentDetails")
	public List<StudentDetails> getAll(){
		return timeService.findAll();
	}
	
	
}
