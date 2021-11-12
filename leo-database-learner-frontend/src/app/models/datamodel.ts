import {Person} from './person';

export class Datamodel {

  name: string;
  comment: string;
  owner: Person;

  constructor(name: string, comment: string, owner: Person) {
    this.name = name;
    this.comment = comment;
    this.owner = owner;
  }
}
