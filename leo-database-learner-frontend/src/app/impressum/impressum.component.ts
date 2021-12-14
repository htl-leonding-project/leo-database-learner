import { Component, OnInit } from '@angular/core';
import {MatDialog} from "@angular/material/dialog";
import {LoginComponent} from "../login/login.component";

@Component({
  selector: 'app-impressum',
  templateUrl: './impressum.component.html',
  styleUrls: ['./impressum.component.css']
})
export class ImpressumComponent implements OnInit {

  constructor(public login: MatDialog) { }

  ngOnInit(): void {
  }

  openLogin() {
    const dialogRef = this.login.open(LoginComponent, {width: "40%"});
  }
}
