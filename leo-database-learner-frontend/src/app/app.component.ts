import { Component } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { LoginComponent } from './login/login.component';
import { LinkmenuService } from './service/linkmenu.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})

export class AppComponent {
  title = 'leo-database-learner-frontend';
  menu : Boolean[];

  constructor(public login: MatDialog, public linkmenu : LinkmenuService) { 
    this.menu = linkmenu.getMenu();
  }

  openLogin() {
    const dialogRef = this.login.open(LoginComponent, {width: "40%"});
  }
}
