package com.tiagoperroni.consultacep.controller;

import com.tiagoperroni.consultacep.model.Endereco;
import com.tiagoperroni.consultacep.service.EnderecoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/cep")
public class ConsultaCepController {

    private final EnderecoService enderecoService;

    public ConsultaCepController(EnderecoService enderecoService) {
        this.enderecoService = enderecoService;
    }

    @GetMapping("/{cep}/{numero}")
    public ResponseEntity<Endereco> consultaCep(@PathVariable("cep") String cep, @PathVariable("numero") Integer numero) {
        return new ResponseEntity<>(this.enderecoService.getEndereco(cep, numero), HttpStatus.CREATED);
    }
}
