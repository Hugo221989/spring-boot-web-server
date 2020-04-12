package com.restfull.repository;

import java.math.BigDecimal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.restfull.model.Alumno;

@Repository
@Transactional
public interface AlumnoRepository extends JpaRepository<Alumno, BigDecimal>{

}
