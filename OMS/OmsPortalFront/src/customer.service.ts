import {Injectable} from '@angular/core';

const TOKEN = 'TOKEN';
const USER = 'USER';

@Injectable({
  providedIn: 'root'
})
export class CustomerService {

  setToken(token: string): void {
    localStorage.setItem(TOKEN, token);
  }

  setUser(user: any): void {
    localStorage.setItem(USER, user);
  }

  close() {
    localStorage.clear();
  }


  isLogged() {
    return localStorage.getItem(TOKEN) != null;
  }
}
