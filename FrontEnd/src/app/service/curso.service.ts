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

  guardar(curso: ICurso) {
    return this.http.post<ICurso>(`${this.apiUrl}/guardar`, curso);
  }

  buscar(id : any){
    return this.http.get<ICurso>(`${this.apiUrl}/buscar/${id}`);
  }

  buscarPorInstructor(id : any){
    return this.http.get<ICurso[]>(`${this.apiUrl}/instructor/${id}`);
  }

  borrar(id : any){
    return this.http.get<any>(`${this.apiUrl}/borrar/${id}`);
  }
}
