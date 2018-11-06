import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class HospedajeService {

  constructor(private http: HttpClient) { }

  public getHospedajes() {
    return this.http.get('ProductService/services/hospedaje/consultar');
  }

}
