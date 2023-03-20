import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { BehaviorSubject, Observable } from 'rxjs';
import { Dog } from './dog';
import { Owner } from './owner';


@Injectable({
  providedIn: 'root'
})
export class OwnerService {

  private baseURL = "http://localhost:8080";
  constructor(private httpClient: HttpClient) { }

  RegisterOwnerProfile(id: string,name:string, lastname: string, profession: string,date:Date,gender:string,bio:string,file: File): Observable<Owner>
  {
    const formData = new FormData();
    formData.append("id",id);
    formData.append("name",name);
    formData.append("lastname",lastname);
    formData.append("profession",profession);
    formData.append("birthday", date.toLocaleString() );
    formData.append("gender",gender);
    formData.append("bio",bio);
    formData.append("multipartImage", file);
    return this.httpClient.post<any>("http://localhost:8080/create-owner",formData);
  }
  
  GetOwnerById(id:string){
    let queryParams = new HttpParams();
    queryParams = queryParams.append("id",id);
    return this.httpClient.get<Owner>("http://localhost:8080/owner", {params:queryParams});
  }

  GetOwnerPicture(id:string):Observable<Blob>{
    let queryParams = new HttpParams();
    queryParams = queryParams.append("id",id);
    return this.httpClient.get("http://localhost:8080/owner-image", {params:queryParams, responseType: 'blob'});
  }

  GetOwnerDog(id:string)
  {
      let queryParams = new HttpParams();
      queryParams = queryParams.append("ownerId",id);
    return this.httpClient.get<Dog>("http://localhost:8080/dogs-of-owner",{params:queryParams});
  }
  
  GetMatchOfOwner(id : string)
  {
    let queryParams = new HttpParams();
      queryParams = queryParams.append("ownerId",id);
    return this.httpClient.get<Owner[]>("http://localhost:8080/get-matches-of-owner",{params:queryParams});
  }



}
