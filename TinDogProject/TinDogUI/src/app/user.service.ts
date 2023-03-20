import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { User } from './user';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  private baseURL = "http://localhost:8080";
  constructor(private httpClient: HttpClient) { }

  RegisterUser(email:string, password: string): Observable<any>
  {
    const formData = new FormData();
    formData.append("email",email);
    formData.append("password",password);
    return this.httpClient.post<User>("http://localhost:8080/create-user", formData);
  }

  LoginUser(email:string, password: string): Observable<any>
  {
    const formData = new FormData();
    formData.append("email",email);
    formData.append("password",password);
    return this.httpClient.post<any>("http://localhost:8080/login",formData);
  }
}
