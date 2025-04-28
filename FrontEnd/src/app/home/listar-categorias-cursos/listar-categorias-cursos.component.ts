import { Component } from '@angular/core';
import { CursoService } from '../../service/curso.service';
import { ICurso } from '../../models/curso.model';
import { CommonModule, NgFor } from '@angular/common';
import { ListarCursosComponent } from '../../shared/listar-cursos/listar-cursos.component';
import { CategoriaService } from '../../service/categoria.service';
import { ICategoriaCursos } from '../../models/categoria-cursos.model';

@Component({
  selector: 'app-listar-categorias-cursos',
  standalone: true,
  imports: [NgFor, ListarCursosComponent, CommonModule],
  templateUrl: './listar-categorias-cursos.component.html',
  styleUrl: './listar-categorias-cursos.component.css'
})
export class ListarCategoriasCursosComponent {

  categorias: ICategoriaCursos[] = [];

  constructor(private categoriaService: CategoriaService) { }

  ngOnInit() {
    this.categoriaService.listarConCursos().subscribe(categorias => {
      this.categorias = categorias;
    });
  }
}
