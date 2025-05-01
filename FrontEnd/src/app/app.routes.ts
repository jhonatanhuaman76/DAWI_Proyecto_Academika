import { Routes } from '@angular/router';
import { CursoDetalleComponent } from './shared/curso-detalle/curso-detalle.component';
import { HomeComponent } from './home/home.component';
import { EstudianteComponent } from './estudiante/estudiante.component';
import { InstructorComponent } from './instructor/instructor.component';

export const routes: Routes = [
  {path: '', redirectTo: '/home', pathMatch: 'full' },
  { path: 'home', component: HomeComponent },
  { path: 'curso-detalle/:id', component: CursoDetalleComponent },
  { path: 'estudiante/mis-cursos', component: EstudianteComponent },
  { path: 'instructor/mis-cursos', component: InstructorComponent },  
];