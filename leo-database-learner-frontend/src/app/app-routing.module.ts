import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {TasksComponent} from './tasks/tasks.component';
import {TaskDetailComponent} from './task-detail/task-detail.component';
import { AboutComponent } from './about/about.component';
import { ImpressumComponent } from './impressum/impressum.component';
import { ProfilComponent } from './profil/profil.component';
import { LoginComponent } from './login/login.component';
import { HomeComponent } from './home/home.component';
import {ExamsComponent} from "./exams/exams.component";
import {KnowledgeComponent} from "./knowledge/knowledge.component";
import { ExcerciseComponent } from './excercise/excercise.component';


const routes: Routes = [
  { path: '', pathMatch: 'full', redirectTo: 'home' },
  {path: 'home', component: HomeComponent},
  { path: 'excercises/:name/:id', component: TaskDetailComponent},
  { path: 'excercises/:name', component: TasksComponent},
  { path: 'exams', component: ExamsComponent },
  { path: 'knowledge', component: KnowledgeComponent },
  {path: 'about', component: AboutComponent},
  {path: "impressum", component: ImpressumComponent},
  {path: "profile", component: ProfilComponent},
  {path: "login", component: LoginComponent},
  {path: "excercises", component: ExcerciseComponent},
  {path: "**", component: TasksComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
