import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListarCursosInstructorComponent } from './listar-cursos-instructor.component';

describe('ListarCursosInstructorComponent', () => {
  let component: ListarCursosInstructorComponent;
  let fixture: ComponentFixture<ListarCursosInstructorComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ListarCursosInstructorComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ListarCursosInstructorComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
