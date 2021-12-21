import { Component, OnInit } from '@angular/core';
import {LoginComponent} from "../login/login.component";
import {MatDialog} from "@angular/material/dialog";
import { LinkmenuService } from '../service/linkmenu.service';

@Component({
  selector: 'app-about',
  templateUrl: './about.component.html',
  styleUrls: ['./about.component.css']
})
export class AboutComponent implements OnInit {

  constructor(public login:MatDialog,public linkmenu : LinkmenuService) {
    linkmenu.setMenu(true, false, true, true);
  }

  ngOnInit(): void {
  }

  openLogin() {
    const dialogRef = this.login.open(LoginComponent, {width: "40%"});
  }
}
