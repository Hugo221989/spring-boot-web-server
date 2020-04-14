package com.restfull.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.restfull.model.Alumno;
import com.restfull.service.IAlumno;


@RestController
@RequestMapping("/login")
public class LoginController {
	
	@Autowired
	private IAlumno alumnoService;
	
	@GetMapping("/")
	public ResponseEntity<String> obtenerAlumnos( ){
		List<Alumno> alumnos = alumnoService.getAlumnos();
		String alumnosString = "";
		System.out.println("ALUMNOS:");
		for(Alumno a: alumnos) {
			System.out.println(a.getNombre() +" - "+ a.getCiudad());
			alumnosString += a.getNombre() +" - "+ a.getCiudad() +" \n";
		}
        
		return ResponseEntity.ok(alumnosString);
	}

}
