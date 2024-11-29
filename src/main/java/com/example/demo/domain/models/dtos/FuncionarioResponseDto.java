package com.example.demo.domain.models.dtos;

import java.util.Date;
import java.util.UUID;

import lombok.Data;

@Data
public class FuncionarioResponseDto {

	private UUID id;
	private String nome;
	private String cpf;
	private String matricula;
	private String email;
	private Date dataAdmissao;
	private Double salario;
}
