import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { FileUploader } from 'ng2-file-upload';
import { OwnerService } from '../owner.service';
import { v4 as uuid } from 'uuid';
import { Router } from '@angular/router';
@Component({
  selector: 'app-create-profile',
  templateUrl: './create-profile.component.html',
  styleUrls: ['./create-profile.component.css']
})
export class CreateProfileComponent implements OnInit {
  url='assets/img/Upload-Profile.png';
  name!: string;
  lastname!:string;
  date!:Date;
  profession!: string;
  bio!: string;
  formData = new FormData()
  file: any;
  gender!: string;
  errorMessage!: string;
  id!: any;
  imageOk:boolean = false;
  constructor(private ownerService: OwnerService,  private router: Router) { }

  ngOnInit(): void {
  }

  onselectFile(e:any)
  {
    this.imageOk = false;
    if (e.target.files){
      this.file = e.target.files[0];
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
    this.id=sessionStorage.getItem('id');
    //this.formData.set("file", this.file);
    this.ownerService.RegisterOwnerProfile(this.id,this.name,this.lastname,this.profession,this.date,this.gender,this.bio,this.file).subscribe(
      data => {
        console.log("response received")
        this.router.navigate(['createProfileDog']);

      },
     error=>{
       console.log("error accured")
       this.errorMessage="Oups! an error occured while creating your profile!";
     }
  );
  }

radioChangeHandler(event:any)
{
   this.gender=event.target.value;
}
}
