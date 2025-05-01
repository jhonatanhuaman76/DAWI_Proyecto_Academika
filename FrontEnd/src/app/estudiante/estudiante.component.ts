import { Component } from '@angular/core';
import { ListarCursosEstudianteComponent } from './listar-cursos-estudiante/listar-cursos-estudiante.component';

@Component({
  selector: 'app-estudiante',
  standalone: true,
  imports: [ListarCursosEstudianteComponent],
  templateUrl: './estudiante.component.html',
  styleUrl: './estudiante.component.css'
})
export class EstudianteComponent {

}
