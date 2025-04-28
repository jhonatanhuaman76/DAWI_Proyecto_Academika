import { Component } from '@angular/core';
import { CursoService } from '../../service/curso.service';
import { ICurso } from '../../models/curso.model';
import { ListarCursosComponent } from "../../shared/listar-cursos/listar-cursos.component";

@Component({
  selector: 'app-listar-cursos-recientes',
  standalone: true,
  imports: [ListarCursosComponent],
  templateUrl: './listar-cursos-recientes.component.html',
  styleUrl: './listar-cursos-recientes.component.css',
  
})
export class ListarCursosRecientesComponent {

  cursos: ICurso[] = [];

  constructor(private cursoService: CursoService) { }

  ngOnInit() {
    this.cursoService.listarMasRecientes().subscribe(cursos => {
      this.cursos = cursos;
    });
  }
}
