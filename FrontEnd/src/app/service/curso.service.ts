import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { ICurso } from '../models/curso.model';

@Injectable({
  providedIn: 'root'
})
export class CursoService {

  private apiUrl = 'http://localhost:8081/curso';

  constructor(private http: HttpClient) { }

  listar() {
    return this.http.get<ICurso[]>(`${this.apiUrl}/listar`);
  }

  listarMasRecientes() {
    return this.http.get<ICurso[]>(`${this.apiUrl}/listar/masrecientes`);
  }

  registrar(curso: ICurso) {
    return this.http.post<ICurso>(`${this.apiUrl}/registrar`, curso);
  }
}
