import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { FormsModule } from '@angular/forms';
import { FooterComponent } from './layouts/footer/footer.component';
import { HeaderComponent } from './layouts/header/header.component';
import { SidebarComponent } from './layouts/sidebar/sidebar.component';
import { EtablissementsComponent } from './components/etablissements/etablissements.component';
import { FilieresComponent } from './components/filieres/filieres.component';
import { HomeComponent } from './pages/home/home.component';
import {HttpClientModule} from "@angular/common/http";
import { PlanningExamensComponent } from './components/planning-examens/planning-examens.component';
import { JournalistesComponent } from './components/Journal/journalistes/journalistes.component';
import { ArticlesComponent } from './components/Journal/articles/articles.component';
import { ExamensComponent } from './components/planning-examens/examens/examens.component';
import { DepartementsComponent } from './components/etablissements/departements/departements.component';
import {CheckExistValidatorDirective} from "./directives/CheckExistValidator.directive";
import {NumberValidatorDirective} from "./directives/number-validator.directive";
import {FileCheckValidatorDirective} from "./directives/FileCheckValidator.directive";


@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    FooterComponent,
    SidebarComponent,
    EtablissementsComponent,
    FilieresComponent,
    HomeComponent,
    PlanningExamensComponent,
    JournalistesComponent,
    ArticlesComponent,
    ExamensComponent,
    DepartementsComponent,
    CheckExistValidatorDirective,
    NumberValidatorDirective,
    FileCheckValidatorDirective
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
