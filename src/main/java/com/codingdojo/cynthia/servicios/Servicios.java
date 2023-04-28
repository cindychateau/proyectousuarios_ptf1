package com.codingdojo.cynthia.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.cynthia.modelos.Usuario;
import com.codingdojo.cynthia.repositorios.RepositorioUsuarios;

@Service
public class Servicios {
	
	@Autowired //Que no sea una instancia
	private RepositorioUsuarios repoUsuarios;
	
	//Me regresa una lista con todos los usuarios
	public List<Usuario> findUsuarios() {
		return repoUsuarios.findAll();
	}
	
	//Guardamos un usuario
	public Usuario saveUsuario(Usuario nuevoUsuario) {
		return repoUsuarios.save(nuevoUsuario);
	}
	
	//Me regresa un usuario en base a su ID
	public Usuario findUsuario(Long id) {
		//SELECT * FROM usuarios WHERE id = <id>
		return repoUsuarios.findById(id).orElse(null); //Me regresa un objeto Usuario
	}
	
	//Borrar usuario en base a su ID
	public void deleteUsuario(Long id) {
		repoUsuarios.deleteById(id); //DELETE FROM usuario WHERE id = <id>
	}
	
}
