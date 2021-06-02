package com.dwa.c_inteligente.services;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.dwa.c_inteligente.models.Sensor3;

public interface RepoSensor3 extends CrudRepository<Sensor3, Integer>{
	@Query(value = "SELECT * FROM sensor3", nativeQuery = true)
	ArrayList<Sensor3> todos();
}