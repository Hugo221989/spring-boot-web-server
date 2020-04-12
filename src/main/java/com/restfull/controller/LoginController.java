package com.restfull.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.restfull.model.Alumno;
import com.restfull.repository.AlumnoRepository;


@RestController
@RequestMapping("/login")
public class LoginController {
	
	@Autowired
	private AlumnoRepository alumnoRepository;
	
	@GetMapping("/")
	public ResponseEntity<String> obtenerClienteSda( HttpServletResponse response){
		List<Alumno> alumnos = alumnoRepository.findAll();
		String alumnosString = "";
		for(Alumno a: alumnos) {
			System.out.println(a.getNombre() +" - "+ a.getCiudad());
			alumnosString += a.getNombre() +" - "+ a.getCiudad() +" \n";
		}
		PrintWriter out;
		try {
			out = response.getWriter();
			for(Alumno a: alumnos) {
				out.print(a.getNombre() +" - "+ a.getCiudad());
				
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        
		return ResponseEntity.ok(alumnosString);
	}

}
