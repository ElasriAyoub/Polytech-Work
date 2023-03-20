import { Component } from '@angular/core';
import { Router, TitleStrategy } from '@angular/router';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'project_appli_rencontre';
  id = sessionStorage.getItem('id');

  constructor(private router: Router ) {}

  logout(){
    sessionStorage.clear();
    this.router.navigate(['login'])
      .then(() => {
        window.location.reload();

      });
  console.log('ça marche!')
  }
}
