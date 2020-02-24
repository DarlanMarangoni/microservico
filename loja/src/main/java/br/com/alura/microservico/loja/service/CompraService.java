package br.com.alura.microservico.loja.service;

import br.com.alura.microservico.loja.controller.dto.CompraDto;
import br.com.alura.microservico.loja.dto.InfoFornecedorDto;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CompraService {

    public void realizaCompra(CompraDto compraDto){

        RestTemplate client = new RestTemplate();
        ResponseEntity<InfoFornecedorDto> exchange =
                client.exchange("http://locahost:8081/fornecedor/info/" + compraDto.getEndereco().getEstado(), HttpMethod.GET, null, InfoFornecedorDto.class);

        System.out.println(exchange.getBody());
    }
}
