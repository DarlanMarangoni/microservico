package br.com.alura.microservico.loja.controller;

import br.com.alura.microservico.loja.controller.dto.CompraDto;
import br.com.alura.microservico.loja.dto.InfoFornecedorDto;
import br.com.alura.microservico.loja.service.CompraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/compra")
public class CompraController {

    @Autowired
    private CompraService compraService;

    @PostMapping
    public ResponseEntity<InfoFornecedorDto> realizaCompra(@RequestBody CompraDto compraDto){
        return compraService.realizaCompra(compraDto);
    }
}
