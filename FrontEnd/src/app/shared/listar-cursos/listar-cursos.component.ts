import { Component, Input, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { ICurso } from '../../models/curso.model';
import { NgFor } from '@angular/common';
import {  } from 'swiper/element';

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

  ngOnInit(): void {
    this.idUnico = Math.random().toString(36).substring(2, 10);
  }
}
