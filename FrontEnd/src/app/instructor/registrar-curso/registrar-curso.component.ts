import { Component, EventEmitter, Output } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ReactiveFormsModule, FormBuilder, FormGroup, Validators, FormGroupDirective } from '@angular/forms';
import { CursoService } from '../../service/curso.service';
import Swal from 'sweetalert2';
import { ICategoria } from '../../models/categoria.model';
import { CategoriaService } from '../../service/categoria.service';

@Component({
  selector: 'app-registrar-curso',
  standalone: true,
  imports: [CommonModule, ReactiveFormsModule],
  templateUrl: './registrar-curso.component.html',
  styleUrl: './registrar-curso.component.css'
})
export class RegistrarCursoComponent {

  @Output() recargarTabla = new EventEmitter<void>();

  cursoForm: FormGroup;

  categorias: ICategoria[] = [];

  ID_INSTRUCTOR: number = localStorage.getItem('auth') ? JSON.parse(localStorage.getItem('auth') || '').id : 0;

  constructor(
    private fb: FormBuilder,
    private cursoService: CursoService,
    private categoriaService: CategoriaService
  ) {
    this.cursoForm = this.fb.group({
      titulo: ['', Validators.required],
      descrip: ['', Validators.required],
      precio: [null, [Validators.required, Validators.min(0)]],
      miniatura: ['', Validators.required],
      idCate: [null, Validators.required],
      idInstructor: [this.ID_INSTRUCTOR, Validators.required],
    });
  }


  ngOnInit() {
    this.categoriaService.listar().subscribe({
      next: (response) => {
        this.categorias = response;
      }
    });
  }

  onSubmit(formDirective: FormGroupDirective) {
    if (this.cursoForm.valid) {
      const cursoData = this.cursoForm.value;
      console.log(cursoData);
      this.cursoService.guardar(cursoData).subscribe({
        next: (response) => {
          Swal.fire({
            icon: 'success',
            title: 'Curso registrado',
            text:  `El curso ${response.titulo} ha sido registrado exitosamente.`,
            showConfirmButton: false,
            timer: 1500
          });
          formDirective.resetForm();
          this.cursoForm.get('idInstructor')?.setValue(this.ID_INSTRUCTOR);
          this.recargarTabla.emit();
        },
        error: (error) => {
          Swal.fire({
            icon: 'error',
            title: 'Error al registrar el curso',
            text: error.error.message,
            confirmButtonText: 'Cerrar'
          });
        }
      }); 
    } else {
      this.cursoForm.markAllAsTouched();
      Swal.fire({
        icon: 'error',
        title: 'Error al registrar el curso',
        text: 'Por favor, complete todos los campos requeridos.',
        confirmButtonText: 'Cerrar'
      });
    }
  }
}
