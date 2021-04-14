// @ts-ignore
import { Component } from '@angular/core';

// @ts-ignore
@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})

export class AppComponent {
  title = 'leo-database-learner-frontend';


  buttonCLick(): void{
    alert('Button was clicked');
  }
}
