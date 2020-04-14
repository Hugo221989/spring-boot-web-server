package com.restfull.service;

import java.util.List;
import com.restfull.model.Alumno;


public interface IAlumno {
	public List<Alumno> getAlumnos();
	public void saveAlumno(Alumno a);
	public void deleteAlumno(Alumno a1);
	public Alumno findById(int id);
}
