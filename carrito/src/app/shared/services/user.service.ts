import { Injectable } from "@angular/core";
import { HttpClient, HttpHeaders } from '@angular/common/http';
import * as moment from "moment";
import { Usuario, UsuarioOMS } from "../models/user";

@Injectable()
export class UserService {
  selectedUser: Usuario;
  users: Usuario[];
  apiUrl :string = "ServiciosESB/Autenticacion/services/usuario";

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

  createUser(usuario: UsuarioOMS) {
    let usuarioJson = JSON.stringify(usuario);   
    const headers = new HttpHeaders({'Content-Type': 'application/json'});         
    return this.http.post(this.apiUrl+'/registrar', usuarioJson, { headers });
  }

  updateUser(usuario: UsuarioOMS) {
    let usuarioJson = JSON.stringify(usuario);   
    const headers = new HttpHeaders({'Content-Type': 'application/json'});         
    return this.http.put(this.apiUrl+'/actualizar', usuarioJson, { headers });
  }

  setLocation(lat, lon) {
    this.location.lat = lat;
    this.location.lon = lon;
  }
}
