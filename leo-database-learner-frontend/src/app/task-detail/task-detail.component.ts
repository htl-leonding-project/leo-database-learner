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

  public header : String[];
  public val : String[] = [];
  public tabledata : String[][] = [];
  public errormessage : String;
  public error : Boolean = false;

  constructor(private route: ActivatedRoute, public resultService: ResultService, public login: MatDialog, public showresult: MatDialog, private router: Router, public linkmenu: LinkmenuService) {
      linkmenu.setMenu(true, true, true, true);
  }

  ngOnInit(): void {
  }

  evaluate() {
    this.error = false;
    this.resultService.getResult(this.input).subscribe((data : String[]) => {
      this.result = data;

      if(this.result[0] != "ERROR"){
        this.header = this.result[0].split(" ");
  
        for (let index = 1; index < this.result.length; index++) {
          var store : String[] = this.result[index].split(" ");
          this.tabledata[index-1] = [];
          for (let index2 = 0; index2 < this.header.length; index2++) {
      
            this.tabledata[(index - 1)][index2] = store[index2];
          }
        }
        this.showValidations();
      }else{
        this.error = true;
        this.errormessage = this.result.toString();
        this.showValidations();
      }
    });
    
  }

  showValidations(){
    var urls = this.router.url.split("/");
      this.resultService.getValidation(this.input, Number(urls[urls.length-1])).subscribe((data: String[]) =>{
        this.val = data;
      });
  }
}
