import { Component } from '@angular/core';
import { CursoService } from '../../service/curso.service';
import { ICurso } from '../../models/curso.model';
import { CommonModule, NgFor } from '@angular/common';
import { ListarComponent } from '../listar/listar.component';

@Component({
  selector: 'app-listar-por-categoria',
  standalone: true,
  imports: [NgFor, ListarComponent, CommonModule],
  templateUrl: './listar-por-categoria.component.html',
  styleUrl: './listar-por-categoria.component.css'
})
export class ListarPorCategoriaComponent {

  cursosPorCategoria: {
    [idCate: number]: {
      nombre: string;
      descrip: string;
      cursos: ICurso[];
    }
  } = {};

  constructor(private cursoService: CursoService) { }

  ngOnInit() {
    this.cursoService.listar().subscribe(cursos => {
      this.cursosPorCategoria = this.agruparPorCategoria(cursos);
    });
  }

  private agruparPorCategoria(cursos: ICurso[]): {
    [idCate: number]: {
      nombre: string;
      descrip: string;
      cursos: ICurso[];
    }
  } { 
    return cursos.reduce((acc, curso) => {
      const id = curso.idCate;

      if (!acc[id]) {
        acc[id] = {
          nombre: curso.nombreCate,
          descrip: curso.descripCate,
          cursos: []
        }
      }

      acc[id].cursos.push(curso);

      return acc;
    }, {} as any);
  }
}
