package com.ada.estoque.repository;

import com.ada.estoque.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {

    public void deleteByQuantidade(int quantidade);
}
