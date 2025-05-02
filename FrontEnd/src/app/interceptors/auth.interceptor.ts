import { HttpInterceptorFn } from '@angular/common/http';

export const authInterceptor: HttpInterceptorFn = (req, next) => {

  if (typeof window === 'undefined') {
    return next(req);
  }

  const auth = localStorage.getItem('auth');

  if (!auth) {
    return next(req);
  }

  const { token } = JSON.parse(auth);

  const cloned = req.clone({
    setHeaders: {
      Authorization: `Bearer ${token}`
    }
  });

  req = cloned;

  return next(req);
};
