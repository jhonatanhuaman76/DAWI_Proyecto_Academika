import { CommonModule } from '@angular/common';
import { Component, EventEmitter, Output } from '@angular/core';
import { TableModule } from 'primeng/table';
import { InputTextModule } from 'primeng/inputtext';
import { ButtonModule } from 'primeng/button';
import { IconField } from 'primeng/iconfield';
import { InputIcon } from 'primeng/inputicon';
import { FormsModule } from '@angular/forms';
import { ICurso } from '../../models/curso.model';
import { CursoService } from '../../service/curso.service';


@Component({
  selector: 'app-listar-cursos-instructor',
  standalone: true,
  imports: [CommonModule, TableModule, InputTextModule, ButtonModule, FormsModule, IconField, InputIcon],
  templateUrl: './listar-cursos-instructor.component.html',
  styleUrl: './listar-cursos-instructor.component.css'
})
export class ListarCursosInstructorComponent {
  @Output() seleccionar = new EventEmitter<ICurso>();

  cursos: ICurso[] = [];
  globalFilter: string = '';
  
  constructor(private cursoService: CursoService) { }
  
  ngOnInit() {
    this.cargarCursos();
  }

  cargarCursos() {
    this.cursoService.buscarPorInstructor(3).subscribe((data: ICurso[]) => {
      this.cursos = data;
      console.log(this.cursos);
    });
  }

  buscarCursoPorNombre(event: any) {
    this.globalFilter = event.target.value;
  }
  eliminarCurso(curso: ICurso) {
    this.seleccionar.emit(curso);
  }
  editarCurso(curso: ICurso) {
    this.seleccionar.emit(curso);
  }
  verCurso(id: number) {
  }
}
