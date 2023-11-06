package com.ada.estoque.controller;

import com.ada.estoque.dto.ProdutoDto;
import com.ada.estoque.model.Produto;
import com.ada.estoque.service.ProdutoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/prd")
public class ProdutoController {

    ProdutoService produtoService;

    public ProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    @GetMapping
    public ResponseEntity<List<Produto>> getAll() {

        return ResponseEntity.ok(produtoService.getAll());
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Produto> findById(@PathVariable long id) {
        Produto produto = produtoService.findById(id);
        int quantidade = produto.getQuantidade();

        if (quantidade == 2) {
            throw new RuntimeException("Quantidade pequena!");
        }
        return ResponseEntity.ok(produto);
    }

    @PostMapping
    public ResponseEntity<Produto> saveProduct(@RequestBody ProdutoDto produtoDto) {
        return ResponseEntity.ok(produtoService.save(produtoDto));
    }
}
