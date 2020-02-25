package br.com.alura.microservico.loja.service;

import br.com.alura.microservico.loja.controller.dto.CompraDto;
import br.com.alura.microservico.loja.dto.InfoFornecedorDto;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CompraService {

    public ResponseEntity<InfoFornecedorDto> realizaCompra(CompraDto compraDto){

        RestTemplate client = new RestTemplate();
        ResponseEntity<InfoFornecedorDto> exchange =
                client.exchange("http://localhost:8081/info/" + compraDto.getEndereco().getEstado(), HttpMethod.GET, null, InfoFornecedorDto.class);

        return exchange;
    }
}
