package com.ada.estoque.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProdutoDto {

    private String nome;
    private int quantidade;
    private Double preco;
}
