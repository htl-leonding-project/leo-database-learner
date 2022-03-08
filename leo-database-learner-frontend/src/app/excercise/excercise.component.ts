import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ExercisePackage } from '../models/exercisePackage';
import { ExcerciseService } from '../service/excercise.service';

@Component({
  selector: 'app-excercise',
  templateUrl: './excercise.component.html',
  styleUrls: ['./excercise.component.css']
})
export class ExcerciseComponent implements OnInit {
  public excercises : ExercisePackage[] = [];

  constructor(public excersiceService: ExcerciseService, private router: Router) { }

  ngOnInit(): void {
    this.excersiceService.getExcercises().subscribe((data : any) => {this.excercises = data});
  }

  navigateTo(ex : ExercisePackage){
    this.router.navigate(["excercises/" + ex.id])
  }

}
