import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})

export class AppComponent {
  title = 'leo-database-learner-frontend';

  buttonCLick(): void{
    alert('Daten werden an Server geschickt');
  }
}
