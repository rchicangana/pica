import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class CiudadService {

  constructor(private http: HttpClient) { }

  public getCiudades(idPais: number) {
    return this.http.get('ProductService/services/ciudad/consultar/' + idPais);
  }
}
