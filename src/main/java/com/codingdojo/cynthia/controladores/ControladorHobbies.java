package com.codingdojo.cynthia.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.codingdojo.cynthia.modelos.Hobby;
import com.codingdojo.cynthia.modelos.Usuario;
import com.codingdojo.cynthia.servicios.Servicios;

@Controller
public class ControladorHobbies {
	
	@Autowired
	private Servicios servicio;
	
	@GetMapping("/asignar/{id}")
	public String asignar(@PathVariable("id") Long id,
						  Model model) {
		
		//Obtener un usuario en base al id que recibimos
		Usuario miUsuario = servicio.findUsuario(id);
		
		//Enviar el objeto de usuario a jsp
		//model.addAttribute("usuario", miUsuario);
		model.addAttribute("usuario", miUsuario);
		
		//Lista de Hobbies
		List<Hobby> hobbies = servicio.encuentraHobbies();
		//model.addAttribute("hobbies", hobbies);
		model.addAttribute("hobbies", hobbies);
		
		return "/hobbies/asignar.jsp";
	}
	
	@PostMapping("/asignarHobby")
	public String asignarHobby(@RequestParam("usuario_id") Long usuario_id,
							   @RequestParam("hobby_id") Long hobby_id) {
		
		//Pendiente llamar a método del servicio que hace la asignación
		
	}
	
}
