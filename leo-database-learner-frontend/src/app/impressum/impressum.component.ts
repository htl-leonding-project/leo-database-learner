import { Component, OnInit } from '@angular/core';
import {MatDialog} from "@angular/material/dialog";
import {LoginComponent} from "../login/login.component";
import { LinkmenuService } from '../service/linkmenu.service';

@Component({
  selector: 'app-impressum',
  templateUrl: './impressum.component.html',
  styleUrls: ['./impressum.component.css']
})
export class ImpressumComponent implements OnInit {

  constructor(public login: MatDialog, public linkmenu : LinkmenuService) {
    linkmenu.setMenu(true, true, false, true);
  }

  ngOnInit(): void {
  }

  openLogin() {
    const dialogRef = this.login.open(LoginComponent, {width: "40%"});
  }
}
