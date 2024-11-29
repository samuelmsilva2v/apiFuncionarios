package com.example.demo.domain.services.interfaces;

import java.util.List;
import java.util.UUID;

import com.example.demo.domain.models.dtos.FuncionarioRequestDto;
import com.example.demo.domain.models.dtos.FuncionarioResponseDto;

public interface FuncionarioDomainService {

	FuncionarioResponseDto cadastrar(FuncionarioRequestDto request);
	
	FuncionarioResponseDto atualizar(UUID id, FuncionarioRequestDto request);
	
	FuncionarioResponseDto excluir(UUID id);
	
	List<FuncionarioResponseDto> consultar();
	
	FuncionarioResponseDto consultarPorId(UUID id);
}
