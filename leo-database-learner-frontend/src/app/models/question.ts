import {ExercisePackage} from "./exercisePackage";

export class Question {

  name: string;
  text: string;
  sql: string;
  points: number;
  localdate: Date;
  exercisePackage: ExercisePackage;


  constructor(name: string, text: string, sql: string, points: number, localdate: Date, exercisePackage: ExercisePackage) {
    this.name = name;
    this.text = text;
    this.sql = sql;
    this.points = points;
    this.localdate = localdate;
    this.exercisePackage = exercisePackage;
  }
}
