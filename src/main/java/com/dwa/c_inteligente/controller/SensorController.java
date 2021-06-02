package com.dwa.c_inteligente.controller;


import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dwa.c_inteligente.models.Sensor;
import com.dwa.c_inteligente.models.Sensor2;
import com.dwa.c_inteligente.models.Sensor3;
import com.dwa.c_inteligente.services.RepoSensor;
import com.dwa.c_inteligente.services.RepoSensor2;
import com.dwa.c_inteligente.services.RepoSensor3;
import com.dwa.c_inteligente.services.SensorService;
import com.dwa.c_inteligente.services.SensorService2;
import com.dwa.c_inteligente.services.SensorService3;

@Controller
@RequestMapping
public class SensorController {
	
	@Autowired
	SensorService servicioSensor;
	
	@Autowired
	SensorService2 servicioSensor2;
	
	@Autowired
	SensorService3 servicioSensor3;
	
	@Autowired
	private RepoSensor repoSensor;
	
	@Autowired
	private RepoSensor2 repoSensor2;
	
	@Autowired
	private RepoSensor3 repoSensor3;
	
	@GetMapping(path = {"sitio/index", "/"})
	public String validar(Model modelo, @ModelAttribute Sensor s, HttpServletRequest request) {
		Iterable<Sensor> sensores = servicioSensor.verTodos();
		Iterable<Sensor2> sensores2 = servicioSensor2.verTodos();
		Iterable<Sensor3> sensores3 = servicioSensor3.verTodos();
		
		if(sensores != null || sensores2 != null || sensores3 != null) {
			modelo.addAttribute("sensores", sensores);
			modelo.addAttribute("sensores2", sensores2);
			modelo.addAttribute("sensores3", sensores3);
		}
		else {
			modelo.addAttribute("error", "Aun no hay temas registrados");
		}
		modelo.addAttribute("sensor", new Sensor());
		if(!servicioSensor.getMensaje().equals("")) {
			modelo.addAttribute("error", servicioSensor.getMensaje());
		}
		
		int lenght = (int) repoSensor.count();
		int total = 0;
		int res = 0;
	    
		for (Sensor p: servicioSensor.verTodos()) {
	    	total = total + p.getTcorporal();
	    	res = total /lenght;
	    }
		String final1 = res + "°C";
	    modelo.addAttribute("total", final1);
	    
	    
	    int lenght2 = (int) repoSensor2.count();
	    int total2 = 0;
		int res2 = 0;
	    for (Sensor2 p: servicioSensor2.verTodos()) {
	    	total2 = total2 + p.getTcorporal();
	    	res2 = total2 /lenght2;
	    }
	    String final2 = res2 + "°C";
	    modelo.addAttribute("total2", final2);
	    
	    int lenght3 = (int) repoSensor3.count();
	    int total3 = 0;
		int res3 = 0;
	    for (Sensor3 p: servicioSensor3.verTodos()) {
	    	total3 = total3 + p.getTcorporal();
	    	res3 = total3 /lenght3;
	    }
	    String final3 = res3 + "°C";
	    modelo.addAttribute("total3", final3);
	    
		return "sitio/index";
	}
	
	@GetMapping("/sitio/contacto")
	public String contacto() {
		return "sitio/contacto";
	}
	
	@GetMapping("/sitio/acercade")
	public String acercade() {
		return "sitio/acercade";
	}

	//PRIMER SENSOR
	@GetMapping("/sitio/simulacion")
	public String listar(Model modelo) {
		Iterable<Sensor> sensores = servicioSensor.verTodos();
		if(sensores != null) {
			modelo.addAttribute("sensores", sensores);
		}
		else {
			modelo.addAttribute("error", "Aun no hay temas registrados");
		}
		modelo.addAttribute("sensor", new Sensor());
		if(!servicioSensor.getMensaje().equals("")) {
			modelo.addAttribute("error", servicioSensor.getMensaje());
		}
		return "sitio/simulacion";
	}

	@PostMapping("/sitio/simulacion")
	public String listar(Model modelo, @ModelAttribute Sensor sensor) {
		boolean res = servicioSensor.agregar(sensor);
		if(res) {
			return "redirect:/sitio/simulacion";
		}
		modelo.addAttribute("error", servicioSensor.getMensaje());
		return "sitio/simulacion";
	}
	
	
	//SEGUNDO SENSOR
	@GetMapping("/sitio/simulacion2")
	public String listar2(Model modelo) {
		Iterable<Sensor2> sensores = servicioSensor2.verTodos();
		if(sensores != null) {
			modelo.addAttribute("sensores2", sensores);
		}
		else {
			modelo.addAttribute("error", "Aun no hay temas registrados");
		}
		modelo.addAttribute("sensor2", new Sensor2());
		if(!servicioSensor2.getMensaje().equals("")) {
			modelo.addAttribute("error", servicioSensor2.getMensaje());
		}
		return "sitio/simulacion2";
	}

	@PostMapping("/sitio/simulacion2")
	public String listar(Model modelo, @ModelAttribute Sensor2 sensor) {
		boolean res = servicioSensor2.agregar(sensor);
		if(res) {
			return "redirect:/sitio/simulacion2";
		}
		modelo.addAttribute("error", servicioSensor2.getMensaje());
		return "sitio/simulacion2";
	}
	
	//TERCER SENSOR
		@GetMapping("/sitio/simulacion3")
		public String listar3(Model modelo) {
			Iterable<Sensor3> sensores = servicioSensor3.verTodos();
			if(sensores != null) {
				modelo.addAttribute("sensores3", sensores);
			}
			else {
				modelo.addAttribute("error", "Aun no hay temas registrados");
			}
			modelo.addAttribute("sensor3", new Sensor3());
			if(!servicioSensor3.getMensaje().equals("")) {
				modelo.addAttribute("error", servicioSensor3.getMensaje());
			}
			return "sitio/simulacion3";
		}

		@PostMapping("/sitio/simulacion3")
		public String listar(Model modelo, @ModelAttribute Sensor3 sensor) {
			boolean res = servicioSensor3.agregar(sensor);
			if(res) {
				return "redirect:/sitio/simulacion3";
			}
			modelo.addAttribute("error", servicioSensor3.getMensaje());
			return "sitio/simulacion3";
		}
	
	
}
