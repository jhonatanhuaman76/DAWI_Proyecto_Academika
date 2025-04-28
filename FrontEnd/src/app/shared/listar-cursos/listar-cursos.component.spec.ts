import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListarCursosComponent } from './listar-cursos.component';

describe('ListarComponent', () => {
  let component: ListarCursosComponent;
  let fixture: ComponentFixture<ListarCursosComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ListarCursosComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ListarCursosComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
