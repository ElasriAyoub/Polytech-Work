import { Component, OnInit, ɵisBoundToModule } from '@angular/core';

import { MatSnackBar } from '@angular/material/snack-bar';
import { Dog } from '../dog';
import { DogService } from '../dog.service';
import { Owner } from '../owner';
import { OwnerService } from '../owner.service';
import { SnackbarComponent } from '../snackbar/snackbar.component';




@Component({
  selector: 'app-dog-profile',
  templateUrl: './dog-profile.component.html',
  styleUrls: ['./dog-profile.component.css']
})
export class DogProfileComponent implements OnInit {
  
  ownerId!:any;
  owner!:Owner;
  image!:any;
  ownerRetrieved:boolean = false;
  dog!:Dog;
  dogRetrieved:boolean = false;
  dogImage!:any;


  constructor(private _snackBar: MatSnackBar, private ownerService:OwnerService, private dogService:DogService) { }

  ngOnInit(): void {
    if(typeof history.state.data === "undefined"){
      this.ownerId = sessionStorage.getItem('id') as string;
    }else{
      this.ownerId = history.state.data;
    }
    this.ownerService.GetOwnerById(this.ownerId).subscribe(o => {
      this.owner = o;
      this.ownerService.GetOwnerPicture(this.ownerId).subscribe(img =>{
        let reader = new FileReader();
        reader.addEventListener("load", () => {this.image = reader.result;}, false);
        if (img) {
            reader.readAsDataURL(img);
        }
        this.ownerRetrieved = true;
      });
    });

    this.ownerService.GetOwnerDog(this.ownerId).subscribe(d =>{
      this.dog = d;
      this.dogService.GetDogPicture(d.id).subscribe(img =>{
        let reader = new FileReader();
        reader.addEventListener("load", () => {this.dogImage = reader.result;}, false);
        if (img) {
            reader.readAsDataURL(img);
        }
        this.dogRetrieved = true;
      });
    });

  }

}



