import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class BoleteriaService {

  constructor(private http: HttpClient) { }

  public getBoleta(idProducto: number) {
    return this.http.get('ProductService/services/boleteria/consultar/' + idProducto);
  }

  public guardarBoleteria(datos: any) {
    const headers = new HttpHeaders({'Content-Type': 'application/json'});
    return this.http.post('ProductService/services/boleteria/guardar', datos, { headers });
  }
}
