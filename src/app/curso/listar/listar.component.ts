import { Component, Input } from '@angular/core';
import { ICurso } from '../../models/curso.model';
import { CursoService } from '../../service/curso.service';
import { NgFor } from '@angular/common';

@Component({
  selector: 'app-listar',
  standalone: true,
  imports: [NgFor],
  templateUrl: './listar.component.html',
  styleUrl: './listar.component.css'
})
export class ListarComponent {
  @Input() tipo: 'categoria' | 'recientes' = 'recientes';
  @Input() cateId?: number;

  cursos: ICurso[] = [];

  constructor(private cursoService: CursoService) { }
  
  ngOnInit() {
    if(this.tipo === 'categoria' && this.cateId) {
      this.cursoService.listarPorCategoria(this.cateId).subscribe(cursos => {
        this.cursos = cursos;
      });
    } else if(this.tipo === 'recientes') {
      this.cursoService.listarMasRecientes().subscribe(cursos => {
        this.cursos = cursos;
      });
    }
  }
}
