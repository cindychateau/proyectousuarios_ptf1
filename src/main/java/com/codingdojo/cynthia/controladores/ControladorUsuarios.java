package com.codingdojo.cynthia.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller //Regresar un JSP
public class ControladorUsuarios {
	
	@GetMapping("/home")
	public String home() {
		return "index.jsp";
	}
	
	@GetMapping("/muestraUsuario")
	public String muestraUsuario(Model model) {
		
		model.addAttribute("titulo", "Usuarios");
		
		String usuarios[] = {"Elena de Troya", "Juana de Arco", "Pablo Picasso"};
		
		model.addAttribute("users", usuarios);
		
		return "usuario.jsp";
	}
	
}
