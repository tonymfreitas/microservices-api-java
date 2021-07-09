package br.com.microservices.loja.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.microservices.loja.client.FornecedorClient;
import br.com.microservices.loja.dto.CompraDTO;
import br.com.microservices.loja.dto.InfoFornecedorDTO;
import br.com.microservices.loja.dto.InfoPedidoDTO;
import br.com.microservices.loja.model.Compra;

@Service
public class CompraService {

//	@Autowired
//	private RestTemplate client;

	@Autowired
	private FornecedorClient client;

	private static final Logger LOG = LoggerFactory.getLogger(CompraService.class);

	// @Autowired
	// private DiscoveryClient eurekaClient; Tem informações das instâncias
	// microservicos

	public Compra realizarCompra(CompraDTO compra) {

		final String estado = compra.getEndereco().getEstado();
		LOG.info(String.format("Buscando informações do fornecedor de %s", estado));

//		ResponseEntity<InfoFornecedorDTO> resposta = client.exchange(
//				"http://fornecedor/info/" + compra.getEndereco().getEstado(), HttpMethod.GET, null,
//				InfoFornecedorDTO.class);
//		
//		List<ServiceInstance> instances = eurekaClient.getInstances("fornecedor");
//		instances.forEach(instance ->  {
//			System.out.println("localhost: " + instance.getPort() );
//		});

		// System.out.println(resposta.getBody().getEndereco());

		LOG.info("Consultando informações do estado");
		InfoFornecedorDTO infoPorEstado = client.getInfoPorEstado(compra.getEndereco().getEstado());
		
		LOG.info("Realizando o pedido");
		InfoPedidoDTO dadosPedidoRealizado = client.realizaPedido(compra.getItens());

		System.out.println(infoPorEstado.getEndereco());

		Compra compraSalva = new Compra();
		compraSalva.setPedidoId(dadosPedidoRealizado.getId());
		compraSalva.setTempoDePreparo(dadosPedidoRealizado.getTempoDePreparo());
		compraSalva.setEnderecoDestino(compra.getEndereco().toString());

		return compraSalva;

	}

}
