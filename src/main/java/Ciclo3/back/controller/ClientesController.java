package Ciclo3.back.controller;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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
	public Clientes consultarCliente(@RequestBody Clientes cli) {
		ClientesDAO clidao = new ClientesDAO();
		return clidao.consultarCliente(cli);
	}
	
	@RequestMapping("/listarClientes")
	public ArrayList<Clientes> listaClientes() {
		ClientesDAO objDAO=new ClientesDAO(); 
			return objDAO.listaClientes();
	}

}
