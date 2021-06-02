package com.dwa.c_inteligente.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dwa.c_inteligente.models.Sensor2;

@Service
public class SensorService2 {
	@Autowired
	private RepoSensor2 repoSensor;
	
	private String Mensaje;
	
	public String getMensaje() {
		return Mensaje;
	}
	
	public void setMensaje(String mensaje) {
		Mensaje = mensaje;
	}
	
	public boolean agregar(Sensor2 sensor) {
		try {
			repoSensor.save(sensor);
			this.Mensaje="Datos registrado con exito";
			return true;
		} catch(Exception e){
			this.Mensaje="Error al registrar";
			return false;
		}
	}
	
	public Iterable<Sensor2> verTodos(){
		try {
			this.Mensaje="";
			return repoSensor.todos();
		} catch(Exception e) {
			this.Mensaje=e.getMessage();
			return null;
		}
	}
	
	public Sensor2 buscar(int id) {
		try {
			this.Mensaje="";
			Sensor2 sensor = repoSensor.findById(id).get();
			return sensor == null ? new Sensor2() : sensor;
		} catch(Exception e) {
			
			this.Mensaje = e.getMessage();
			return null;
		}
	}
}
