package com.faustino.company.project.repository;

import com.faustino.company.project.model.AddressModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AddressRepository extends JpaRepository<AddressModel, Long> {

    Optional<List<AddressModel>> findByCep(String cep);
}
