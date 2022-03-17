import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Person} from '../models/person';
import {Question} from '../models/question';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class QuestionService {

  constructor(private http: HttpClient) { }

  getAllQuestion(): Observable<Question[]>{
    return this.http.get<Question[]>(environment.apiUrl + 'question/get_all');  }

  getQuestionsFormPackage(): Observable<Question[]>{
    return this.http.get<Question[]>(environment.apiUrl + 'question/get_all');
  }

  getById(id : number) : any{
    return this.http.get<Question[]>(environment.apiUrl + 'question/getbypackageid/' + id)
  }

  getQuestionById(id : number) : any{
    return this.http.get<Question>(environment.apiUrl + 'question/getbyid/' + id)
  }

}
