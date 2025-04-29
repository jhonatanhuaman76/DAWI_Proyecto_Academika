import { Component, Input, CUSTOM_ELEMENTS_SCHEMA} from '@angular/core';
import { ICurso } from '../../models/curso.model';
import { NgFor } from '@angular/common';
import { Router } from '@angular/router';

@Component({
  selector: 'app-listar-cursos',
  standalone: true,
  imports: [NgFor],
  templateUrl: './listar-cursos.component.html',
  styleUrl: './listar-cursos.component.css',
  schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class ListarCursosComponent {
  @Input() cursos: ICurso[] = [];

  idUnico: string = '';
  defaultImage: string = 'imagen-coming-soon.jpg';

  constructor(private router: Router) {}


  ngOnInit(): void {
    this.idUnico = Math.random().toString(36).substring(2, 10);
  }

  onImageError(event: any): void {
    event.target.src = 'imagen-coming-soon.jpg';
  }

  detalleCurso(curso: ICurso): void {
    this.router.navigate(['/curso-detalle', curso.id]);
  }
}
