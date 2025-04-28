import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListarCursosRecientesComponent } from './listar-cursos-recientes.component';

describe('ListarRecientesComponent', () => {
  let component: ListarCursosRecientesComponent;
  let fixture: ComponentFixture<ListarCursosRecientesComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ListarCursosRecientesComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ListarCursosRecientesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
