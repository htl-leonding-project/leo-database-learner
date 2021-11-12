export class Person {

  id: number;
  firstName: string;
  lastName: string;
  role: string;


  constructor(id: number, firstName: string, lastName: string, role: string) {
    this.id = id;
    this.firstName = firstName;
    this.lastName = lastName;
    this.role = role;
  }
}
