import { Component, OnInit } from '@angular/core';
import {PersonService} from '../service/person.service';
import {Person} from '../models/person';
import {QuestionService} from '../service/question.service';
import {Question} from '../models/question';
import {MatDialog} from '@angular/material/dialog';
import { LoginComponent } from '../login/login.component';
import { LinkmenuService } from '../service/linkmenu.service';

@Component({
  selector: 'app-tasks',
  templateUrl: './tasks.component.html',
  styleUrls: ['./tasks.component.css']
})
export class TasksComponent implements OnInit {

  public tasks: Question[] = [];

  public person: Person[] = [];

  constructor(private personService: PersonService, public questionService: QuestionService, public login: MatDialog, public linkmenu : LinkmenuService) {
    linkmenu.setMenu(true, true, true, true);
  }

  ngOnInit(): void {
    this.questionService.getAllQuestion().subscribe(data => {this.tasks = data});
    this.personService.getAllPerson().subscribe(p => this.person = p);

  }

  openLogin(){
    const dialogRef = this.login.open(LoginComponent,{width:"40%"});

    dialogRef.afterClosed().subscribe(result => {
      console.log(`Dialog result: ${result}`);
    });

  }

}
