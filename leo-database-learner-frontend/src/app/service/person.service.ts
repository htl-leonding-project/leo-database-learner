import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Person} from '../models/person';

@Injectable({
  providedIn: 'root'
})
export class PersonService {

  constructor(private http: HttpClient) { }

  getPerson(): Observable<Person>{
    return this.http.get<Person>('http://localhost:8080/exercisesql/person');  }

  getAllPerson(): Observable<Person[]>{
    return this.http.get<Person[]>('http://localhost:8080/person/get_all');  }

}
