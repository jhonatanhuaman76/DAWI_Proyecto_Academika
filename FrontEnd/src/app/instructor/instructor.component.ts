import { Component } from '@angular/core';
import { ListarCursosInstructorComponent } from "./listar-cursos-instructor/listar-cursos-instructor.component";
import { RegistrarCursoComponent } from "./registrar-curso/registrar-curso.component";
import { EditarCursoComponent } from './editar-curso/editar-curso.component';
import { ICurso } from '../models/curso.model';
import { EliminarCursoComponent } from './eliminar-curso/eliminar-curso.component';

@Component({
  selector: 'app-instructor',
  standalone: true,
  imports: [ListarCursosInstructorComponent, RegistrarCursoComponent, EditarCursoComponent, EliminarCursoComponent],
  templateUrl: './instructor.component.html',
  styleUrl: './instructor.component.css'
})
export class InstructorComponent {
  cursoSeleccionado: ICurso | null = null;

  onSeleccionarCurso(curso: ICurso) {
    this.cursoSeleccionado = curso;
  }
}
