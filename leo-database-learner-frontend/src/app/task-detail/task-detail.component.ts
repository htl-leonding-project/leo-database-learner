import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import {LoginComponent} from "../login/login.component";
import {MatDialog} from "@angular/material/dialog";
import { LinkmenuService } from '../service/linkmenu.service';
import { ResultComponent } from '../result/result.component';
import { ResultService } from '../service/result.service';

export interface DialogData{
  result: String[];
}

@Component({
  selector: 'app-task-detail',
  templateUrl: './task-detail.component.html',
  styleUrls: ['./task-detail.component.css']
})
export class TaskDetailComponent implements OnInit {

  public input : string;
  public result : String[];

  constructor(private route: ActivatedRoute, public resultService: ResultService, public login: MatDialog, public showresult: MatDialog, private router: Router, public linkmenu: LinkmenuService) {
      linkmenu.setMenu(true, true, true, true);
  }

  ngOnInit(): void {
  }

  evaluate() {
    console.log(this.input);
    this.resultService.getResult(this.input).subscribe((data : String[]) => {
      this.result = data
      const dialogRef = this.showresult.open(ResultComponent, {width: "40%",
      data: {
        result: this.result
      },});
    });
    
  }
  
  showResult() {
    const dialogRef = this.showresult.open(ResultComponent, {width: "40%",
    data: {
      result: this.result
    },});
  }
}
