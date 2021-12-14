import {Teacher} from './teacher';

export class Datamodel {

  name: string;
  comment: string;
  owner: Teacher;

  constructor(name: string, comment: string, owner: Teacher) {
    this.name = name;
    this.comment = comment;
    this.owner = owner;
  }
}
