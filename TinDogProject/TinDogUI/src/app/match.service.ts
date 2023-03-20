import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Dog } from './dog';
import { Owner } from './owner';

@Injectable({
  providedIn: 'root'
})
export class MatchService {

  constructor(private httpClient: HttpClient) { }

  CreateMatch(judgingId: string,judgedId:string, liked:boolean): Observable<any>
  {
    const formData = new FormData();
    formData.append("judgingId",judgingId);
    formData.append("judgedId",judgedId);
    formData.append("liked",JSON.stringify(liked));
    return this.httpClient.post<any>("http://localhost:8080/create-match",formData);
  }

  GetMatchesOfOwner(ownerId:string):Observable<Dog[]>
  {
    let queryParams = new HttpParams();
    queryParams = queryParams.append("ownerId",ownerId);
    return this.httpClient.get<Dog[]>("http://localhost:8080/get-matches-of-owner", {params:queryParams});
  }
}
