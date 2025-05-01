import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { ICategoriaCursos } from '../models/categoria-cursos.model';
import { ICategoria } from '../models/categoria.model';

@Injectable({
  providedIn: 'root'
})
export class CategoriaService{

  private apiUrl = 'http://localhost:8081/categoria';

  constructor(private http: HttpClient) { }

  listarConCursos() {
    return this.http.get<ICategoriaCursos[]>(`${this.apiUrl}/listar-con-cursos`);
  }

  listar() {
    return this.http.get<ICategoria[]>(`${this.apiUrl}/listar`);
  }
}
