import { Component, OnInit } from '@angular/core';

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

  constructor() { }

  ngOnInit(): void {
  }
}
