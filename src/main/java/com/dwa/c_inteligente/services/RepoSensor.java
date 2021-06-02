package com.dwa.c_inteligente.services;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.dwa.c_inteligente.models.Sensor;

public interface RepoSensor extends CrudRepository<Sensor, Integer>{
	@Query(value = "SELECT * FROM sensor", nativeQuery = true)
	ArrayList<Sensor> todos();
}
