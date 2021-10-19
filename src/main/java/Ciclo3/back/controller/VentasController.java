package Ciclo3.back.controller;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Ciclo3.back.model.Clientes;
import Ciclo3.back.model.ClientesDAO;
import Ciclo3.back.model.Ventas;
import Ciclo3.back.model.VentasDAO;


@RestController
public class VentasController {
	@PostMapping("/venta/crearVenta")
	public Ventas crearVenta(@RequestBody Ventas ven) {
		VentasDAO ventadao = new VentasDAO();
		return ventadao.ingresarVenta(ven);
	}
	
	@RequestMapping("/reportes/listarVentas")
	public ArrayList<Ventas> listarVentas() {
		VentasDAO objDAO=new VentasDAO(); 
			return objDAO.listarVentas();
	}
	
	

}