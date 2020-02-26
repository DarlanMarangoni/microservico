package br.com.alura.microservico.loja.service;

import br.com.alura.microservico.loja.client.FornecedorClient;
import br.com.alura.microservico.loja.controller.dto.CompraDto;
import br.com.alura.microservico.loja.dto.InfoFornecedorDto;
import br.com.alura.microservico.loja.dto.InfoPedidoDto;
import br.com.alura.microservico.loja.model.Compra;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CompraService {

    private static final Logger LOG = LoggerFactory.getLogger(CompraService.class);

    @Autowired
    private FornecedorClient fornecedorClient;

    public Compra realizaCompra(CompraDto compraDto){

        LOG.info("Buscando informações do fornecedor de {}", compraDto.getEndereco().getEstado());
        InfoFornecedorDto info = fornecedorClient.getInfoPorEstado(compraDto.getEndereco().getEstado());
        LOG.info("Informações recebidas com sucesso.");

        LOG.info("Realizando um pedido");
        InfoPedidoDto pedido = fornecedorClient.realizaPedido(compraDto.getItens());
        LOG.info("Pedido realizado com sucesso.");

        Compra compraSalva = Compra.builder()
                    .pedidoId(pedido.getId())
                    .tempoDePreparo(pedido.getTempoDePreparo())
                    .enderecoDeDestino(compraDto.getEndereco().toString())
                .build();

        return compraSalva;
    }
}
