package com.senac.emissor.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.senac.emissor.dto.ProdutoDto;
import com.senac.emissor.services.ProdutoService;

@RestController
@RequestMapping(value="/produtos")
public class ProdutoController {
	
	private ProdutoService produtoService; 
	
	public ProdutoController(ProdutoService produtoService) {
		this.produtoService = produtoService;
	}

	@GetMapping
	public ResponseEntity<List<ProdutoDto>> listarProdutos(){
		return new ResponseEntity<>(this.produtoService.listarProdutos(), HttpStatus.OK);
	}

}
