import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  template:
  `<h1>Welcome</h1>
  <router-outlet></router-outlet>`
  ,
  styleUrls: ['./app.component.css']
})

export class AppComponent {
  title = 'leo-database-learner-frontend';

}
