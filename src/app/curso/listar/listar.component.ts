import { Component, Input, CUSTOM_ELEMENTS_SCHEMA} from '@angular/core';
import { ICurso } from '../../models/curso.model';
import { NgFor } from '@angular/common';

@Component({
  selector: 'app-listar',
  standalone: true,
  imports: [NgFor],
  templateUrl: './listar.component.html',
  styleUrl: './listar.component.css',
  schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class ListarComponent {
  @Input() cursos: ICurso[] = [];
}
