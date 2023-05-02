package com.codingdojo.cynthia.controladores;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.codingdojo.cynthia.modelos.Direccion;
import com.codingdojo.cynthia.modelos.Usuario;
import com.codingdojo.cynthia.servicios.Servicios;

@Controller
public class ControladorDirecciones {
	
	@Autowired
	private Servicios servicio;
	
	@GetMapping("/direcciones/nueva")
	//@ModelAttribute envía un objeto dirección vacío. Formulario se llenen los atributos
	public String nuevaDireccion(@ModelAttribute("direccion") Direccion direccionEnMetodo,
								 Model model) {
		
		List<Usuario> listaUsuarios =  servicio.usuariosSinDireccion();
		
		//model.addAttribute("usuarios", listaUsuarios);
		model.addAttribute("usuarios", listaUsuarios);
		
		//direccionEnMetodo.setCalle("Calle ejemplo");
		
		//variable direccion se usa en el método
		return "/direcciones/nueva.jsp";
	}
	
	@PostMapping("/direcciones/crear")
	public String crearDireccion(@Valid @ModelAttribute("direccion") Direccion direccionNueva,
								 BindingResult result,
								 Model model) {
		
		if(result.hasErrors()) {
			List<Usuario> listaUsuarios =  servicio.usuariosSinDireccion();
			//model.addAttribute("usuarios", listaUsuarios);
			model.addAttribute("usuarios", listaUsuarios);
			
			return "/direcciones/nueva.jsp";
		} else {
			servicio.guardarDireccion(direccionNueva);
			return "redirect:/dashboard";
		}
		
	}
	
}
