import { Component, EventEmitter, Input, Output } from '@angular/core';
import { ICurso } from '../../models/curso.model';
import { CursoService } from '../../service/curso.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-eliminar-curso',
  standalone: true,
  imports: [],
  templateUrl: './eliminar-curso.component.html',
  styleUrl: './eliminar-curso.component.css'
})
export class EliminarCursoComponent {
  @Input() curso: ICurso | null = null;
  @Output() recargarTabla = new EventEmitter<void>()

  constructor(private cursoService: CursoService){}

  eliminarCurso() {
    if (this.curso) {
      this.cursoService.borrar(this.curso.id).subscribe({
        next: () => {
          Swal.fire({
            icon: 'success',
            title: 'Curso eliminado',
            text: `El curso ${this.curso?.titulo} ha sido eliminado exitosamente.`,
            showConfirmButton: false,
            timer: 1500
          });
          this.recargarTabla.emit();
        },
        error: (error) => {
          Swal.fire({
            icon: 'error',
            title: 'Error al eliminar curso',
            text: error.error.message,
            showConfirmButton: true
          });
        }
      });
    } else {
      Swal.fire({
        icon: 'error',
        title: 'Error',
        text: 'No se ha seleccionado un curso para eliminar.',
        showConfirmButton: true
      });
    }
  }
}
