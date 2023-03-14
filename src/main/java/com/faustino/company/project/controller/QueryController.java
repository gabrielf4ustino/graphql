package com.faustino.company.project.controller;

import com.faustino.company.project.model.AddressModel;
import com.faustino.company.project.model.ClientModel;
import com.faustino.company.project.repository.AddressRepository;
import com.faustino.company.project.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("query")
public class QueryController {

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private AddressRepository addressRepository;

    @QueryMapping
    Iterable<ClientModel> client(){
        return clientRepository.findAll();
    }

    @QueryMapping
    Optional<List<ClientModel>> clientsByName(@Argument String name){
        return clientRepository.findByNome(name);
    }

    @QueryMapping
    Iterable<AddressModel> address(){
        return addressRepository.findAll();
    }

    @QueryMapping
    Optional<List<AddressModel>> addressByCep(@Argument String cep){
        return addressRepository.findByCep(cep);
    }
}
