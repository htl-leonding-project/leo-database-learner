import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import {LoginComponent} from "../login/login.component";
import {MatDialog} from "@angular/material/dialog";
import { LinkmenuService } from '../service/linkmenu.service';

@Component({
  selector: 'app-task-detail',
  templateUrl: './task-detail.component.html',
  styleUrls: ['./task-detail.component.css']
})
export class TaskDetailComponent implements OnInit {

  id = '';

  constructor(
    private route: ActivatedRoute, public login: MatDialog, private router: Router, public linkmenu: LinkmenuService) {
      linkmenu.setMenu(true, true, true, true);
  }

  ngOnInit(): void {

    this.id = this.route.snapshot.paramMap.get('id') || '';

    // this.route.paramMap.subscribe(params => {
    //   console.log(params.get('id'));
    //   this.id = params.get('id');
    // });
  }

  click(): void {
    alert('Data successfully sent');
  }

  openLogin() {
    const dialogRef = this.login.open(LoginComponent, {width: "40%"});
  }

  sendButton() {
    alert('Data successfully sent');
    this.router.navigateByUrl('result');
  }
}
