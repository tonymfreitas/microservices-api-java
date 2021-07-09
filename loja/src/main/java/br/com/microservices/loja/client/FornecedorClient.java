package br.com.microservices.loja.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import br.com.microservices.loja.dto.InfoFornecedorDTO;
import br.com.microservices.loja.dto.InfoPedidoDTO;
import br.com.microservices.loja.dto.ItemDaCompra;

@FeignClient("fornecedor") // Nome do microservico
public interface FornecedorClient {

	@GetMapping("/info/{estado}")
	InfoFornecedorDTO getInfoPorEstado(@PathVariable String estado);

	@PostMapping("/pedido")
	InfoPedidoDTO realizaPedido(List<ItemDaCompra> itens);

}
