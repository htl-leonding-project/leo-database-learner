import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { ExercisePackage } from '../models/exercisePackage';

@Injectable({
  providedIn: 'root'
})
export class ExcerciseService {

  constructor(private http: HttpClient) { }

  getExcercises(): any {
    return this.http.get<ExercisePackage[]>('http://localhost:8080/exercisePackage/get_all');
  }
 
  getExcercisesById(id: number) : any{
    return this.http.get<ExercisePackage>('http://localhost:8080/exercisePackage/getbyid/' + id);
  }
  
}
