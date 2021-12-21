import {Question} from "./question";
import {Student} from "./student";

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
