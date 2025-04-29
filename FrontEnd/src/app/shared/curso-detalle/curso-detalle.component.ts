import { Component, Input } from '@angular/core';
import { ICurso } from '../../models/curso.model';
import { ActivatedRoute } from '@angular/router';
import { CursoService } from '../../service/curso.service';

@Component({
  selector: 'app-curso-detalle',
  standalone: true,
  imports: [],
  templateUrl: './curso-detalle.component.html',
  styleUrl: './curso-detalle.component.css'
})
export class CursoDetalleComponent {
  public curso : ICurso | undefined;

  constructor(
    private route: ActivatedRoute,
    private cursoService: CursoService
  ){}

  ngOnInit(){
    const cursoId = this.route.snapshot.paramMap.get('id');

    console.log(cursoId);

    this.cursoService.buscar(cursoId).subscribe ( curso => {
      this.curso = curso;
    });
  }

  onImageError(event: any): void {
    event.target.src = 'imagen-coming-soon.jpg';
  }

  adquirir(){
    
  }
}
