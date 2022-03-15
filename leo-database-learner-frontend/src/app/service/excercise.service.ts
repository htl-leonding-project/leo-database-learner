import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';
import { ExercisePackage } from '../models/exercisePackage';

@Injectable({
  providedIn: 'root'
})
export class ExcerciseService {

  constructor(private http: HttpClient) { }

  getExcercises(): any {
    return this.http.get<ExercisePackage[]>(environment.apiUrl + 'exercisePackage/get_all');
  }

  getExcercisesById(id: number) : any{
    return this.http.get<ExercisePackage>( environment.apiUrl + 'exercisePackage/getbyid/' + id);
  }

}
