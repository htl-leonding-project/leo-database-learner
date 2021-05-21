import { Component, OnInit } from '@angular/core';
import {PersonService} from '../service/person.service';
import {Person} from '../models/person';
import {QuestionService} from '../service/question.service';
import {Question} from '../models/question';

@Component({
  selector: 'app-tasks',
  templateUrl: './tasks.component.html',
  styleUrls: ['./tasks.component.css']
})
export class TasksComponent implements OnInit {

  public tasks: Question[] = [];

  public person: Person[] = [];

  constructor(private personService: PersonService, private questionService: QuestionService) {
  }

  ngOnInit(): void {
    this.questionService.getAllQuestion().subscribe(q => this.tasks = q);
    this.personService.getAllPerson().subscribe(p => this.person = p);
  }
}
