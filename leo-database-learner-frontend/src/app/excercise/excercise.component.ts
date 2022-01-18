import { Component, OnInit } from '@angular/core';
import { ExercisePackage } from '../models/exercisePackage';
import { ExcerciseService } from '../service/excercise.service';

@Component({
  selector: 'app-excercise',
  templateUrl: './excercise.component.html',
  styleUrls: ['./excercise.component.css']
})
export class ExcerciseComponent implements OnInit {
  public excercises : ExercisePackage[] = [];

  constructor(public excersiceService: ExcerciseService) { }

  ngOnInit(): void {
    this.excersiceService.getExcercises().subscribe((data : any) => {this.excercises = data});
  }

}
