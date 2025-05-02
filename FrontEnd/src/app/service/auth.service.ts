import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { ILogin } from '../models/login.model';
import { catchError, tap } from 'rxjs';
import { IUsuario } from '../models/usuario.model';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  private apiUrl = 'http://localhost:8081/auth';

  constructor(private http: HttpClient) { }

  login(email: string, password: string) {
    return this.http.post<ILogin>(`${this.apiUrl}/login`, { email, password }).pipe(
      tap((response) => {
        localStorage.setItem('auth', JSON.stringify(response));
      })
    );
  }

  register(usuario: IUsuario) {
    return this.http.post<IUsuario>(`${this.apiUrl}/registrar`, usuario);
  }
}
