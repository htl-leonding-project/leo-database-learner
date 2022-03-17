import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import {MatListModule} from '@angular/material/list';
import { TasksComponent } from './tasks/tasks.component';
import { TaskDetailComponent } from './task-detail/task-detail.component';
import { MatFormFieldModule } from '@angular/material/form-field';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MatToolbarModule } from '@angular/material/toolbar';
import { MatIconModule } from '@angular/material/icon';
import { MatInputModule } from '@angular/material/input';
import {MatButton, MatButtonModule} from '@angular/material/button';
import {FormsModule} from '@angular/forms';
import {MatCardModule} from '@angular/material/card';
import { HttpClientModule } from '@angular/common/http';
import {MatSidenavModule} from '@angular/material/sidenav';
import { AboutComponent } from './about/about.component';
import { ProfilComponent } from './profil/profil.component';
import { ImpressumComponent } from './impressum/impressum.component';
import { LoginComponent } from './login/login.component';
import {MatDialogModule} from '@angular/material/dialog';
import { HomeComponent } from './home/home.component';
import {MatRadioModule} from "@angular/material/radio";
import {MatButtonToggleModule} from "@angular/material/button-toggle";
import { ExamsComponent } from './exams/exams.component';
import { KnowledgeComponent } from './knowledge/knowledge.component';
import { LinkmenuService } from './service/linkmenu.service';
import { ExcerciseComponent } from './excercise/excercise.component';
import { ExcerciseService } from './service/excercise.service';
import {MatDividerModule} from '@angular/material/divider';
import { ResultComponent } from './result/result.component';
import { ResultService } from './service/result.service';
import {MatSnackBarModule} from '@angular/material/snack-bar';

@NgModule({
  declarations: [
    AppComponent,
    TasksComponent,
    TaskDetailComponent,
    AboutComponent,
    ProfilComponent,
    ImpressumComponent,
    LoginComponent,
    HomeComponent,
    ExamsComponent,
    KnowledgeComponent,
    ExcerciseComponent,
    ResultComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    MatListModule,
    HttpClientModule,
    MatListModule,
    MatFormFieldModule,
    BrowserAnimationsModule,
    MatToolbarModule,
    MatIconModule,
    MatInputModule,
    MatCardModule,
    MatButtonModule,
    FormsModule,
    MatSidenavModule,
    MatDialogModule,
    MatRadioModule,
    MatButtonToggleModule,
    MatDividerModule,
    MatSnackBarModule
  ],
  providers: [LinkmenuService, ExcerciseService, ResultService],
  bootstrap: [AppComponent]
})
export class AppModule { }
