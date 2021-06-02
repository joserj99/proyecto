package com.dwa.c_inteligente.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dwa.c_inteligente.models.Sensor;

@Service
public class SensorService{
	
	@Autowired
	private RepoSensor repoSensor;
	
	private String Mensaje;
	
	public String getMensaje() {
		return Mensaje;
	}
	
	public void setMensaje(String mensaje) {
		Mensaje = mensaje;
	}
	
	public boolean agregar(Sensor sensor) {
		try {
			repoSensor.save(sensor);
			this.Mensaje="Datos registrado con exito";
			return true;
		} catch(Exception e){
			this.Mensaje="Error al registrar";
			return false;
		}
	}
	
	public Iterable<Sensor> verTodos(){
		try {
			this.Mensaje="";
			return repoSensor.todos();
		} catch(Exception e) {
			this.Mensaje=e.getMessage();
			return null;
		}
	}
	
	public Sensor buscar(int id) {
		try {
			this.Mensaje="";
			Sensor sensor = repoSensor.findById(id).get();
			return sensor == null ? new Sensor() : sensor;
		} catch(Exception e) {
			
			this.Mensaje = e.getMessage();
			return null;
		}
	}
	
	
}
