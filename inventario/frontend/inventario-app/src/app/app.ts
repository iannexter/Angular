import { Component, signal } from '@angular/core';
import { ProdutoLista } from './produto-lista/produto-lista';


@Component({
  selector: 'app-root',
  imports: [ProdutoLista],
  templateUrl: './app.html',
  styleUrl: './app.css',
})
export class App {
  protected readonly title = signal('inventario-app');
}
