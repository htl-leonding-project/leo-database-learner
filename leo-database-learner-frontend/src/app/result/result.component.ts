import { Component, OnInit } from '@angular/core';
import {LoginComponent} from "../login/login.component";
import {MatDialog} from "@angular/material/dialog";
import {Router} from "@angular/router";

@Component({
  selector: 'app-result',
  templateUrl: './result.component.html',
  styleUrls: ['./result.component.css']
})
export class ResultComponent implements OnInit {

  constructor(public login: MatDialog, private router: Router) { }

  ngOnInit(): void {
  }

  openLogin() {
    const dialogRef = this.login.open(LoginComponent, {width: "40%"});
  }

  backButton(){
    this.router.navigateByUrl('tasks');
  }

}
