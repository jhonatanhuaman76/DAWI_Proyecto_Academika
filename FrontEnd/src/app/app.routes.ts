import { Routes } from '@angular/router';
import { CursoDetalleComponent } from './shared/curso-detalle/curso-detalle.component';
import { HomeComponent } from './home/home.component';
import { EstudianteComponent } from './estudiante/estudiante.component';
import { InstructorComponent } from './instructor/instructor.component';
import { LoginComponent } from './login/login.component';

export const routes: Routes = [
  { path: 'home', component: HomeComponent },
  {path: '', redirectTo: '/home', pathMatch: 'full' },
  { path: 'curso-detalle/:id', component: CursoDetalleComponent },
  { path: 'estudiante/mis-cursos', component: EstudianteComponent },
  { path: 'instructor/mis-cursos', component: InstructorComponent },
  {path: 'login', component: LoginComponent},
  { path: '**', redirectTo: '/home', pathMatch: 'full' }
];