import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { UserService } from '../user.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  email!:string;
  password!:string;
  errorMessage!:string;
  constructor(private router:Router,private userService: UserService) { }

  ngOnInit(): void {

  // window.location.reload();

  }
  reload()
  {
    window.location.reload();
  }



  login()
  {
    this.userService.LoginUser(this.email, this.password).subscribe(
      data => {
        console.log("your session is started")
        console.log(data);
        this.router.navigate(['messagerie'])
        .then(() => {
          window.location.reload();
        });
        sessionStorage.setItem('id',data)

      },
     error=>{
       console.log("error accured")
       this.errorMessage="Oups! an error occured while creating your session!";
     }
  );
    console.log("username",this.email);
    console.log("password",this.password);

  }
  
  /*login()
  {
    sessionStorage.setItem('id','1');

    this.router.navigate(['messagerie'])
    .then(() => {
      window.location.reload();
    });
  }*/
}
