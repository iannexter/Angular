import { HttpBackend, HttpClient } from '@angular/common/http';
import { inject, Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Produto } from './produto';

@Injectable({
  providedIn: 'root',
})
export class ProdutoApi {

  private urlBase = "http://localhost:8080/inventario/produtos";
  private clienteHttp = inject(HttpClient)


  obterListaDeProdutos() : Observable<Produto[]>{


    return this.clienteHttp.get<Produto[]>(this.urlBase);

  }


}
