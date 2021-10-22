package Ciclo3.back.controller;


import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import Ciclo3.back.model.Productos;
import Ciclo3.back.model.ProductosDAO;



@RestController
@CrossOrigin(origins = { "http://localhost:8082" })
public class ProductosController {

	@GetMapping("/producto/borrarProductos")
	public void borrarProductos() {
		ProductosDAO dao =  new ProductosDAO();
		
		dao.unSafeUpdate();
		dao.eliminarProductos();
		dao.safeUpdate();
		
	}
	
	@PutMapping("/producto/registrarProducto")
	public Productos registrarProducto(@RequestBody Productos p) {
		ProductosDAO dao =  new ProductosDAO();
		return dao.registrarProducto(p);	
	}
	@PostMapping("/producto/consultarProducto")
	public Productos consultarProducto(@RequestBody Productos p) {
		ProductosDAO proddao = new ProductosDAO();
		return proddao.consultarProducto(p);
	}
	
}
