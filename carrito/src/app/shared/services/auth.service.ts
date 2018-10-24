import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { Usuario, UsuarioOMS } from "../models/user";
import { Router } from "@angular/router";
import { UserService } from "./user.service";
import { HttpClient, HttpHeaders } from '@angular/common/http';

@Injectable()
export class AuthService {
  userDetails: Usuario = null;
  apiUrl :string = "login/Logica/Usuario.svc/Usuario";
  apiUrl2:string = "Autenticacion/services";
  private usuarioOMS:UsuarioOMS;
  //apiUrl :string = "http://10.39.1.99/login/Logica/Usuario.svc/Usuario";

  constructor(
    private router: Router, 
    private http: HttpClient,
    private userService:UserService) {
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
    
    this.usuarioOMS.nombre = usuario.nombres+' '+usuario.apellidos;
    this.usuarioOMS.login = usuario.login;
    this.usuarioOMS.email = usuario.login;
    this.usuarioOMS.idEstadoUser.estado="Activo";
    this.usuarioOMS.idEstadoUser.idEstadoUser=1;
    this.userService.createUser(this.usuarioOMS);

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

  autenticarOMS(login, password) {  
    let credenciales = "{\"login\":\""+login+"\",\"password\":\""+password+"\"}";
    const headers = new HttpHeaders({'Content-Type': 'application/json'});         
    return this.http.post(this.apiUrl2+'/autenticacion/',+credenciales, { headers });
  }
}
