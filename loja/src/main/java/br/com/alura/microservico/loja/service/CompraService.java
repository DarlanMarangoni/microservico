package br.com.alura.microservico.loja.service;

import br.com.alura.microservico.loja.controller.dto.CompraDto;
import br.com.alura.microservico.loja.dto.InfoFornecedorDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CompraService {

    @Autowired
    private RestTemplate client;

    public ResponseEntity<InfoFornecedorDto> realizaCompra(CompraDto compraDto){

        ResponseEntity<InfoFornecedorDto> exchange =
                client.exchange("http://fornecedor/info/" + compraDto.getEndereco().getEstado(), HttpMethod.GET, null, InfoFornecedorDto.class);

        return exchange;
    }
}
