package com.dwa.c_inteligente.services;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.dwa.c_inteligente.models.Sensor2;

public interface RepoSensor2 extends CrudRepository<Sensor2, Integer>{
	@Query(value = "SELECT * FROM sensor2", nativeQuery = true)
	ArrayList<Sensor2> todos();
}