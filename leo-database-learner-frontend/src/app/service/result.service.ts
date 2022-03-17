import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class ResultService {

  constructor(public http: HttpClient) { }

  getResult(result : String): any {
    return this.http.post<String[]>(environment.apiUrl + 'exercise_sql/result', result);
  }

  getValidation(sql : string, id : number): any{
    return this.http.post<String[]>(environment.apiUrl + 'exercise_sql/validation', {sql: sql, id: id});
  }

}
