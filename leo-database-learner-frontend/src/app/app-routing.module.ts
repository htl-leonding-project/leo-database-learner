import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {TasksComponent} from './tasks/tasks.component';
import {TaskDetailComponent} from './task-detail/task-detail.component';
import { AboutComponent } from './about/about.component';
import { ImpressumComponent } from './impressum/impressum.component';
import { ProfilComponent } from './profil/profil.component';
import { LoginComponent } from './login/login.component';
import { HomeComponent } from './home/home.component';
import {ResultComponent} from "./result/result.component";
import {ExamsComponent} from "./exams/exams.component";
import {KnowledgeComponent} from "./knowledge/knowledge.component";

const routes: Routes = [
  { path: '', pathMatch: 'full', redirectTo: 'home' },
  {path: 'home', component: HomeComponent},
  { path: 'tasks', component: TasksComponent },
  { path: 'tasks/:id', component: TaskDetailComponent},
  { path: 'exams', component: ExamsComponent },
  { path: 'knowledge', component: KnowledgeComponent },
  {path: 'about', component: AboutComponent},
  {path: "impressum", component: ImpressumComponent},
  {path: "profile", component: ProfilComponent},
  {path: "login", component: LoginComponent},
  {path: "result", component: ResultComponent},
  {path: "**", component: TasksComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
