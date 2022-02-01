import { Component, OnInit } from '@angular/core';
import {MatDialog} from '@angular/material/dialog';
import { LoginComponent } from '../login/login.component';
import { LinkmenuService } from '../service/linkmenu.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  constructor(public login: MatDialog, public linkmenu : LinkmenuService) { 
    linkmenu.setMenu(false, true, true, true);
  }

  ngOnInit(): void {

  }

  openLogin(){
    const dialogRef = this.login.open(LoginComponent, {width: '40%'});

    /*
    dialogRef.afterClosed().subscribe(result => {
      console.log(`Dialog result: ${result}`);
    });
    */
  }

}
