package com.example.demo.domain.services.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.domain.models.dtos.FuncionarioRequestDto;
import com.example.demo.domain.models.dtos.FuncionarioResponseDto;
import com.example.demo.domain.models.entities.Funcionario;
import com.example.demo.domain.services.interfaces.FuncionarioDomainService;
import com.example.demo.infrastructure.components.MessageProducerComponent;
import com.example.demo.infrastructure.repositories.FuncionarioRepository;

@Service
public class FuncionarioDomainServiceImpl implements FuncionarioDomainService {

	@Autowired
	private FuncionarioRepository funcionarioRepository;

	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private MessageProducerComponent messageProducerComponent;

	@Override
	public FuncionarioResponseDto cadastrar(FuncionarioRequestDto request) {

		var funcionario = modelMapper.map(request, Funcionario.class);
		funcionario.setId(UUID.randomUUID());

		funcionarioRepository.save(funcionario);
		
		try {
			messageProducerComponent.send(funcionario);
		}
		catch (Exception e) {
			e.printStackTrace();
		}

		return modelMapper.map(funcionario, FuncionarioResponseDto.class);
	}

	@Override
	public FuncionarioResponseDto atualizar(UUID id, FuncionarioRequestDto request) {

		var funcionario = funcionarioRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Funcionário não encontrado."));

		funcionario.setNome(request.getNome());
		funcionario.setCpf(request.getCpf());
		funcionario.setEmail(request.getEmail());
		funcionario.setMatricula(request.getMatricula());
		funcionario.setDataAdmissao(request.getDataAdmissao());
		funcionario.setSalario(request.getSalario());

		funcionarioRepository.save(funcionario);

		return modelMapper.map(funcionario, FuncionarioResponseDto.class);
	}

	@Override
	public FuncionarioResponseDto excluir(UUID id) {

		var funcionario = funcionarioRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Funcionário não encontrado."));

		funcionarioRepository.delete(funcionario);

		return modelMapper.map(funcionario, FuncionarioResponseDto.class);
	}

	@Override
	public List<FuncionarioResponseDto> consultar(Date dataMin, Date dataMax) {

		var response = new ArrayList<FuncionarioResponseDto>();
		
		var funcionarios = funcionarioRepository.findByDatas(dataMin, dataMax);
		
		for(var funcionario : funcionarios) {
			response.add(modelMapper.map(funcionario, FuncionarioResponseDto.class));
		}
		
		return response;
	}

	@Override
	public FuncionarioResponseDto consultarPorId(UUID id) {
		
		var funcionario = funcionarioRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Funcionário não encontrado."));
		
		return modelMapper.map(funcionario, FuncionarioResponseDto.class);
	}

}
