package com.iansistemas.inventario.service;

import com.iansistemas.inventario.model.Produto;
import com.iansistemas.inventario.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService implements IProdutoService {


    //injecao de dependencia antiga
    @Autowired
    ProdutoRepository produtoRepository;

    @Override
    public List<Produto> listarProdutos() {

        //buscar todos os objetos do tipo "Produto"
        return this.produtoRepository.findAll();
    }

    @Override
    public Produto buscarProdutoPeloId(Integer idProduto) {
        Produto produto = this.produtoRepository.findById(idProduto).orElse(null);

        return produto;
    }

    @Override
    public void salvarProduto(Produto produto) {

        this.produtoRepository.save(produto);

    }

    @Override
    public void excluirProdutoPeloId(Integer id) {

        this.produtoRepository.deleteById(id);
    }
}
