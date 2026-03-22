package com.iansistemas.inventario.controller;


import com.iansistemas.inventario.exceptions.RecursoNaoEncontrado;
import com.iansistemas.inventario.model.Produto;
import com.iansistemas.inventario.repository.ProdutoRepository;
import com.iansistemas.inventario.service.ProdutoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLOutput;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//Essa anotação é uma combinação de duas coisas:
//
//@Controller → indica que a classe é um Controller do Spring (uma classe
// que pode receber requisições HTTP).
//
//@ResponseBody → diz que os métodos retornam diretamente o corpo da resposta (JSON, XML ou texto),
// em vez de retornar o nome de uma view/template.
@RestController
@RequestMapping("/inventario") //acesso via http://localhost:8080/inventario
//@CrossOrigin(origins = {
//        "http://localhost:4200",
//        "http://192.168.1.13:3000"
//})

@CrossOrigin(origins = "*")

public class ProdutoController {

    private static final Logger logger = LoggerFactory.getLogger(ProdutoController.class);

    @Autowired
    private ProdutoService produtoService;

    @GetMapping("/produtos") //acesso via http://localhost:8080/inventario/produtos
    public List<Produto> obterProdutos(){

        List<Produto> produtos = this.produtoService.listarProdutos();
        logger.info("Produtos obtidos: ");
        System.out.println("Produtos obtidos: ");

                for(Produto p : produtos){

            System.out.println(p);

        }



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



        @PostMapping("/produtos")
        public Produto adicionarProduto(@RequestBody Produto produto){

            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();


            logger.info("Produto a ser adicionado: " + produto);

            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();



            return this.produtoService.salvarProduto(produto);
        }
    //multiplos cadastros via json:
    //cadastrar vários produtos
    //
    //controller para receber uma lista:
    //
    //@PostMapping("/produtos")
    //public List<Produto> adicionarProdutos(@RequestBody List<Produto> produtos){
    //    return produtoService.salvarProdutos(produtos);
    //}
    //
    //classe service:
    //
    //public List<Produto> salvarProdutos(List<Produto> produtos){
    //    return produtoRepository.saveAll(produtos);
    //}
    //
    //






        //A classe ResponseEntity é usada no Spring Framework (especialmente no Spring
        // MVC e Spring Boot) para representar toda a resposta HTTP que será enviada
        // por um controller.
        //
        //Ela permite controlar três partes da resposta HTTP:
        //
        //Body (corpo) – os dados que serão retornados
        //
        //Status code – código HTTP (200, 404, 500, etc.)
        //
        //Headers – cabeçalhos HTTP da resposta
        //
        //Ou seja, em vez de retornar só um objeto, você retorna uma resposta HTTP completa.
        @GetMapping("/produtos/{id}")
                                                            //capturar valores que vêm na URL
                                                            // (no caminho da rota) e passá-los
                                                            // como parâmetros
                                                            // para o
                                                            // metodo
                                                            // do controller.
        public ResponseEntity<Produto> buscarProdutoPeloId(@PathVariable int id){

            Produto produto = this.produtoService.buscarProdutoPeloId(id);

            if (produto != null){

                return ResponseEntity.ok(produto);

            } else {
                System.out.println();
                System.out.println();
                System.out.println();
                System.out.println();
                System.out.println("Cliente procutou um produto que não foi encrontrado de ID: " + id);
                System.out.println();
                System.out.println();
                System.out.println();
                System.out.println();
                throw new RecursoNaoEncontrado("Não foi encontrado o id: " + id);

            }


        }

        @PutMapping("/produtos/{id}")
        public ResponseEntity<Produto> atualizarProduto(@PathVariable int id,

              //transformar aquilo que foi enviado em um objeto
              @RequestBody Produto produtoRecebido

        ){

            Produto produto = this.produtoService.buscarProdutoPeloId(id);
            produto.setDescricao(produtoRecebido.getDescricao());
            produto.setPreco(produtoRecebido.getPreco());
            produto.setEstoque(produtoRecebido.getEstoque());

            //salvar tudo
            this.produtoService.salvarProduto(produto);

            return ResponseEntity.ok(produto);
        }







        @DeleteMapping("/produtos/{id}")
        public ResponseEntity<Map<String, Boolean>> excluirProduto(@PathVariable int id) {

            Produto produto = this.produtoService.buscarProdutoPeloId(id);

            if (produto == null) {
                throw new RecursoNaoEncontrado("ID do produto informado para ser deletado não existe");

            }

            this.produtoService.excluirProdutoPeloId(produto.getIdproduto());

            Map<String, Boolean> resposta = new HashMap<>();

            resposta.put("Produto Eliminado!", Boolean.TRUE);

            return ResponseEntity.ok(resposta);

        }


}
