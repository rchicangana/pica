import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class TipoproductoService {

  constructor(private http: HttpClient) { }

  public getTiposProducto() {
    return this.http.get('ProductService/services/tipoProducto/consultar');
  }


}
