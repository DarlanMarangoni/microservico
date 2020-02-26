package br.com.alura.microservico.loja.service;

import br.com.alura.microservico.loja.client.FornecedorClient;
import br.com.alura.microservico.loja.controller.dto.CompraDto;
import br.com.alura.microservico.loja.dto.InfoFornecedorDto;
import br.com.alura.microservico.loja.dto.InfoPedidoDto;
import br.com.alura.microservico.loja.model.Compra;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CompraService {

    @Autowired
    private FornecedorClient fornecedorClient;

    public Compra realizaCompra(CompraDto compraDto){
        InfoFornecedorDto info = fornecedorClient.getInfoPorEstado(compraDto.getEndereco().getEstado());

        InfoPedidoDto pedido = fornecedorClient.realizaPedido(compraDto.getItens());

        Compra compraSalva = Compra.builder()
                    .pedidoId(pedido.getId())
                    .tempoDePreparo(pedido.getTempoDePreparo())
                    .enderecoDeDestino(compraDto.getEndereco().toString())
                .build();

        return compraSalva;
    }
}
