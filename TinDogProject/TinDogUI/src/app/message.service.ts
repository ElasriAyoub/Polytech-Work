import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Message } from './message';
import { MessageDto } from './messagedto';

@Injectable({
  providedIn: 'root'
})
export class MessageService {

  constructor(private httpClient: HttpClient) { }

  GetConversation(senderId:string, receiverId:string):Observable<MessageDto[]>{
    let queryParams = new HttpParams();
    queryParams = queryParams.append("senderId",senderId);
    queryParams = queryParams.append("receiverId",receiverId);
    return this.httpClient.get<MessageDto[]>("http://localhost:8080/conversation", {params:queryParams});
  }

  SendMessage(senderId:string, receiverId:string, messageBody:string):Observable<Message>{
    const formData = new FormData();
    formData.append("senderId",senderId);
    formData.append("receiverId",receiverId);
    formData.append("messageBody",messageBody);
    return this.httpClient.post<any>("http://localhost:8080/send-message",formData);

  }
}
