package com.datetime.TimeDate.domain;


import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import org.apache.tomcat.jni.Time;

@Entity
@SequenceGenerator(sequenceName = "sa", allocationSize = 1, name = "sales_entry_sq", initialValue = 21230)
public class TimeDate {
	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sales_entry_sq")
	private Integer id;
	private Date s_date;
	private String s_time;
	private Date e_date;
	private String e_time;
	
	
	
	public TimeDate() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getS_date() {
		return s_date;
	}
	public void setS_date(Date s_date) {
		this.s_date = s_date;
	}
	public String getS_time() {
		return s_time;
	}
	public void setS_time(String s_time) {
		this.s_time = s_time;
	}
	public Date getE_date() {
		return e_date;
	}
	public void setE_date(Date e_date) {
		this.e_date = e_date;
	}
	public String getE_time() {
		return e_time;
	}
	public void setE_time(String e_time) {
		this.e_time = e_time;
	} 
	
	@Override
	public String toString() {
		return "TimeDate [s_date=" + s_date + ", s_time=" + s_time + ", e_date=" + e_date + ", e_time=" + e_time + "]";
	}
}
