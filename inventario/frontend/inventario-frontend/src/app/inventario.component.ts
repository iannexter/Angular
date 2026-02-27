import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

export interface Produto {
  idproduto: number;
  descricao: string;
  preco: number;
  estoque: number;
}

@Component({
  selector: 'app-inventario',
  standalone: true,
  imports: [CommonModule],
  template: `
  <div class="container">
    <div class="container text-center" style="margin: 30px;">
        <h3>Sistema de Inventário</h3>
    </div>


    <table class="table table-striped table-hover align-middle">
      <thead>
        <tr>
          <th>ID</th>
          <th>Descrição do Produto</th>
          <th>Preço</th>
          <th>Estoque</th>
        </tr>
      </thead>
      <tbody>
        <tr *ngFor="let produto of produtos">
          <td>{{ produto.idproduto }}</td>
          <td>{{ produto.descricao }}</td>
          <td>{{ produto.preco | currency:'BRL' }}</td>
          <td>{{ produto.estoque }}</td>
        </tr>
      </tbody>
    </table>
  </div>
  `
})
export class InventarioComponent implements OnInit {

  produtos: Produto[] = [];

  constructor(private http: HttpClient) {}

  ngOnInit(): void {
    console.log('Componente carregado');

    this.listarProdutos().subscribe(data => {
      console.log('Dados recebidos:', data);
      this.produtos = data;
    });
  }

  listarProdutos(): Observable<Produto[]> {
    return this.http.get<Produto[]>('http://localhost:8080/inventario/produtos');
  }
}