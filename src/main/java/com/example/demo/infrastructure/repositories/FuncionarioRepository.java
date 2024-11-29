package com.example.demo.infrastructure.repositories;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.domain.models.entities.Funcionario;

@Repository
public interface FuncionarioRepository extends MongoRepository<Funcionario, UUID> {

	@Query("{ 'dataAdmissao' : { $gte: ?0, $lte: ?1 } }")
	List<Funcionario> findByDatas(Date dataMin, Date dataMax);
}
