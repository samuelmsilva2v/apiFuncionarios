package com.example.demo.infrastructure.repositories;

import java.util.UUID;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.domain.models.entities.Funcionario;

@Repository
public interface FuncionarioRepository extends MongoRepository<Funcionario, UUID> {

}
