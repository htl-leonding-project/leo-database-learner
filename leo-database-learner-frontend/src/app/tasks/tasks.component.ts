import { Component, OnInit } from '@angular/core';
import {PersonService} from '../service/person.service';
import {Person} from '../models/person';
import {QuestionService} from '../service/question.service';
import {Question} from '../models/question';
import {MatDialog} from '@angular/material/dialog';
import { LoginComponent } from '../login/login.component';
import { LinkmenuService } from '../service/linkmenu.service';
import { Router } from '@angular/router';
import { ExercisePackage } from '../models/exercisePackage';
import { ExcerciseService } from '../service/excercise.service';

@Component({
  selector: 'app-tasks',
  templateUrl: './tasks.component.html',
  styleUrls: ['./tasks.component.css']
})
export class TasksComponent implements OnInit {

  public tasks: Question[] = [];
  public excercise : ExercisePackage;

  constructor(public excerciseService : ExcerciseService ,public questionService: QuestionService, public login: MatDialog, public linkmenu : LinkmenuService, public router : Router) {
    linkmenu.setMenu(true, true, true, true);
  }

  ngOnInit(): void {
    var urls = this.router.url.split("/");
    this.excerciseService.getExcercisesById(Number(urls[urls.length-1])).subscribe((data : ExercisePackage) => {this.excercise = data})
    this.questionService.getById(Number(urls[urls.length-1])).subscribe(data => {this.tasks = data});
    
  }

}
