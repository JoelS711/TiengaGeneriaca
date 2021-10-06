package Ciclo3.back.controller;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Ciclo3.back.model.Usuarios;
import Ciclo3.back.model.UsuariosDAO;

@RestController
public class UsuariosController {
	@PostMapping("/auth")
	public Usuarios auth(@RequestBody Usuarios usr) {
		UsuariosDAO usudao = new UsuariosDAO();
		return usudao.validar(usr);
	}
	
	@RequestMapping("/listarUsuarios")
	public ArrayList<Usuarios> listaUsuarios() {
		UsuariosDAO objDAO=new UsuariosDAO(); 
			return objDAO.listaUsuarios();
		
	}
	
	@PostMapping("/usuario/crearUsuario")
	public Usuarios crearUsuario(@RequestBody Usuarios usr) {
		UsuariosDAO usudao = new UsuariosDAO();
		return usudao.ingresarUsuario(usr);
	}
	
	@PostMapping("/usuario/actualizarUsuario")
	public Usuarios actualizarUsuario(@RequestBody Usuarios usr) {
		UsuariosDAO usudao = new UsuariosDAO();
		return usudao.actualizarUsuario(usr);
	}
}
