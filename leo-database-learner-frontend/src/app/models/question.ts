import {Person} from './person';
import {Datamodel} from './datamodel';

export class Question {

  id: number;
  text: string;
  sql: string;
  points: number;
  localdate: number;
  datamodel: Datamodel;
  owner: Person;


  constructor(id: number, text: string, sql: string, points: number, localdate: number, datamodel: Datamodel, owner: Person) {
    this.id = id;
    this.text = text;
    this.sql = sql;
    this.points = points;
    this.localdate = localdate;
    this.datamodel = datamodel;
    this.owner = owner;
  }
}
