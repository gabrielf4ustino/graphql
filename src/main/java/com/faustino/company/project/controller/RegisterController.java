package com.faustino.company.project.controller;

import com.faustino.company.project.dto.ClientDTO;
import com.faustino.company.project.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("register")
public class RegisterController {

    @Autowired
    private ClientService clientService;

    @PostMapping("client")
    ResponseEntity<ResponseStatus> registerClient(@RequestBody ClientDTO clientDTO) {
        if (clientService.register(clientDTO))
            return new ResponseEntity<>(HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}
