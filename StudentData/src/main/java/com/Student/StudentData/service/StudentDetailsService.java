package com.Student.StudentData.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Student.StudentData.domain.StudentDetails;
import com.Student.StudentData.repository.StudentDetailsRepo;

@Transactional
@Service
public class StudentDetailsService {

	@Autowired
	StudentDetailsRepo timeRepository;
	
	

	
	public StudentDetails save(StudentDetails StudentDetails) {
		
        
		StudentDetails type= timeRepository.save(StudentDetails);
		
		return type;
	}

	public String deleteStudentDetailsId(Integer id) {
		timeRepository.deleteById(id);
		return "Done";
	}

	public StudentDetails updateById(Integer id, StudentDetails sales) {
       
		Optional<StudentDetails> saOptional = timeRepository.findById(id);
		StudentDetails StudentDetails = null;
		if (saOptional.isPresent()) {
			
			
			sales.setId(id);
			
			StudentDetails = timeRepository.save(sales);
			
		}
		return StudentDetails;
	}

	public StudentDetails findById(Integer id) {
		Optional<StudentDetails> salOptional = timeRepository.findById(id);
		StudentDetails sales=null;
		if(salOptional.isPresent()) {
			sales=salOptional.get();
		
		}
		System.out.println(sales);
		return sales;
	}

	public List<StudentDetails> findAll() {
		List<StudentDetails> list = timeRepository.findAll();
		
		return list;
	}
	
}
