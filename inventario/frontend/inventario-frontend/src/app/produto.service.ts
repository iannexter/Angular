import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

export interface Produto {
  id: number;
  descricao: string;
  preco: number;
  estoque: number;
}

@Injectable({
  providedIn: 'root' // disponível globalmente
})
export class ProdutoService {

  private apiUrl = 'http://localhost:8080/inventario/produtos';

  constructor(private http: HttpClient) { }

  listarProdutos(): Observable<Produto[]> {
    return this.http.get<Produto[]>(this.apiUrl);
  }
}