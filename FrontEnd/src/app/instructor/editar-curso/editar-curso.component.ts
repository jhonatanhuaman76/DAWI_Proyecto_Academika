import { Component, EventEmitter, Input, Output } from '@angular/core';
import { ReactiveFormsModule, FormBuilder, FormGroup, Validators, FormGroupDirective } from '@angular/forms';
import { CategoriaService } from '../../service/categoria.service';
import { CursoService } from '../../service/curso.service';
import { ICategoria } from '../../models/categoria.model';
import { CommonModule } from '@angular/common';
import { ICurso } from '../../models/curso.model';
import Swal from 'sweetalert2';


@Component({
  selector: 'app-editar-curso',
  standalone: true,
  imports: [CommonModule, ReactiveFormsModule],
  templateUrl: './editar-curso.component.html',
  styleUrl: './editar-curso.component.css'
})
export class EditarCursoComponent {
  @Input() curso: ICurso | null = null;
  @Output() recargarTabla = new EventEmitter<void>();

  cursoForm: FormGroup;

  categorias: ICategoria[] = [];

  ID_INSTRUCTOR: number = localStorage.getItem('auth') ? JSON.parse(localStorage.getItem('auth') || '').id : 0;

  constructor(
    private fb: FormBuilder,
    private categoriaService: CategoriaService,
    private cursoService: CursoService
  ) {
    this.cursoForm = this.fb.group({
      id: [null, Validators.required],
      titulo: ['', Validators.required],
      descrip: ['', Validators.required],
      precio: [null, [Validators.required, Validators.min(0)]],
      miniatura: ['', Validators.required],
      fecha: [null, Validators.required],
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
            title: 'Curso actualizado',
            text:  `El curso ${response.titulo} ha sido actualizado exitosamente.`,
            showConfirmButton: false,
            timer: 1500
          });
          this.recargarTabla.emit();
        },
        error: (error) => {
          Swal.fire({
            icon: 'error',
            title: 'Error al actualizar el curso',
            text: error.error.message,
            confirmButtonText: 'Cerrar'
          });
        }
      }); 
    } else {
      this.cursoForm.markAllAsTouched();
      Swal.fire({
        icon: 'error',
        title: 'Error al actualizar el curso',
        text: 'Por favor, complete todos los campos requeridos.',
        confirmButtonText: 'Cerrar'
      });
    }
  }

  ngOnChanges() {
    if (this.curso) {
      this.cursoForm.patchValue(this.curso);
    }
  }
}
