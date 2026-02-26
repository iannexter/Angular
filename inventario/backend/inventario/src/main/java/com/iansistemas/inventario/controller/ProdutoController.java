package com.iansistemas.inventario.controller;


import com.iansistemas.inventario.model.Produto;
import com.iansistemas.inventario.repository.ProdutoRepository;
import com.iansistemas.inventario.service.ProdutoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//Essa anotação é uma combinação de duas coisas:
//
//@Controller → indica que a classe é um Controller do Spring (uma classe
// que pode receber requisições HTTP).
//
//@ResponseBody → diz que os métodos retornam diretamente o corpo da resposta (JSON, XML ou texto),
// em vez de retornar o nome de uma view/template.
@RestController
@RequestMapping("/inventario") //acesso via http://localhost:8080/inventario
@CrossOrigin(value = "http://localhost:4200")
public class ProdutoController {

    private static final Logger logger = LoggerFactory.getLogger(ProdutoController.class);

    @Autowired
    private ProdutoService produtoService;

    @GetMapping("/produtos") //acesso via http://localhost:8080/inventario/produtos
    public List<Produto> obterProdutos(){

        List<Produto> produtos = this.produtoService.listarProdutos();
        logger.info("Produtos obtidos: ");


        //for (Produto produto : produtos) {
        //        logger.info(produto.toString());
        //    }

        produtos.forEach(produto -> logger.info(produto.toString()));

        // for (int i = 0; i < produtos.size(); i++) {
        //        Produto produto = produtos.get(i);
        //        logger.info(produto.toString());
        //    }

        //  for (Produto produto : produtos) {
        //        logger.info("Produto: {}", produto);
        //    }


        return produtos;
    }

//    @GetMapping("/{id}")
//    public Produto buscarProduto(@PathVariable Integer id) {
//        logger.info("Buscando produto com id: {}", id);
//        Produto produto = produtoService.buscarProdutoPeloId(id);
//        if (produto == null) {
//            logger.warn("Produto com id {} não encontrado", id);
//        }
//        return produto;
//    }

}
