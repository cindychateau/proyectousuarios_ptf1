package com.codingdojo.cynthia.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.cynthia.modelos.Direccion;
import com.codingdojo.cynthia.modelos.Salon;
import com.codingdojo.cynthia.modelos.Usuario;
import com.codingdojo.cynthia.repositorios.RepositorioDirecciones;
import com.codingdojo.cynthia.repositorios.RepositorioSalones;
import com.codingdojo.cynthia.repositorios.RepositorioUsuarios;

@Service
public class Servicios {
	
	@Autowired //Que no sea una instancia
	private RepositorioUsuarios repoUsuarios;
	
	@Autowired
	private RepositorioDirecciones repoDirecciones;
	
	@Autowired
	private RepositorioSalones repoSalones;
	
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
	
	//Guardar una direccion
	public Direccion guardarDireccion(Direccion nuevaDireccion) {
		return repoDirecciones.save(nuevaDireccion);
	}
	
	//Regrese una lista de usuarios sin direccion
	public List<Usuario> usuariosSinDireccion() {
		return repoUsuarios.findByDireccionIdIsNull();
	}
	
	//Regrese una lista de salones
	public List<Salon> encuentraSalones() {
		return repoSalones.findAll();
	}
	
}
