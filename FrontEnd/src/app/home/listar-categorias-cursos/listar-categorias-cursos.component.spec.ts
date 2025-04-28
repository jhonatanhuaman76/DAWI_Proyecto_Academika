import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListarCategoriasCursosComponent } from './listar-categorias-cursos.component';

describe('ListarPorCategoriaComponent', () => {
  let component: ListarCategoriasCursosComponent;
  let fixture: ComponentFixture<ListarCategoriasCursosComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ListarCategoriasCursosComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ListarCategoriasCursosComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
