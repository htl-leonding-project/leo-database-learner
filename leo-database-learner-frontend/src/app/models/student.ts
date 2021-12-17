import { Person } from "./person";

export class Student extends Person{
  classname: string;


  constructor(classname: string, firstName: string, lastName: string, password: string) {
    super(firstName, lastName, password)
    this.classname = classname;
  }
}
