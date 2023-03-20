import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/internal/Observable';

@Injectable({
  providedIn: 'root'
})
export class CreateDogProfileService {

  private baseURL = "http://localhost:3306";
  constructor(private httpClient: HttpClient) { }
  RegisterDogProfile(id: string,name:string,date:Date,bio:string,file: FormData,): Observable<any>
  {
    return this.httpClient.post<any>("http://localhost:3306/create-dog",{id,name,date,bio,file});
  }
}
