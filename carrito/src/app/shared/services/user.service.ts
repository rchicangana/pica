import { Injectable } from "@angular/core";
import { HttpClient, HttpHeaders } from '@angular/common/http';
import * as moment from "moment";
import { Usuario } from "../models/user";

@Injectable()
export class UserService {
  selectedUser: Usuario;
  users: Usuario[];
  //apiUrl :string = "http://10.39.1.99:9090/login/Logica/Usuario.svc/Usuario";
  apiUrl :string = "login/Logica/Usuario.svc/Usuario";

  location = {
    lat: null,
    lon: null
  };

  constructor(private http: HttpClient) {
    this.getUsers();

  }

  getUsers() {
    //this.users = this.db.list("clients");
    return this.users;
  }

  createUser(usuario: Usuario) {
    let usuarioJson = JSON.stringify(usuario);   
    const headers = new HttpHeaders({'Content-Type': 'application/json'});         
    return this.http.post(this.apiUrl+'/crearusuario', usuarioJson, { headers });
  }

  updateUser(usuario: Usuario) {
    let usuarioJson = JSON.stringify(usuario);   
    const headers = new HttpHeaders({'Content-Type': 'application/json'});         
    return this.http.post(this.apiUrl+'/actualizarusuario', usuarioJson, { headers });
  }

  setLocation(lat, lon) {
    this.location.lat = lat;
    this.location.lon = lon;
  }
}
