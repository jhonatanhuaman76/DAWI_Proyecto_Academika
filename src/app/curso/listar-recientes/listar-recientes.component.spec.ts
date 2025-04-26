import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListarRecientesComponent } from './listar-recientes.component';

describe('ListarRecientesComponent', () => {
  let component: ListarRecientesComponent;
  let fixture: ComponentFixture<ListarRecientesComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ListarRecientesComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ListarRecientesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
