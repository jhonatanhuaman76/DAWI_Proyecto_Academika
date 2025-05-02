import { NgIf } from '@angular/common';
import { Component } from '@angular/core';

@Component({
  selector: 'app-menu-navegacion',
  standalone: true,
  imports: [NgIf],
  templateUrl: './menu-navegacion.component.html',
  styleUrl: './menu-navegacion.component.css'
})
export class MenuNavegacionComponent {

  isLoggedIn: boolean = false;
  isAdmin: boolean = false;
  isInstructor: boolean = false;
  isEstudiante: boolean = false;

  constructor() {
    if (typeof window !== 'undefined') {
      this.isLoggedIn = localStorage.getItem('auth') !== null;
      const auth = localStorage.getItem('auth');
      if (auth) {
        const { rol } = JSON.parse(auth);
        this.isAdmin = rol === 'ADMIN';
        this.isInstructor = rol === 'INSTRUCTOR';
        this.isEstudiante = rol === 'ESTUDIANTE';
      }
    }
  }

  cerrarSesion() {
    localStorage.removeItem('auth');
    window.location.reload();
  }
}
