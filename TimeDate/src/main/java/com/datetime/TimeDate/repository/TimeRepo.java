package com.datetime.TimeDate.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.datetime.TimeDate.domain.TimeDate;

public interface TimeRepo extends JpaRepository<TimeDate, Integer> {

}
