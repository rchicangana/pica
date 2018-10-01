import { Injectable } from "@angular/core";

import * as moment from "moment";
import { Usuario } from "../models/user";

@Injectable()
export class UserService {
  selectedUser: Usuario;
  users: Usuario[];

  location = {
    lat: null,
    lon: null
  };

  constructor() {
    this.getUsers();
  }

  getUsers() {
    //this.users = this.db.list("clients");
    return this.users;
  }

  createUser(data: Usuario) {
    /*data.location = this.location;
    data.createdOn = moment(new Date()).format("X");
    this.users.push(data);*/
  }

  updateUser(user: Usuario) {
    //this.users.update(user.$key, user);
  }

  setLocation(lat, lon) {
    this.location.lat = lat;
    this.location.lon = lon;
  }
}
