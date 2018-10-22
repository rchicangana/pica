import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class ProductosService {

  constructor(private http: HttpClient) { }

  public getProductos() {
    return this.http.get('ProductService/services/producto/buscar/0/5');
  }
}
