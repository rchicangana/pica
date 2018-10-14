import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { Usuario } from "../models/user";
import { Router } from "@angular/router";
import { HttpClient, HttpHeaders } from '@angular/common/http';

@Injectable()
export class AuthService {
  //user: Observable<firebase.User>;
  userDetails: Usuario = null;
  apiUrl :string = "login/Logica/Usuario.svc/Usuario";

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
    let usuario = localStorage.getItem("usuarioLogeado");
    if (usuario == null) {
      return false;
    } else {
      return true;
    }
  }

  logout() {
    localStorage.removeItem("usuarioLogeado");
    this.router.navigate(["/"]);
  }

  createUserWithEmailAndPassword(usuario: Usuario) {
    let usuarioJson = JSON.stringify(usuario);   
    const headers = new HttpHeaders({'Content-Type': 'application/json'});         
    return this.http.post(this.apiUrl+'/crearusuario', usuarioJson, { headers });
  }

  getLoggedInUser(): Usuario {
    let loggedUser: Usuario;
    
    let user = JSON.parse(localStorage.getItem("usuarioLogeado"));

    if (user) {
      this.userDetails = <Usuario> user;
      if (user != null) {
        loggedUser = this.userDetails;
      }
    } 
    else {
      this.userDetails = null;
    }

    return loggedUser;
  }

  isAdmin(): boolean {
    const user = this.getLoggedInUser();
    if (user != null) {
      if (user.login === "johnefe84@gmail.com") {
        return true;
      }
    }
  }

  signInRegular(email, password) {  
    const headers = new HttpHeaders({'Content-Type': 'application/json'});         
    return this.http.get(this.apiUrl+'/consultausuario/'+email+'/'+password, { headers });
  }
}
