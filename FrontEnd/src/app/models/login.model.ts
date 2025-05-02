export interface ILogin {
  id: number;
  token: string;
  nombre: string;
  email: string;
  rol: string;
  expiredAt: number;
}