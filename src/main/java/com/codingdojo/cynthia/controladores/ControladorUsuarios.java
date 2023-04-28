package com.codingdojo.cynthia.controladores;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.codingdojo.cynthia.modelos.Usuario;
import com.codingdojo.cynthia.servicios.Servicios;

@Controller //Regresar un JSP
public class ControladorUsuarios {
	
	@Autowired
	private Servicios servicio;
	
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
	public String dashboard(Model model) {
		
		//Una lista de todos los usuarios
		List<Usuario> usuarios = servicio.findUsuarios();
		//model.addAttribute("usuarios", usuario);
		model.addAttribute("usuarios", usuarios);
		
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
	
	@GetMapping("/new")
	public String newUser(@ModelAttribute("usuario") Usuario usuario) {
		return "new.jsp";
	}
	
	@PostMapping("/create") //@Valid me permite validar la info del objeto usuario
	public String createUser(@Valid @ModelAttribute("usuario") Usuario usuario,
							 BindingResult result /*Encargado de mensajes de valid*/) {
		
		if(result.hasErrors()) {
			return "new.jsp";
		}else {
			servicio.saveUsuario(usuario);
			return "redirect:/dashboard";
		}
		
	}
	
	@GetMapping("/mostrar/{id}")
	public String showUser(@PathVariable("id") Long id,
						   Model model) {
		
		//obtenemos un obj usuario en base al método del servicio que hicimos
		Usuario esteEsUsuario = servicio.findUsuario(id);
		
		//model.addAttribute("usuario", user);
		model.addAttribute("persona", esteEsUsuario);
		
		return "mostrar.jsp";
	}
	
	@DeleteMapping("/borrar/{id}")
	public String borrarUsuario(@PathVariable("id") Long id) {
		servicio.deleteUsuario(id);
		return "redirect:/dashboard";
	}
	
	@GetMapping("/editar/{id}") // /editar/1
	public String editarUsuario(@PathVariable("id") Long id,
								@ModelAttribute("usuario") Usuario usuario,
								Model model) {
		
		//Objeto de usuario al que pertenece el id de la ruta
		Usuario usuarioEdit = servicio.findUsuario(id);
		
		//model.addAttribute("usuario", usuarioEdit);
		model.addAttribute("usuario", usuarioEdit);
		
		return "editar.jsp";
	}
	
	@PutMapping("/update/{id}")
	public String updateUsuario(@Valid @ModelAttribute("usuario") Usuario usuario,
								BindingResult result) {
		if(result.hasErrors()) {
			return "editar.jsp";
		} else {
			servicio.saveUsuario(usuario);
			return "redirect:/dashboard";
		}
	}
	
	
}
