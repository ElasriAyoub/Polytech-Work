import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Dog } from '../dog';
import { DogService } from '../dog.service';
import { MatchService } from '../match.service';
import { MessageService } from '../message.service';
import { MessageDto } from '../messagedto';
import { Owner } from '../owner';
import { OwnerService } from '../owner.service';

@Component({
  selector: 'app-matches',
  templateUrl: './matches.component.html',
  styleUrls: ['./matches.component.css']
})
export class MatchesComponent implements OnInit {
  chatWindow!:any;
  matches!:Dog[];
  image!:any;
  conversation!: MessageDto[];
  matchesRetrieved:boolean = false;
  conversationOpen:boolean = false;
  conversationRetrieved:boolean = true;
  imageRetrieved:boolean = false;
  currentDog!:Dog;
  senderId!:string;
  message!:string;

  
  constructor(private matchService:MatchService, private dogService:DogService, private messageService:MessageService,
    private router:Router) { }


  ngOnInit(): void {
    this.senderId = sessionStorage.getItem('id') as string; 
    this.matchService.GetMatchesOfOwner(sessionStorage.getItem('id') as string).subscribe(listOfMatch => {
      this.matches = listOfMatch;
      this.matchesRetrieved = true;
      this.save(this.matches[0]);
    });
  }

  sendData(dog:Dog){
    this.router.navigate(['profile'],{state:{data:dog.ownerId}})
  }

  createImageFromBlob(image: Blob) {
    let reader = new FileReader();
    reader.addEventListener("load", () => {
       this.image = reader.result;
    }, false);
 
    if (image) {
       reader.readAsDataURL(image);
    }
  }

  save(dog: Dog)
  {
    this.imageRetrieved = false;
    this.conversationRetrieved = false;
    this.conversationOpen = true;
    this.currentDog = dog;
    this.messageService.GetConversation(sessionStorage.getItem('id') as string, this.currentDog.ownerId).subscribe(conv =>{
      this.conversation = conv;
      console.log(this.conversation);
      this.conversationRetrieved = true;
      this.dogService.GetDogPicture(this.currentDog.id).subscribe(image => {
        this.createImageFromBlob(image);
        this.imageRetrieved = true;
      })
    })
  }

  send(){
    this.conversationRetrieved = false;
    this.messageService.SendMessage(this.senderId, this.currentDog.ownerId, this.message).subscribe(message => {
      this.messageService.GetConversation(sessionStorage.getItem('id') as string, this.currentDog.ownerId).subscribe(conv =>{
        this.conversation = conv;
        this.conversationRetrieved = true;
        this.message= "";
      });
    }); 
  }
}
