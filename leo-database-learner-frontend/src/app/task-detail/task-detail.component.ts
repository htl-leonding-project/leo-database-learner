import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import {LoginComponent} from "../login/login.component";
import {MatDialog} from "@angular/material/dialog";
import { LinkmenuService } from '../service/linkmenu.service';
import { ResultComponent } from '../result/result.component';
import { ResultService } from '../service/result.service';
import { Question } from '../models/question';
import { QuestionService } from '../service/question.service';
import { ExcerciseService } from '../service/excercise.service';
import { ExercisePackage } from '../models/exercisePackage';

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
  public question : Question;
  public excercise : ExercisePackage;

  public header : String[];
  public val : String[] = [];
  public tabledata : String[][] = [];
  public errormessage : String;
  public error : Boolean = false;

  constructor(public eService : ExcerciseService,public questionService: QuestionService, private route: ActivatedRoute, public resultService: ResultService, public login: MatDialog, public showresult: MatDialog, private router: Router, public linkmenu: LinkmenuService) {
      linkmenu.setMenu(true, true, true, true);
  }

  ngOnInit(): void {
    var urls = this.router.url.split("/");
    this.eService.getExcercisesById(Number(urls[urls.length-2])).subscribe((data : ExercisePackage) => {this.excercise = data});
    this.questionService.getQuestionById(Number(urls[urls.length-1])).subscribe(data => {this.question = data});
  }

  evaluate() {
    this.error = false;
    this.errormessage = "";
    this.result = [];

    this.resultService.getResult(this.input).subscribe((data : String[]) => {
      this.result = data;
      //alert(data);

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
        if(this.val.length <= 1){
          document.getElementById("input").style.borderColor = "#8FFF93";
          document.getElementById("input").style.pointerEvents = "none";
        }
      });
  }

  openDialog(){
    const dialogRef = this.showresult.open(ResultComponent, {width: "40%"});
  }

  navigateTo(){
    this.router.navigate(["excercises/" + this.excercise.id])
  }
}
