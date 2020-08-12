package com.datetime.TimeDate.service;

import java.sql.Time;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

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
		
        long difference ;
        Time t1 = Time.valueOf(timeDate.getS_time()+":00");
        Time t2 = Time.valueOf(timeDate.getE_time()+":00");
        if(t2.getTime() >= t1.getTime()){
            difference = t2.getTime() - t1.getTime() -19800000;
        }
        else{
            difference = t1.getTime() - t2.getTime() -19800000;
        }

        java.sql.Time time = new java.sql.Time(difference); 
        
  

		long diffInMillies = Math.abs(timeDate.getS_date().getTime() - timeDate.getE_date().getTime());
	    String diff = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS)+"";
				timeDate.setDiff(diff+" Days and "+time+" Hrs");
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
		long difference ;
		if (saOptional.isPresent()) {
			Time t1 = Time.valueOf(sales.getS_time()+":00");
	        Time t2 = Time.valueOf(sales.getE_time()+":00");
	        if(t2.getTime() >= t1.getTime()){
	            difference = t2.getTime() - t1.getTime() -19800000;
	        }
	        else{
	            difference = t1.getTime() - t2.getTime() -19800000;
	        }

	        java.sql.Time time2 = new java.sql.Time(difference);
			long diffInMillies = Math.abs(sales.getS_date().getTime() - sales.getE_date().getTime());
		    String diff = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS)+"";
		    sales.setDiff(diff+" Days and "+time2+" Hrs");
			
			sales.setId(id);
			
			time = timeRepository.save(sales);
			
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
