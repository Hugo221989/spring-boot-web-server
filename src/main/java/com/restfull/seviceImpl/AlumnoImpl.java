package com.restfull.seviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restfull.model.Alumno;
import com.restfull.repository.AlumnoRepository;
import com.restfull.service.IAlumno;

@Service
public class AlumnoImpl implements IAlumno {

	@Autowired
	private AlumnoRepository alumnoRepository;
	@Override
	public List<Alumno> getAlumnos() {
		// TODO Auto-generated method stub
		return alumnoRepository.findAll();
	}
	@Override
	public void saveAlumno(Alumno a) {
		alumnoRepository.save(a);
		
	}
	@Override
	public void deleteAlumno(Alumno a1) {
		alumnoRepository.delete(a1);
	}
	@Override
	public Alumno findById(int id) {
		// TODO Auto-generated method stub
		return alumnoRepository.findById(id).orElse(null);
	}


}
