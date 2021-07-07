package br.com.microservices.loja.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.microservices.loja.dto.CompraDTO;

@RestController
@RequestMapping("/compra")
public class CompraController {
	
	@PostMapping
	public String realizarCompra(@RequestBody CompraDTO compra) {
		return null;
	}

}
