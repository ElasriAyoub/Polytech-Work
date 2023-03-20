import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { UserService } from '../user.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  email!:string;
  password!:string;
  confirmpassword!: string;
  errorMessage!:string;
  constructor(private userService: UserService, private router: Router) { }

  ngOnInit(): void {
  }

register()
{
  if (this.password==this.confirmpassword)
  {
    this.userService.RegisterUser(this.email, this.password).subscribe(
      data => {
        console.log("user created")
        console.log(data);
        sessionStorage.setItem('id',data);
        this.router.navigate(['createProfile']);
      },
     error=>{
       console.log("error accured")
       this.errorMessage="Oups! an error occured while creating the user!";
     }
  );
  }
  else{
    console.log("les mots de passe sont incompatibles ")
  }


}
}
