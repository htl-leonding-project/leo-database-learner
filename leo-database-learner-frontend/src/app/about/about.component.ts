import { Component, OnInit } from '@angular/core';
import {LoginComponent} from "../login/login.component";
import {MatDialog} from "@angular/material/dialog";

@Component({
  selector: 'app-about',
  templateUrl: './about.component.html',
  styleUrls: ['./about.component.css']
})
export class AboutComponent implements OnInit {

  constructor(public login:MatDialog) { }

  ngOnInit(): void {
  }

  openLogin() {
    const dialogRef = this.login.open(LoginComponent, {width: "40%"});
  }
}
