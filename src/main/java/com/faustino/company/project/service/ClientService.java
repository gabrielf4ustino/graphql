package com.faustino.company.project.service;

import com.faustino.company.project.dto.ClientDTO;
import com.faustino.company.project.model.AddressModel;
import com.faustino.company.project.model.ClientModel;
import com.faustino.company.project.repository.AddressRepository;
import com.faustino.company.project.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private ViaCepService viaCepService;

    public boolean register(ClientDTO clientDTO){
        Optional<AddressModel> address = viaCepService.getAddress(clientDTO.getCep());
        if(address.isEmpty()){
            return false;
        }
        ClientModel client = new ClientModel();
        client.setNome(clientDTO.getNome());
        client.setEndereco(address.get());

        addressRepository.save(address.get());
        clientRepository.save(client);

        return true;
    }
}
