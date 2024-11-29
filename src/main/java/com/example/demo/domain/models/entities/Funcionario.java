package com.example.demo.domain.models.entities;

import java.util.Date;
import java.util.UUID;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = "funcionarios")
public class Funcionario {

	@Id
	private UUID id;
	private String nome;
	private String cpf;
	private String matricula;
	private String email;
	private Date dataAdmissao;
	private Double salario;
}
