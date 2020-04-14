package com.restfull.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.restfull.model.Alumno;
import com.restfull.repository.AlumnoRepository;
import com.restfull.service.IAlumno;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LoginControllerTest {
	
	@Autowired
	private IAlumno alumnoService;
	
	@MockBean
	private AlumnoRepository alumnoRepository;

	@Test
	@DisplayName("Cuando obtengo todos los alumnos")
	public void obtenerAlumnos() {
		when(alumnoRepository.findAll())
		.thenReturn(Stream.of(new Alumno(1, "Hugo", "Onetto", "Barcelona"), 
				new Alumno(2, "Paula", "Barba", "Valencia"))
				.collect(Collectors.toList()));
		assertEquals(2, alumnoService.getAlumnos().size());
	}
	
	@Test
	@DisplayName("Cuando obtengo un alumno por id")
	public void obtenerAlumnoById() {
		Alumno a1 = new Alumno(1, "Hugo", "Onetto", "Barcelona");
//		Alumno a2 = alumnoService.findById(a1.getId());
		when(alumnoRepository.findById(a1.getId())).thenReturn(Stream.of(a1).findFirst());
		assertEquals("Hugo", a1.getNombre());
	}
	
	@Test
	@DisplayName("Cuando inserto un alumno")
	public void guardarAlumno() {
		Alumno a1 = new Alumno(1, "Pedro", "Sanchez", "Alicante");
		alumnoService.saveAlumno(a1);
		ArgumentCaptor<Alumno> captor = ArgumentCaptor.forClass(Alumno.class);
		verify(alumnoRepository, times(1)).save(captor.capture());
		Alumno alumnoCapturado = captor.getValue();
		assertThat(String.valueOf(alumnoCapturado.getId())).isEqualTo(String.valueOf(a1.getId()));
	}
	
	@Test
	@DisplayName("Cuando elimino un alumno")
	public void eliminarAlumno() {
		Alumno a1 = new Alumno(1, "Pedro", "Sanchez", "Alicante");
		alumnoService.deleteAlumno(a1);
		ArgumentCaptor<Alumno> captor = ArgumentCaptor.forClass(Alumno.class);
		verify(alumnoRepository, times(1)).delete(captor.capture());
		Alumno alumnoCapturado = captor.getValue();
		assertThat(alumnoCapturado.getNombre()).isEqualTo(a1.getNombre());
	}
}
