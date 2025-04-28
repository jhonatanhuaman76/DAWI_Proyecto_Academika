import { ICurso } from "./curso.model";

export interface ICategoriaCursos {
  id: number;
  nombre: string;
  descrip: string;
  list_cursos: ICurso[];
}