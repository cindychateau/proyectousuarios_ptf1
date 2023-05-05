package com.codingdojo.cynthia.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.cynthia.modelos.Direccion;
import com.codingdojo.cynthia.modelos.Hobby;
import com.codingdojo.cynthia.modelos.Salon;
import com.codingdojo.cynthia.modelos.Usuario;
import com.codingdojo.cynthia.repositorios.RepositorioDirecciones;
import com.codingdojo.cynthia.repositorios.RepositorioHobbies;
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
	
	@Autowired
	private RepositorioHobbies repoHobbies;
	
	/*
	 private final RepositorioHobbies repoHobbies;
	 
	 public Servicio(RepositorioHobbies repoHobbies){
	 	this.repoHobbies = repoHobbies
	 }
	 
	 */
	
	
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
	
	//Regresa una lista de hobbies
	public List<Hobby> encuentraHobbies() {
		return repoHobbies.findAll();
	}
	
	//Regresa un hobby en base a su ID
	public Hobby encuentraUnHobby(Long id) {
		return repoHobbies.findById(id).orElse(null);
	}
	/*
	 * usuario_id = 1
	 * hobby_id = 4
	 *
	 * miUsuario = Obj(Elena)
	 * miHobby = Obj(Tocar el Piano)
	 * 
	 * listaHobbies = {"Leer"}
	 * listaHobbies = {"Leer", "Tocar el Piano"}
	 * 
	 * Guardamos a Elena
	 *
	 */
	public void guardarUsuarioHobby(Long usuario_id, Long hobby_id) {
		//Obtenemos el objeto de usuario al que queremos agregar el hobby
		Usuario miUsuario = findUsuario(usuario_id);
		
		//Obtenemos el objeto de hobby
		Hobby miHobby = encuentraUnHobby(hobby_id);
		
		//Lista de Hobbies del usuario
		List<Hobby> listaHobbies = miUsuario.getHobbies();
		listaHobbies.add(miHobby);
		
		/*
		 * List<Usuario> listaUsuarios = miHobby.getUsuarios();
		 * listaUsuarios.add(miUsuario);
		 * repoHobbies.save(miHobby);
		 */
		
		repoUsuarios.save(miUsuario); //Actualizando
		
	}
	/*
	 * usuario_id = 6
	 * hobby_id = 1
	 * miUsuario = obj(Pablo Picasso)
	 * miHobby = obj(Leer)
	 * listaHobbies = {Leer, Pintar}
	 * listaHobbies = {Pintar}
	 * Guardo miUsuario
	 * 
	 */
	public void quitarUsuarioHobby(Long usuario_id, Long hobby_id) {
		//Obtenemos el objeto de usuario al que queremos quitar el hobby
		Usuario miUsuario = findUsuario(usuario_id);
		
		//Obtenemos el objeto de hobby
		Hobby miHobby = encuentraUnHobby(hobby_id);
		
		//Lista de Hobbies del usuario
		List<Hobby> listaHobbies = miUsuario.getHobbies();
		listaHobbies.remove(miHobby);
		
		repoUsuarios.save(miUsuario);
	}
	
}
