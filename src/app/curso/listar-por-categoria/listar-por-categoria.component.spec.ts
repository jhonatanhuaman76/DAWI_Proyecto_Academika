import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListarPorCategoriaComponent } from './listar-por-categoria.component';

describe('ListarPorCategoriaComponent', () => {
  let component: ListarPorCategoriaComponent;
  let fixture: ComponentFixture<ListarPorCategoriaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ListarPorCategoriaComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ListarPorCategoriaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
