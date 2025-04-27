import { Component } from '@angular/core';
import { CursoService } from '../../service/curso.service';
import { ICurso } from '../../models/curso.model';
import { ListarComponent } from "../listar/listar.component";
import { Swiper } from 'swiper';

@Component({
  selector: 'app-listar-recientes',
  standalone: true,
  imports: [ListarComponent],
  templateUrl: './listar-recientes.component.html',
  styleUrl: './listar-recientes.component.css',
  
})
export class ListarRecientesComponent {

  cursos: ICurso[] = [];

  constructor(private cursoService: CursoService) { }

  ngOnInit() {
    this.cursoService.listarMasRecientes().subscribe(cursos => {
      this.cursos = cursos;
    });
  }
}
