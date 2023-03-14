package com.faustino.company.project.service;

import com.faustino.company.project.model.AddressModel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@FeignClient(url = "http://viacep.com.br/ws", name = "viacep")
public interface ViaCepService {

    @GetMapping( value = "/{cep}/json/", consumes = "application/json")
    Optional<AddressModel> getAddress(@PathVariable("cep")  String cep);
}
