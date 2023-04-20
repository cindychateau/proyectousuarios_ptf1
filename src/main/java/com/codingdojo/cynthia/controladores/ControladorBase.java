package com.codingdojo.cynthia.controladores;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController //Nos permite crear URLS y regresa texto u objetos
public class ControladorBase {
	
	@RequestMapping("/") //Me crea la URL "/"
	public String home() {
		return "Hola desde mi controlador!";
	}
	
	@GetMapping("/despliega")
	public String despliegaUsuarios() {
		String usuarios[] = {"Elena de Troya", "Juana de Arco", "Pablo Picasso"};
		String respuesta = "";
		
		/*
		 respuesta = "";
		 respuesta = "" + "<h2>" + "Elena de Troya" + "</h2>"
		 respuesta = "<h2>Elena de Troya</h2>"
		 ---
		 respuesta = "<h2>Elena de Troya</h2>" + "<h2>"+"Juana de Arco"+"</h2>"
		 respuesta = "<h2>Elena de Troya</h2><h2>Juana de Arco</h2>"
		 ---
		 respuesta = "<h2>Elena de Troya</h2><h2>Juana de Arco</h2>" + "<h2>"+"Pablo Picasso"+"</h2>"
		 respuesta = "<h2>Elena de Troya</h2><h2>Juana de Arco</h2><h2>Pablo Picasso</h2>"
		 */
		for(int i=0; i<usuarios.length; i++) {
			respuesta += "<h2>"+usuarios[i]+"</h2>";
		}
		
		return respuesta;
	}
	
	@GetMapping("/hola")
	public String holaNombre(@RequestParam(value="nombre") String name) {
		//name = "Elena"
		return "<h1>Hola"+name+"!</h1>";
	}
	
	@GetMapping("/hola2")
	public String holaNombreApellido(@RequestParam(value="nombre") String name,
									@RequestParam(value="apellido") String last_name) {
		return "<h1>Hola "+name+" "+last_name+"</h1>";
	}
	
	@GetMapping("/hello/{nombre}") // /hello/Elena
	public String helloNombre(@PathVariable("nombre") String name) {
		return "<h1>Hola "+name+"</h1>";
	}
	
	@GetMapping("/hello/{nombre}/{apellido}")
	public String helloNombreApellido(@PathVariable("nombre") String name,
									 @PathVariable("apellido") String last_name) {
		return "<h1>Hola "+name+" "+last_name+"</h1>";
	}
}
