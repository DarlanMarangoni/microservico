package br.com.alura.microservico.loja.controller.dto;

import lombok.Data;

import java.util.List;

@Data
public class CompraDto {

    public List<ItemDto> itens;
    public EnderecoDto endereco;
}
