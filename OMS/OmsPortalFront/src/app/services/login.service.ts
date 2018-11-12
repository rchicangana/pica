import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class LoginService {
  constructor(private http: HttpClient) {}

  public login(datos: any) {
    const headers = new HttpHeaders({ 'Content-Type': 'application/json' });
    return this.http.post('http://10.39.1.140:8080/Autenticacion/services/autenticacion', datos, { headers });
  }
}
