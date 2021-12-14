export class Assignment {
  student: Student;
  exPackage: ExercisePackage;


  constructor(student: Student, exPackage: ExercisePackage) {
    this.student = student;
    this.exPackage = exPackage;
  }
}
