import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListarCursosEstudianteComponent } from './listar-cursos-estudiante.component';

describe('ListarMisCursosComponent', () => {
  let component: ListarCursosEstudianteComponent;
  let fixture: ComponentFixture<ListarCursosEstudianteComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ListarCursosEstudianteComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ListarCursosEstudianteComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
