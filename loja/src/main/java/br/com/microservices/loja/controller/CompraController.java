package br.com.microservices.loja.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.microservices.loja.dto.CompraDTO;
import br.com.microservices.loja.model.Compra;
import br.com.microservices.loja.service.CompraService;

@RestController
@RequestMapping("/compra")
public class CompraController {
	
	@Autowired
	private CompraService compraService;
	
	@PostMapping
	public Compra realizarCompra(@RequestBody CompraDTO compra) {
		return compraService.realizarCompra(compra);
	}

}
