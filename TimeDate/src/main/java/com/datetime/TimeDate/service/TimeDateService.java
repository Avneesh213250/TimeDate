package com.datetime.TimeDate.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.datetime.TimeDate.domain.TimeDate;
import com.datetime.TimeDate.repository.TimeRepo;

@Transactional
@Service
public class TimeDateService {

	@Autowired
	TimeRepo timeRepository;
	

	
	public TimeDate save(TimeDate timeDate) {
		TimeDate type= timeRepository.save(timeDate);
		
		return type;
	}

	public String deleteTimeDateId(Integer id) {
		timeRepository.deleteById(id);
		return "Done";
	}

	public TimeDate updateById(Integer id, TimeDate sales) {
       
		Optional<TimeDate> saOptional = timeRepository.findById(id);
		TimeDate time = null;
		if (saOptional.isPresent()) {
			System.out.println(saOptional);
			sales.setId(id);
			
			time = timeRepository.save(sales);
			System.out.println(time);
		}
		return time;
	}

	public TimeDate findById(Integer id) {
		Optional<TimeDate> salOptional = timeRepository.findById(id);
		TimeDate sales=null;
		if(salOptional.isPresent()) {
			sales=salOptional.get();
		
		}
		System.out.println(sales);
		return sales;
	}

	public List<TimeDate> findAll() {
		List<TimeDate> list = timeRepository.findAll();
		
		return list;
	}
	
}
