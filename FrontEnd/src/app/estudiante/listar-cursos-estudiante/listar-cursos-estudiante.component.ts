import { Component } from '@angular/core';
import { IMatricula } from '../../models/matricula.model';
import { MatriculaService } from '../../service/matricula.service';
import { NgFor, NgIf } from '@angular/common';

@Component({
  selector: 'app-listar-cursos-estudiante',
  standalone: true,
  imports: [NgFor, NgIf],
  templateUrl: './listar-cursos-estudiante.component.html',
  styleUrl: './listar-cursos-estudiante.component.css'
})
export class ListarCursosEstudianteComponent {
  cursos: IMatricula[] = [];
  idEstudiante: number = localStorage.getItem('auth') ? JSON.parse(localStorage.getItem('auth') || '').id : 0;

  constructor(private matriculaService: MatriculaService) { }
  
  ngOnInit() {
    this.matriculaService.obtenerPorEstudiante(this.idEstudiante).subscribe({
      next: (response) => {
        this.cursos = response;
      },
      error: (error) => {
        console.error('Error al obtener los cursos:', error);
      }
    });
  }
}
