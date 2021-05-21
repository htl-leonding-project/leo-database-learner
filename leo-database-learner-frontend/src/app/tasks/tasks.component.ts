import { Component, OnInit } from '@angular/core';
import {PersonService} from '../person.service';
import {Person} from '../models/person';

@Component({
  selector: 'app-tasks',
  templateUrl: './tasks.component.html',
  styleUrls: ['./tasks.component.css']
})
export class TasksComponent implements OnInit {

  public tasks = [
    {name: 'Task1', id: 1},
    {name: 'Task2', id: 2},
    {name: 'Task3', id: 3}
  ];

  public person: Person[] = [];

  constructor(private personService: PersonService) {
  }

  ngOnInit(): void {
    this.personService.getAllPerson().subscribe(p => this.person = p);
  }
}
