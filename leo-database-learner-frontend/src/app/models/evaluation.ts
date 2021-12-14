import {Question} from "./question";

export class Evaluation {
  reachedPoints: number;
  student: Student;
  question: Question;


  constructor(reachedPoints: number, student: Student, question: Question) {
    this.reachedPoints = reachedPoints;
    this.student = student;
    this.question = question;
  }
}
