import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class ItinerarioService {

  constructor(private http: HttpClient) { }

  public getItinierario(idProducto: number) {
    return this.http.get('ProductService/services/itinerario/consultar/' + idProducto);
  }

  public guardarItinerario(datos: any) {
    const headers = new HttpHeaders({'Content-Type': 'application/json'});
    return this.http.post('ProductService/services/itinerario/guardar', datos, { headers });
  }

  public editarItinerario(datos: any) {
    const headers = new HttpHeaders({'Content-Type': 'application/json'});
    return this.http.put('ProductService/services/itinerario/actualizar', datos, { headers });
  }
}
