import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Dog } from './dog';
import { Owner } from './owner';

@Injectable({
  providedIn: 'root'
})
export class DogService {

  CreateDogProfile(dogname: string, birthday:Date,bio:string, gender:string, ownerId:string ,file: File): Observable<Dog>
  {
    const formData = new FormData();
    formData.append("dogname",dogname);
    formData.append("birthday", birthday.toLocaleString());
    formData.append("bio",bio);
    formData.append("gender",gender);
    formData.append("ownerId",ownerId);
    formData.append("multipartImage", file);
    return this.httpClient.post<any>("http://localhost:8080/create-dog",formData);
  }

  constructor(private httpClient: HttpClient) { }

  GetDogsToShowToOwner(ownerId:string):Observable<Dog[]>{
    let queryParams = new HttpParams();
    queryParams = queryParams.append("ownerId",ownerId);
    return this.httpClient.get<Dog[]>("http://localhost:8080/dogs-to-show", {params:queryParams});
  }

  GetDogPicture(id:string):Observable<Blob>{
    let queryParams = new HttpParams();
    queryParams = queryParams.append("id",id);
    return this.httpClient.get("http://localhost:8080/dog-image", {params:queryParams, responseType: 'blob'});
  }

  GetOwnerIdByDogId(id:string):Observable<string>{
    let queryParams = new HttpParams();
    queryParams = queryParams.append("id",id);
    return this.httpClient.get("http://localhost:8080/find-owner-id", {params:queryParams, responseType: 'text'});
  }

  GetDogByOwnerId(ownerId:string):Observable<Dog>{
    let queryParams = new HttpParams();
    queryParams = queryParams.append("ownerId",ownerId);
    return this.httpClient.get<Dog>("http://localhost:8080/find-dog-by-owner", {params:queryParams});
  }

}
