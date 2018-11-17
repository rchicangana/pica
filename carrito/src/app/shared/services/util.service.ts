import { Injectable } from "@angular/core";
import { HttpClient, HttpHeaders } from '@angular/common/http';
import * as moment from "moment";
import { Pais } from "../models/pais";
import { Ciudad } from "../models/ciudad";

@Injectable()
export class UtilService {
  paises: Pais[];
  ciudades: Ciudad[];
  //apiUrl :string = "http://10.39.1.144:8081/ServiciosESB/Util";
  apiUrl :string = "ServiciosESB/Util";

  constructor(private http: HttpClient) {
  }

  getPaises(): Pais[]{ 
    const headers = new HttpHeaders({'Content-Type': 'application/json'});         
    const x = this.http.get(this.apiUrl+'/Paises', { headers })
    .subscribe(
        data => {
            this.paises = [];
            this.paises = <Pais[]>data;
              //productos.forEach(elemento => {
             //   this.paises.push(elemento);
           // });
        },
        error => {
        });

    return this.paises;
  }

  getCiudades(idPais: Number) { 
    const headers = new HttpHeaders({'Content-Type': 'application/json'});         
    return this.http.get(this.apiUrl+'/Ciudades/'+idPais, { headers });
  }
}