package com.iansistemas.inventario;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.iansistemas.inventario.model.Produto;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class InventarioApplication {

	public static void main(String[] args) {

		SpringApplication.run(InventarioApplication.class, args);


		System.out.println();

		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();


		Produto produto = new Produto();
		produto.setDescricao("Camisa tamanho M");
		produto.setPreco(600.0);
		produto.setEstoque(100);

		System.out.println(produto);

		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();

	}


//	@Bean
//	public CommandLineRunner init(ProdutoRepository produtoRepository) {
//		return args -> {
//			Produto produto = new Produto();
//			produto.setDescricao("Camisa tamanho M");
//			produto.setPreco(600.0);
//			produto.setEstoque(100);
//
//			produtoRepository.save(produto); // salvar no banco
//			System.out.println("Produto salvo: " + produto);
//		};
//	}

}
