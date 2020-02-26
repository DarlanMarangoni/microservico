package br.com.alura.microservico.fornecedor.controller;

import br.com.alura.microservico.fornecedor.model.InfoFornecedor;
import br.com.alura.microservico.fornecedor.service.FornecedorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/info")
public class InfoController {

    private static final Logger LOG = LoggerFactory.getLogger(InfoController.class);

    @Autowired
    private FornecedorService fornecedorService;

    @GetMapping("/{estado}")
    public ResponseEntity<InfoFornecedor> info(@PathVariable String estado){
        LOG.info("Recebido pedido de informações do fornecedor {}", estado);
        return ResponseEntity.ok().body(fornecedorService.findByEstado(estado));
    }
}
