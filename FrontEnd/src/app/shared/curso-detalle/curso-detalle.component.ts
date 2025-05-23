import { Component, Input } from '@angular/core';
import { ICurso } from '../../models/curso.model';
import { ActivatedRoute } from '@angular/router';
import { CursoService } from '../../service/curso.service';
import { IMatricula } from '../../models/matricula.model';
import { MatriculaService } from '../../service/matricula.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-curso-detalle',
  standalone: true,
  imports: [],
  templateUrl: './curso-detalle.component.html',
  styleUrl: './curso-detalle.component.css'
})
export class CursoDetalleComponent {
  public curso: ICurso = {} as ICurso;
  private matricula: IMatricula = {} as IMatricula;

  constructor(
    private route: ActivatedRoute,
    private cursoService: CursoService,
    private matriculaService: MatriculaService
  ){}

  ngOnInit(){
    const cursoId = this.route.snapshot.paramMap.get('id');

    console.log(cursoId);

    this.cursoService.buscar(cursoId).subscribe ( curso => {
      this.curso = curso;
    });
  }

  onImageError(event: any): void {
    event.target.src = 'imagen-coming-soon.jpg';
  }

  adquirir(){
    this.matricula.idCurso = this.curso.id;
    this.matricula.idEstudiante = localStorage.getItem('auth') ? JSON.parse(localStorage.getItem('auth') || '').id : 0;

    this.matriculaService.registrar(this.matricula).subscribe({
      next: (response) => {
        Swal.fire({
          icon: 'success',
          title: '¡Matrícula exitosa!',
          text: 'Te has matriculado correctamente en el curso: ' + response.nombreCurso,
          confirmButtonText: 'Aceptar'
        });
      },
      error: (error) => {
        if (error.status === 403) {
          Swal.fire({
            icon: 'warning',
            title: 'Acceso denegado',
            text: 'Inicia sesión como estudiante para matricularte en el curso.',
            confirmButtonText: 'Cerrar'
          });
        } else {
          Swal.fire({
            icon: 'error',
            title: 'Error',
            text: error?.error?.message || 'Ocurrió un error inesperado.',
            confirmButtonText: 'Cerrar'
          });
        }
        console.log('Error capturado:', error);
      }
    });
  }
}
