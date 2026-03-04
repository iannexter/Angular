package com.iansistemas.inventario.service;

import com.iansistemas.inventario.model.Produto;

import java.util.List;

public interface IProdutoService {

    List<Produto> listarProdutos();
    Produto buscarProdutoPeloId(Integer idProduto);

    Produto salvarProduto(Produto produto);

    void excluirProdutoPeloId(Integer id);

}
