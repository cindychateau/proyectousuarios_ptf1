package com.codingdojo.cynthia.repositorios;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.cynthia.modelos.Direccion;

@Repository
public interface RepositorioDirecciones extends CrudRepository<Direccion, Long> {
	
	List<Direccion> findAll();
	
}
