export class Person {

  id: number;
  firstName: string;
  lastName: string;
  password: string


  constructor(id: number, firstName: string, lastName: string, password: string) {
    this.id = id;
    this.firstName = firstName;
    this.lastName = lastName;
    this.password = password;
  }
}
