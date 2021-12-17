import { Student } from "./student";
import {ExercisePackage} from "./exercisePackage";

export class Assignment {
  student: Student;
  exPackage: ExercisePackage;


  constructor(student: Student, exPackage: ExercisePackage) {
    this.student = student;
    this.exPackage = exPackage;
  }
}
