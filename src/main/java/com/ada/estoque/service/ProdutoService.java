package com.ada.estoque.service;

import com.ada.estoque.dto.ProdutoDto;
import com.ada.estoque.exception.BadRequestException;
import com.ada.estoque.mapper.ProdutoMapper;
import com.ada.estoque.model.Produto;
import com.ada.estoque.repository.ProdutoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProdutoService {

    private final ProdutoRepository produtoRepository;

    public List<Produto> getAll() {
        return produtoRepository.findAll();
    }

    public Produto save(ProdutoDto produtoDto) {
        Produto mapper = ProdutoMapper.INSTANCE.ProdutoDtoToProduto(produtoDto);
        return produtoRepository.save(mapper);
    }


    public Produto findById(long id) {
        return produtoRepository.findById(id)
                .orElseThrow(() -> new BadRequestException("Não encontrado"));
    }


    //Ao ser chamado o método de deleção de quantidade:
    //Deverá ser apontado o produto apartir de um identificador,
    //apartir desse identificador, deverá ser excluida a quantidade do item selecionado

}
