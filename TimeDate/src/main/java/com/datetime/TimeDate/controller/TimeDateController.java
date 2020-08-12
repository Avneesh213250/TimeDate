package com.datetime.TimeDate.controller;

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

import com.datetime.TimeDate.domain.TimeDate;
import com.datetime.TimeDate.service.TimeDateService;

@RestController
@CrossOrigin
public class TimeDateController {
    
	@Autowired
	TimeDateService timeService;
	
	@GetMapping("getTimeDateById/{id}")
	public ResponseEntity<TimeDate> getTimeDateById(@PathVariable Integer id) {
		return ResponseEntity.ok(timeService.findById(id));
	}
	
	@PostMapping("/saveTimeDate")
	public ResponseEntity<TimeDate> saveTimeDate(@RequestBody TimeDate timeDate){
		System.out.println(timeDate);
		return ResponseEntity.ok(timeService.save(timeDate));
	}
	
	@SuppressWarnings("rawtypes")
	@DeleteMapping("/deleteTimeDate/{id}")
	public ResponseEntity deleteById(@PathVariable Integer id){
		timeService.deleteTimeDateId(id);
		return  ResponseEntity.ok().build();
	}
	
	@PutMapping("/updateTimeDate/{id}")
	public ResponseEntity<TimeDate> updateById(@RequestBody TimeDate sales ,@PathVariable Integer id){
		return ResponseEntity.ok(timeService.updateById(id, sales));
	}
	
	@GetMapping("/getAllTimeDate")
	public List<TimeDate> getAll(){
		return timeService.findAll();
	}
	
	
}
