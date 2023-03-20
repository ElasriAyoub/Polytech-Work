import { Component, OnInit } from '@angular/core';
import { CreateDogProfileService } from '../create-dog-profile.service';
import { v4 as uuid } from 'uuid';
import { DogService } from '../dog.service';
import { Owner } from '../owner';
import { OwnerService } from '../owner.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-register-dogy',
  templateUrl: './register-dogy.component.html',
  styleUrls: ['./register-dogy.component.css']
})
export class RegisterDogyComponent implements OnInit {

  url='assets/img/Upload-Dog.png';
  ownerId: any;
  file: any;
  bio: any;
  fullname:any;
  date:any;
  gender:any;
  errorMessage:any;
  imageOk:boolean =false;

  formData = new FormData();
  constructor( private dogService: DogService, private ownerService: OwnerService, private router: Router) {

  }

  ngOnInit(): void {
  }

  onselectFile(e:any)
  {
    this.imageOk =false;
    if (e.target.files){
     this.file=e.target.files[0];
     this.formData.set("file", this.file);
      var reader = new FileReader();
      reader.readAsDataURL(e.target.files[0]);
      reader.onload=(event:any)=>{
        this.url=event.target.result;
        this.imageOk = true;
      }
    }
  }

  createProfile()
  {
    this.ownerId = sessionStorage.getItem('id');
    this.formData.set("file", this.file);
    this.dogService.CreateDogProfile(this.fullname,this.date,this.bio,this.gender,this.ownerId,this.file).subscribe(
      data => {
        console.log("response received")
        this.router.navigate(['messagerie']).then(() => {
          window.location.reload();
        });

      },
     error=>{
       console.log("error accured")
       this.errorMessage="Oups! an error occured while creating your profile!";
     }
  );}

  radioChangeHandler(event:any)
  { 
    this.gender=event.target.value;
  }

}
