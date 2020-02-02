package br.com.alura.microservico.loja.controller;

import br.com.alura.microservico.loja.controller.dto.CompraDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/compra")
public class CompaController {

    @PostMapping
    public ResponseEntity<String> realizaCompra(@RequestBody CompraDto compraDto){

        return ResponseEntity.ok().body("UP!!");
    }
}
