package com.codingdojo.cynthia.repositorios;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.cynthia.modelos.Usuario;

@Repository
public interface RepositorioUsuarios extends CrudRepository<Usuario, Long> {
	
	List<Usuario> findAll(); //SELECT * FROM usuarios
	
	//INSERT INTO usuarios(first_name, last_name.....) VALUES(Datos de Objeto usuario)
	//UPDATE usuarios SET first_name = VALOR de OBjeto
	Usuario save(Usuario nuevoUsuario); //Objeto de usuario
	
	void deleteById(Long id); //DELETE from usuarios WHERE id = <id que recibimos>
	
	List<Usuario> findByEmail(String email); //SELECT * FROM usuarios WHERE email = <email que recibimos>
	
	//SELECT * FROM usuarios WHERE first_name LIKE '<nombre>%';
	List<Usuario> findByFirstNameStartingWith(String nombre);
}
