import { Component, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { ListarCursosRecientesComponent } from "./home/listar-cursos-recientes/listar-cursos-recientes.component";
import { ListarCategoriasCursosComponent } from './home/listar-categorias-cursos/listar-categorias-cursos.component';
import { Swiper } from 'swiper/bundle';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet, ListarCursosRecientesComponent, ListarCategoriasCursosComponent],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css',
  schemas: [CUSTOM_ELEMENTS_SCHEMA],
})
  
export class AppComponent {
  title = 'frontend-academika';
}
