package br.com.alura.microservico.loja.controller.dto;

import lombok.Data;
import lombok.Getter;
import lombok.ToString;

@Data
@ToString
public class EnderecoDto {

    private String rua;
    private String numero;
    private String estado;
}
