import { bootstrapApplication } from '@angular/platform-browser';
import { provideHttpClient } from '@angular/common/http';
import { InventarioComponent } from './app/inventario.component';

bootstrapApplication(InventarioComponent, {
  providers: [provideHttpClient()]
}).catch(err => console.error(err));