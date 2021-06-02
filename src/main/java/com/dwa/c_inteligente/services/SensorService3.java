package com.dwa.c_inteligente.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dwa.c_inteligente.models.Sensor3;

@Service
public class SensorService3 {
	@Autowired
	private RepoSensor3 repoSensor;
	
	private String Mensaje;
	
	public String getMensaje() {
		return Mensaje;
	}
	
	public void setMensaje(String mensaje) {
		Mensaje = mensaje;
	}
	
	public boolean agregar(Sensor3 sensor) {
		try {
			repoSensor.save(sensor);
			this.Mensaje="Datos registrado con exito";
			return true;
		} catch(Exception e){
			this.Mensaje="Error al registrar";
			return false;
		}
	}
	
	public Iterable<Sensor3> verTodos(){
		try {
			this.Mensaje="";
			return repoSensor.todos();
		} catch(Exception e) {
			this.Mensaje=e.getMessage();
			return null;
		}
	}
	
	public Sensor3 buscar(int id) {
		try {
			this.Mensaje="";
			Sensor3 sensor = repoSensor.findById(id).get();
			return sensor == null ? new Sensor3() : sensor;
		} catch(Exception e) {
			
			this.Mensaje = e.getMessage();
			return null;
		}
	}
}
