import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class EmpresaService {

  constructor(private http: HttpClient) { }

  public getEmpresas() {
    return this.http.get('ProductService/services/empresa/consultar');
  }

}
