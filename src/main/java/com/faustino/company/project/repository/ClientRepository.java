package com.faustino.company.project.repository;

import com.faustino.company.project.model.ClientModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ClientRepository extends JpaRepository<ClientModel, Long> {

    Optional<List<ClientModel>> findByNome(String name);
}
