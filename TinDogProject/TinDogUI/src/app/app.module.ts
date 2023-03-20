import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { MessagerieComponent } from './messagerie/messagerie.component';



import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {MatFormFieldModule} from '@angular/material/form-field';
import { LoginComponent } from './login/login.component';
import { DogProfileComponent } from './dog-profile/dog-profile.component';
import { RegisterComponent } from './register/register.component';
import {MatSidenavModule} from '@angular/material/sidenav';
import {MatToolbarModule} from '@angular/material/toolbar';
import {MatIconModule} from '@angular/material/icon';
import {MatListModule} from '@angular/material/list';
import {MatButtonModule} from '@angular/material/button';
import { FormsModule, ReactiveFormsModule }    from '@angular/forms';
import { UserProfileComponent } from './user-profile/user-profile.component';
import { CreateProfileComponent } from './create-profile/create-profile.component';
import { FileUploadModule } from 'ng2-file-upload';
import { HomePageComponent } from './home-page/home-page.component';
import { RegisterDogyComponent } from './register-dogy/register-dogy.component';

import { MatSnackBarModule } from '@angular/material/snack-bar';
import { SnackbarComponent } from './snackbar/snackbar.component';
import { MatchesComponent } from './matches/matches.component';






@NgModule({
  declarations: [
    AppComponent,
    MessagerieComponent,
    LoginComponent,
    DogProfileComponent,
    RegisterComponent,
    UserProfileComponent,
    CreateProfileComponent,
    HomePageComponent,
    RegisterDogyComponent,
    SnackbarComponent,
    MatchesComponent

  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    FileUploadModule,
    HttpClientModule,
    ReactiveFormsModule,
    MatSidenavModule,
    MatToolbarModule,
    MatIconModule,
    MatListModule,
    MatButtonModule,
    MatFormFieldModule,
    MatSnackBarModule,
    BrowserAnimationsModule,


  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
