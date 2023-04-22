package com.codingdojo.cynthia.controladores;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller //Regresar un JSP
public class ControladorUsuarios {
	
	@GetMapping("/home")
	public String home() {
		return "index.jsp";
	}
	
	@GetMapping("/muestraUsuario")
	public String muestraUsuario(Model model,
								 HttpSession session) {
		
		model.addAttribute("titulo", "Usuarios");
		
		String usuarios[] = {"Elena de Troya", "Juana de Arco", "Pablo Picasso"};
		
		model.addAttribute("users", usuarios);
		
		String nombre = (String) session.getAttribute("name");
		System.out.println(nombre);
		
		if(nombre == null) {
			System.out.println("No inicio sesion");
		} else {
			System.out.println("Ya inicio sesion");
		}
		
		return "usuario.jsp";
	}
	
	@GetMapping("/sesion/{nombre}") // /sesion/Elena
	public String sesion(@PathVariable("nombre") String nombre, /*nombre = "Elena"*/
						 HttpSession session /*Agrego sesión a mi método*/ ) {
		
		session.setAttribute("name", nombre); //session.setAttribute("name", nombre);
		
		return "bienvenida.jsp";
	}
	
	//Muestra formulario
	@GetMapping("/registro")
	public String registro() {
		return "registro.jsp";
	}
	
	//Muestra dashboard
	@GetMapping("/dashboard") 
	public String dashboard() {
		return "dashboard.jsp";
	}
	
	//Recibe info del formulario
	@PostMapping("/registrarme")
	public String registrarme(@RequestParam(value="nombre") String nombre,
							  @RequestParam(value="email") String email,
							  HttpSession session,
							  RedirectAttributes flash /*Se agrega para enviar msg validación*/) {
		
		System.out.println(nombre);
		System.out.println(email);
		
		//Validación
		if(nombre.equals("")) {
			//flash.addFlashAttribute("errorNombre", "Por favor proporciona tu  nombre");
			flash.addFlashAttribute("errorNombre", "Por favor proporciona tu  nombre");
			return "redirect:/registro";
		}
		
		//Guardamos en sesion
		session.setAttribute("username", nombre); //(variable, valor)
		
		return "redirect:/dashboard";
		
	}
	
}
