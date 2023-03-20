import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CreateProfileComponent } from './create-profile/create-profile.component';
import { DogProfileComponent } from './dog-profile/dog-profile.component';
import { HomePageComponent } from './home-page/home-page.component';
import { LoginComponent } from './login/login.component';
import { MatchesComponent } from './matches/matches.component';
import { MessagerieComponent } from './messagerie/messagerie.component';
import { RegisterDogyComponent } from './register-dogy/register-dogy.component';
import { RegisterComponent } from './register/register.component';
import { UserProfileComponent } from './user-profile/user-profile.component';


const routes: Routes = [
  {path: 'profile', component: DogProfileComponent},
  {path: 'registration', component: RegisterComponent},
  {path: 'userProfile', component: UserProfileComponent},
  {path: 'messagerie', component: MessagerieComponent},
  {path: 'login', component: LoginComponent},
  {path: 'createProfile', component: CreateProfileComponent},
  {path: 'matches', component: MatchesComponent},
  {path: 'createProfileDog', component: RegisterDogyComponent},
  {path: 'home', component:HomePageComponent},
  {path: '', redirectTo: 'login', pathMatch: 'full'},
]


@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
