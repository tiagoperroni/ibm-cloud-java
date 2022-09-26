package com.tiagoperroni.consultacep.service;

import com.tiagoperroni.consultacep.model.Endereco;
import com.tiagoperroni.consultacep.repository.EnderecoRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class EnderecoService {

    private final EnderecoRepository enderecoRepository;

    public EnderecoService(EnderecoRepository enderecoRepository) {
        this.enderecoRepository = enderecoRepository;
    }

    public Endereco getEndereco(String cep, Integer numero) {
        var endereco = new Endereco();
        RestTemplate restTemplate = new RestTemplate();
        endereco = restTemplate.getForEntity("https://viacep.com.br/ws/"+cep+"/json/", Endereco.class).getBody();
        endereco.setNumero(numero);
        this.enderecoRepository.save(endereco);
        return endereco;
    }
}
