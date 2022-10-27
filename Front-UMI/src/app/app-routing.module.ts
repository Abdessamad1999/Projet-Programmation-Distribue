import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { EtablissementsComponent } from './components/etablissements/etablissements.component';
import { FilieresComponent } from './components/filieres/filieres.component';
import {PlanningExamensComponent} from "./components/planning-examens/planning-examens.component";
import {ExamensComponent} from "./components/planning-examens/examens/examens.component";
import {DepartementsComponent} from "./components/etablissements/departements/departements.component";
import {JournalistesComponent} from "./components/Journal/journalistes/journalistes.component";
import {ArticlesComponent} from "./components/Journal/articles/articles.component";

const routes: Routes = [
  {path:'etablissements',component:EtablissementsComponent},
  {path:':idEtablissement/departements',component:DepartementsComponent},
  {path:':idEtablissement/filieres',component:FilieresComponent},
  {path:'filieres',component:FilieresComponent},
  {path:'planningExamens',component:PlanningExamensComponent},
  {path:'planningExamens/examens/:id',component:ExamensComponent},
  {path:'journalistes',component:JournalistesComponent},
  {path:'articles',component:ArticlesComponent},
  {path:':idJournaliste/articles',component:ArticlesComponent},
  //{path:'**',component:EtablissementsComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
