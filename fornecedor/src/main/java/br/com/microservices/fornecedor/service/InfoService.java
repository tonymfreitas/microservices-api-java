package br.com.microservices.fornecedor.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.microservices.fornecedor.model.InfoFornecedor;
import br.com.microservices.fornecedor.repository.InfoRepository;

@Service
public class InfoService {

	@Autowired
	private InfoRepository repository;
	
	public InfoFornecedor getInforPorEstado(String estado) {
		return repository.findByEstado(estado);
	}

}
