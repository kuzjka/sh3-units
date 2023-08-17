import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {

  links = ['merchants', 'warships', 'uboats', 'aircraft'];
  activeLink = this.links[0];

  constructor() {
  }
}
