import { Component } from '@angular/core';
import { ListarCategoriasCursosComponent } from './listar-categorias-cursos/listar-categorias-cursos.component';
import { ListarCursosRecientesComponent } from './listar-cursos-recientes/listar-cursos-recientes.component';

@Component({
  selector: 'app-home',
  standalone: true,
  imports: [ListarCategoriasCursosComponent, ListarCursosRecientesComponent],
  templateUrl: './home.component.html',
  styleUrl: './home.component.css'
})
export class HomeComponent {

}
