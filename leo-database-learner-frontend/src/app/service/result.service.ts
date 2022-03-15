import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class ResultService {

  constructor(public http: HttpClient) { }

  getResult(result : String): any {
    return this.http.post<String[]>('http://vm134.htl-leonding.ac.at:8080/exercise_sql/result', result);
  }

  getValidation(sql : string, id : number): any{
    return this.http.post<String[]>('http://vm134.htl-leonding.ac.at:8080/exercise_sql/validation', {sql: sql, id: id});
  }

}
