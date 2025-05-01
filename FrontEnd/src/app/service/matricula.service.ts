import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { IMatricula } from '../models/matricula.model';

@Injectable({
  providedIn: 'root'
})
export class MatriculaService {
  private apiUrl = 'http://localhost:8081/matricula';

  constructor(private http: HttpClient) { }

  registrar(matricula : IMatricula) {
    return this.http.post<IMatricula>(`${this.apiUrl}`, matricula);
  }

  obtenerPorEstudiante(idEstudiante: number) {
    return this.http.get<IMatricula[]>(`${this.apiUrl}/estudiante/${idEstudiante}`);
  }
}
