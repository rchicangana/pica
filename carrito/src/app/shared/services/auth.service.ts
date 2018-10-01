import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { User, Usuario } from "../models/user";
import { AngularFireAuth } from "angularfire2/auth";
import { Router } from "@angular/router";
import { HttpClient, HttpHeaders } from '@angular/common/http';

@Injectable()
export class AuthService {
  //user: Observable<firebase.User>;
  //userDetails: firebase.User = null;
  apiUrl :string = "./Usuario.svc/Usuario";

  constructor(private router: Router, private http: HttpClient) {
    //this.user = firebaseAuth.authState;
    /*
    this.user.subscribe(user => {
      if (user) {
        this.userDetails = user;
        console.log(this.userDetails);
      } else {
        this.userDetails = null;
      }
    });
    */
  }

  isLoggedIn() {
    //if (this.userDetails == null) {
      return false;
    //} else {
    //  return true;
   // }
  }

  logout() {
    //this.firebaseAuth.auth.signOut().then(res => this.router.navigate(["/"]));
    this.router.navigate(["/"]);
  }

  createUserWithEmailAndPassword(usuario: Usuario) {
    let usuarioJson = JSON.stringify(usuario);   
    const headers = new HttpHeaders({'Content-Type': 'application/json'});         
    return this.http.post(this.apiUrl+'/crearusuario', usuarioJson, { headers });
  }

  getLoggedInUser(): User {
    const loggedUser: User = new User();
    /*
    const user = this.firebaseAuth.auth.currentUser;

    if (user) {
      this.userDetails = user;
      if (user != null) {
        loggedUser.$key = user.uid;
        loggedUser.userName = user.displayName;
        loggedUser.emailId = user.email;
        loggedUser.phoneNumber = user.phoneNumber;
        loggedUser.avatar = user.photoURL;
        loggedUser.isAdmin = user.email === "admin@gmail.com" ? true : false;
      }
    } else {
      this.userDetails = null;
    }
*/
    return loggedUser;
  }

  isAdmin(): boolean {
    const user = this.getLoggedInUser();
    if (user != null) {
      if (user.isAdmin === true) {
        return true;
      }
    }
  }

  signInRegular(email, password) {  
    const headers = new HttpHeaders({'Content-Type': 'application/json'});         
    return this.http.get(this.apiUrl+'/consultausuario/'+email+'/'+password, { headers });
  }
}
