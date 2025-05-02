import { Component } from '@angular/core';
import { FormBuilder, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { AuthService } from '../service/auth.service';
import Swal from 'sweetalert2';
import { ILogin } from '../models/login.model';
import { IUsuario } from '../models/usuario.model';

@Component({
  selector: 'app-login',
  standalone: true,
  imports: [ReactiveFormsModule],
  templateUrl: './login.component.html',
  styleUrl: './login.component.css'
})
export class LoginComponent {
  loginForm: FormGroup;
  registerForm: FormGroup;

  showLoginPassword: boolean = false;
  showRegisterPassword: boolean = false;

  constructor(
    private fb: FormBuilder,
    private authService: AuthService
  ) {
    this.loginForm = this.fb.group({
      email: ['', [Validators.required, Validators.email]],
      password: ['', Validators.required]
    });

    this.registerForm = this.fb.group({
      nombre: ['', Validators.required],
      email: ['', [Validators.required, Validators.email]],
      fechaNac: ['', Validators.required],
      password: ['', Validators.required],
      rol: ['', Validators.required]
    });
   }

  togglePassword(field: 'login' | 'register') {
    if (field === 'login') {
      this.showLoginPassword = !this.showLoginPassword;
    } else if (field === 'register') {
      this.showRegisterPassword = !this.showRegisterPassword;
    }
  }

  onLoginSubmit() {
    if (this.loginForm.valid) {
      const { email, password } = this.loginForm.value;
      console.log(email, password);
      this.authService.login(email, password).subscribe(
        (response) => {
          Swal.fire({
            icon: 'success',
            title: 'Inicio de sesión exitoso',
            text: 'Has iniciado sesión exitosamente.',
            showConfirmButton: false,
            timer: 1500
          }).then(() => {
            localStorage.setItem('auth', JSON.stringify(response));
            window.location.href = '/home';
          });
        }
      );
    }
  }

  onRegisterSubmit() { 
    if (this.registerForm.valid) {
      const usuario: IUsuario = this.registerForm.value;
      this.authService.register(usuario).subscribe(
        (response) => {
          Swal.fire({
            icon: 'success',
            title: 'Registro exitoso',
            text: 'Has registrado exitosamente.',
            showConfirmButton: false,
            timer: 1500
          }).then(() => {
            this.registerForm.reset();
          });
        }
      );
    }
  }

}
