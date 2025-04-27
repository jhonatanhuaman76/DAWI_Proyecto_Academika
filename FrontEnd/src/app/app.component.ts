import { Component, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';

import { RouterOutlet } from '@angular/router';
import { ListarRecientesComponent } from "./curso/listar-recientes/listar-recientes.component";
import { ListarPorCategoriaComponent } from './curso/listar-por-categoria/listar-por-categoria.component';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet, ListarRecientesComponent, ListarPorCategoriaComponent],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css',
  schemas: [CUSTOM_ELEMENTS_SCHEMA],
})
  
export class AppComponent {
  title = 'frontend-academika';
}
