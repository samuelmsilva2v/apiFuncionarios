package com.example.demo.application.controllers;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.models.dtos.FuncionarioRequestDto;
import com.example.demo.domain.models.dtos.FuncionarioResponseDto;
import com.example.demo.domain.services.interfaces.FuncionarioDomainService;

@RestController
@RequestMapping("/api/funcionarios")
public class FuncionarioController {

	@Autowired
	private FuncionarioDomainService funcionarioDomainService;
	
	@PostMapping
	public FuncionarioResponseDto post(@RequestBody FuncionarioRequestDto request) {
		return funcionarioDomainService.cadastrar(request);
	}
	
	@PutMapping("{id}")
	public FuncionarioResponseDto put(@PathVariable UUID id, @RequestBody FuncionarioRequestDto request) {
		return funcionarioDomainService.atualizar(id, request);
	}
	
	@DeleteMapping("{id}")
	public FuncionarioResponseDto delete(@PathVariable UUID id) {
		return funcionarioDomainService.excluir(id);
	}
	
	@GetMapping("{dataMin}/{dataMax}")
	public List<FuncionarioResponseDto> getByDate(@PathVariable Date dataMin, @PathVariable Date dataMax){
		return funcionarioDomainService.consultar(dataMin, dataMax);
	}
	
	@GetMapping()
	public FuncionarioResponseDto getById(@PathVariable UUID id) {
		return funcionarioDomainService.consultarPorId(id);
	}
}
