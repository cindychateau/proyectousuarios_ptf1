package com.codingdojo.cynthia.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.codingdojo.cynthia.modelos.Usuario;
import com.codingdojo.cynthia.servicios.Servicios;

@RestController
public class ControladorAPI {
	
	@Autowired
	private Servicios servicio;
	
	@GetMapping("/api/usuarios")
	public List<Usuario> apiMuestraUsuarios(){
		return servicio.findUsuarios();
	}
	
	@PostMapping("/api/usuarios")
	public Usuario apiCrear(@RequestParam("firstName") String firstName,
							@RequestParam("lastName") String lastName,
							@RequestParam("email") String email,
							@RequestParam("password") String password) {
		
		Usuario nuevoUsuario = new Usuario(firstName, lastName, email, password);
		return servicio.saveUsuario(nuevoUsuario);
	}
	
	@DeleteMapping("/api/usuarios/{id}")
	public void apiBorrar(@PathVariable("id") Long id) {
		servicio.deleteUsuario(id);
	}
	
	@GetMapping("/api/usuarios/{id}")
	public Usuario apiMostrar(@PathVariable("id") Long id) {
		return servicio.findUsuario(id);
	}
	
	@PutMapping("/api/usuarios/{id}")
	public Usuario apiActualizar(@PathVariable("id") long id,
								@RequestParam("firstName") String firstName,
								@RequestParam("lastName") String lastName,
								@RequestParam("email") String email,
								@RequestParam("password") String password) {
		
		Usuario usuarioActualizado = new Usuario(id, firstName, lastName, email, password);
		return servicio.saveUsuario(usuarioActualizado);
		
	}
	
}
