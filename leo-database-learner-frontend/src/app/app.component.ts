import {Component, OnInit} from '@angular/core';
import {PersonService} from "./person.service";
import {Person} from "./models/person";
import {HttpClient} from "@angular/common/http";

// interface Person {
//   firstname: string;
//   lastname: string;
//   role: string;
// }

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit{
  title = 'leo-database-learner-frontend';
  public person!: Person;
  //people: Person[] = [];

  constructor(private personService: PersonService) {
  }

  public showPerson(){
    this.personService.getPerson().subscribe(p => this.person = p);
    console.log(this.person);
  }

  // async loadPeople() {
  //   this.people = await this.http
  //     .get<Person[]>('http://localhost:8080/person/getAll')
  //     .toPromise();
  //
  // }

  ngOnInit(): void {
    //this.personService.getPerson().subscribe(data => this.person = data);
  }

}
