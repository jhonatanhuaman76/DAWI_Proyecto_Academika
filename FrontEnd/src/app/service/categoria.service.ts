import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class CategoriaService{

  private apiUrl = 'http://localhost:8081/categoria';

  constructor(private http: HttpClient) { }

  listarConCursos() {
    return this.http.get<any[]>(`${this.apiUrl}/listar-con-cursos`);
  }
}
