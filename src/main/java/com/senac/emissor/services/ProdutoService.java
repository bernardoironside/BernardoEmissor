package com.senac.emissor.services;

import java.util.List;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.senac.emissor.dto.ProdutoDto;

@Service
public class ProdutoService {

	@Autowired
		private RabbitTemplate rabbitTemplate;
	
	public List<ProdutoDto> listarProdutos(){
		rabbitTemplate.convertAndSend("fila-get-produto","listar");
		return null;
	}
}
