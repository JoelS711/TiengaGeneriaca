package Ciclo3.back.controller;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Ciclo3.back.model.Proveedores;
import Ciclo3.back.model.ProveedoresDAO;


@RestController
public class ProveedoresController {

	@RequestMapping("/listarProveedores")
	public ArrayList<Proveedores> listaProveedores() {
		ProveedoresDAO objeDAO=new ProveedoresDAO(); 
			return objeDAO.listaProveedores();
	}
	
	@PostMapping("/proveedor/crearProveedor")
	public Proveedores crearProveedor(@RequestBody Proveedores pro) {
		ProveedoresDAO prodao = new ProveedoresDAO();
		return prodao.ingresarProveedor(pro);
	}
	
	@PostMapping("/proveedor/actualizarProveedor")
	public Proveedores actualizarProveedor(@RequestBody Proveedores pro) {
		ProveedoresDAO prodao = new ProveedoresDAO();
		return prodao.actualizarProveedor(pro);
	}
	
	@PostMapping("/proveedor/consultarProveedor")
	public Proveedores consultarProveedor(@RequestBody Proveedores pro) {
		ProveedoresDAO prodao = new ProveedoresDAO();
		return prodao.consultarProveedor(pro);
	}
	
	@PostMapping("/proveedor/eliminarProveedor")
	public Proveedores eliminarProveedor(@RequestBody Proveedores pro) {
		ProveedoresDAO prodao = new ProveedoresDAO();
		return prodao.borrarProveedor(pro);
	}
}
