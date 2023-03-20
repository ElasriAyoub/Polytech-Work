import { Component, OnInit } from '@angular/core';
import { stringify } from 'uuid';
import { Dog } from '../dog';
import { DogService } from '../dog.service';
import { MatchService } from '../match.service';

@Component({
  selector: 'app-messagerie',
  templateUrl: './messagerie.component.html',
  styleUrls: ['./messagerie.component.css']
})
export class MessagerieComponent implements OnInit {
  name!:any;
  formdata=new FormData();
  date!:any;
  file:any;
  bio!:any;
  j:number= 0;
  i:number= 0;
  path!:any;
  souslist: string[][]=[];
  dog=[];
  k!:any;
  
  mesg!:string;

  dogImage:any;
  currentDog!:Dog;
  dogList!:any;
  dogsCollected:boolean = false;
  imageCollected:boolean = false;
  noMoreDogsToShow:boolean = false;

  constructor(private dogService:DogService, private matchService:MatchService) { }

  ngOnInit(): void {
    this.dogsCollected = false;
      console.log(sessionStorage.getItem('id'));
      this.dogService.GetDogsToShowToOwner(sessionStorage.getItem('id') as string).subscribe(response =>{
        if(response.length == 0){
          this.noMoreDogsToShow = true;
        }
        else{
          this.dogService.GetDogPicture(response[this.i].id).subscribe(image =>{
            this.createImageFromBlob(image);
            this.dogList = response;
            this.dogsCollected = true;
            this.imageCollected = true;
            this.currentDog = this.dogList[this.i]
            console.log(this.dogList);
          }, error =>{
            console.log("Error occured",error);
          });
        }
      });  
  }

  createImageFromBlob(image: Blob) {
    let reader = new FileReader();
    reader.addEventListener("load", () => {
       this.dogImage = reader.result;
    }, false);
 
    if (image) {
       reader.readAsDataURL(image);
    }
  }

  swipeYES()
  {
    this.imageCollected = false;
    this.dogService.GetOwnerIdByDogId(this.currentDog.id).subscribe(ownerId =>{
      this.matchService.CreateMatch(sessionStorage.getItem('id') as string, ownerId, true).subscribe(() => {
        this.i = this.i + 1;

        if(typeof this.dogList[this.i] === 'undefined'){
          this.noMoreDogsToShow = true;
          this.dogsCollected = false;
        }
        else{
          this.currentDog = this.dogList[this.i];
          this.dogService.GetDogPicture(this.currentDog.id).subscribe(image =>{
            this.createImageFromBlob(image);
            this.imageCollected = true;
          });
        }
      });
    });
  }


  swipeNO()
  {
    this.imageCollected = false;
    this.dogService.GetOwnerIdByDogId(this.currentDog.id).subscribe(ownerId =>{
      this.matchService.CreateMatch(sessionStorage.getItem('id') as string, ownerId, false).subscribe(() => {
        this.i = this.i + 1;

        if(typeof this.dogList[this.i] === 'undefined'){
          this.noMoreDogsToShow = true;
          this.dogsCollected = false;
        }
        else{
          this.currentDog = this.dogList[this.i];
          this.dogService.GetDogPicture(this.currentDog.id).subscribe(image =>{
            this.createImageFromBlob(image);
            this.imageCollected = true;
          });
        }
      });
    });
  }

  
send()
{
  let mydiv=document.getElementById("mymsg");
  console.log(this.mesg);
  let newp=document.createElement('p');
  newp.style.marginLeft=' auto'
  newp.style.borderRadius='20px'
  newp.style.lineHeight='25px';
  newp.style.height='50px'
   newp.style.width='50%'
   newp.style.fontSize='18px'
   newp.style.alignItems='center'
   newp.style.textAlign='center'
   newp.style.alignItems='center';
  newp.style.color='white'
  newp.style.background='#0078FF';
  newp.style.marginRight='10px';
  newp.textContent=this.mesg;
  mydiv?.prepend(newp);
}
}
