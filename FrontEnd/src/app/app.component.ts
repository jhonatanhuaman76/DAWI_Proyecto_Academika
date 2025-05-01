import { Component, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { RouterModule, RouterOutlet } from '@angular/router';
import { MenuNavegacionComponent } from './shared/menu-navegacion/menu-navegacion.component';
import { register as registerSwiperElements } from 'swiper/element/bundle';
registerSwiperElements();

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet, MenuNavegacionComponent, RouterModule],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css',
  schemas: [CUSTOM_ELEMENTS_SCHEMA],
})
  
export class AppComponent {
  title = 'frontend-academika';
}
