package br.com.alura.microservico.loja.client;

import br.com.alura.microservico.loja.controller.dto.ItemDto;
import br.com.alura.microservico.loja.dto.InfoFornecedorDto;
import br.com.alura.microservico.loja.dto.InfoPedidoDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient("fornecedor")
public interface FornecedorClient {

    @RequestMapping("/info/{estado}")
    InfoFornecedorDto getInfoPorEstado(@PathVariable String estado);

    @RequestMapping(method = RequestMethod.POST, value = ("/pedido"))
    InfoPedidoDto realizaPedido(List<ItemDto> itens);
}
