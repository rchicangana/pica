import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';


@Injectable({
  providedIn: 'root'
})
export class ImagenesService {

  constructor( private http: HttpClient ) { }

  public getImagenes(idProducto: number) {
    return this.http.get('ProductService/services/imagenProducto/consultar/' + idProducto);
  }

  public guardarImagenProducto(datos: any) {
    const headers = new HttpHeaders({'Content-Type': 'application/json'});
    return this.http.post('ProductService/services/imagenProducto/guardar', datos, { headers });
  }

  public borrarImagenProducto(idImagen: number) {
    const headers = new HttpHeaders({'Content-Type': 'application/json'});
    return this.http.delete('ProductService/services/imagenProducto/eliminar/' + idImagen, { headers });
  }

}
