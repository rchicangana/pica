import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { Usuario } from "../models/user";
import { Router } from "@angular/router";
import { HttpClient, HttpHeaders } from '@angular/common/http';

@Injectable()
export class AuthService {
  userDetails: Usuario = null;
  apiUrl:string = "htpp://10.39.1.99:9090/login/Logica/Usuario.svc/Usuario";

  constructor(
    private router: Router, 
    private http: HttpClient) {
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
    return this.http.get(this.apiUrl+'/consulta/'+btoa(email)+'/'+btoa(password), { headers });
  }
}
