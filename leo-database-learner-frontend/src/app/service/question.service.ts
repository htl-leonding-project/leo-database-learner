import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Person} from '../models/person';
import {Question} from '../models/question';

@Injectable({
  providedIn: 'root'
})
export class QuestionService {

  constructor(private http: HttpClient) { }

  getAllQuestion(): Observable<Question[]>{
    return this.http.get<Question[]>('http://localhost:8080/question/get_all');  }

}
