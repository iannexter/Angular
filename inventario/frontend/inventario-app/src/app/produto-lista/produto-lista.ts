import { Component, inject } from '@angular/core';
import { Produto } from '../produto';

@Component({
  selector: 'app-produto-lista',
  standalone: true,
  imports: [],
  templateUrl: './produto-lista.html',

})
export class ProdutoLista {

  produtos!: Produto[];

  private produtoService = inject(Produto);

  ngOnInit(){

    //carregar os produtos
    this.obterProdutos();

  }

 }
