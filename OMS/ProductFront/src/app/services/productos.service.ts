import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class ProductosService {

  constructor(private http: HttpClient) { }

  public getProductos(paginas: number, comodin: string) {
    if (comodin == null || comodin === '') {
      comodin = '*';
    }
    return this.http.get('ProductService/services/producto/buscarDescripcion/' + (paginas) + '/5/' + comodin);
  }

  public guardarProducto(datos: any) {
    const headers = new HttpHeaders({'Content-Type': 'application/json'});
    return this.http.post('ProductService/services/producto/guardar', datos, { headers });
  }

  public editarProducto(datos: any) {
    const headers = new HttpHeaders({'Content-Type': 'application/json'});
    return this.http.put('ProductService/services/producto/editar', datos, { headers });
  }
}
