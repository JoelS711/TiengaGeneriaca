package Ciclo3.back.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import Ciclo3.back.model.Clientes;
import Ciclo3.back.model.ClientesDAO;

@RestController
public class ClientesController {
	
	@PostMapping("/cliente/actualizarCliente")
	public Clientes actualizarCliente(@RequestBody Clientes cli) {
		ClientesDAO clidao = new ClientesDAO();
		return clidao.actualizarCliente(cli);
	}
	@PostMapping("/cliente/eliminarCliente")
	public Clientes eliminarCliente(@RequestBody Clientes cli) {
		ClientesDAO clidao = new ClientesDAO();
		return clidao.borrarCliente(cli);
	}
	@PostMapping("/cliente/consultarCliente")
	public Clientes consultarCiente(@RequestBody Clientes cli) {
		ClientesDAO clidao = new ClientesDAO();
		return clidao.consultarCliente(cli);
	}

}
