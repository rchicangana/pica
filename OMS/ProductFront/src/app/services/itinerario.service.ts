import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class ItinerarioService {

  constructor(private http: HttpClient) { }

  public getItinierario(idProducto: number) {
    return this.http.get('ProductService/services/itinerario/consultar');
  }

}
