package com.example.demo.domain.models.dtos;

import java.util.Date;

import lombok.Data;

@Data
public class FuncionarioRequestDto {

	private String nome;
	private String cpf;
	private String matricula;
	private String email;
	private Date dataAdmissao;
	private Double salario;
}
