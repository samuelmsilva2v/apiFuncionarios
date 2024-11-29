package com.example.demo.domain.services.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.domain.models.dtos.FuncionarioRequestDto;
import com.example.demo.domain.models.dtos.FuncionarioResponseDto;
import com.example.demo.domain.services.interfaces.FuncionarioDomainService;
import com.example.demo.infrastructure.repositories.FuncionarioRepository;

@Service
public class FuncionarioDomainServiceImpl implements FuncionarioDomainService {
	
	@Autowired
	private FuncionarioRepository funcionarioRepository;

	@Override
	public FuncionarioResponseDto cadastrar(FuncionarioRequestDto request) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public FuncionarioResponseDto atualizar(UUID id, FuncionarioRequestDto request) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public FuncionarioResponseDto excluir(UUID id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<FuncionarioResponseDto> consultar() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public FuncionarioResponseDto consultarPorId(UUID id) {
		// TODO Auto-generated method stub
		return null;
	}

}
