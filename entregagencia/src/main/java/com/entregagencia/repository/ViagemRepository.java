package com.entregagencia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.entregagencia.models.Viagem;


@Repository
public interface ViagemRepository extends JpaRepository<Viagem, Long> {


}