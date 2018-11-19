import { Injectable } from "@angular/core";
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Solicitud } from "../models/solicitud";
import { Respuesta } from "../models/respuesta";
import { AuthService } from "../services/auth.service";
import { Usuario } from "../models/user";
import { Tarifa } from "../../shared/models/tarifa";
import { ProductService } from "../../shared/services/product.service";
import { ProductosCliente } from "../models/solicitud";

@Injectable()
export class SolicitudService {
  solicitud: Solicitud;
  solicitudes: Solicitud[];
  respuesta : Respuesta; 
  productosCliente : ProductosCliente[];
  resultado: String;;
  //apiUrl :string = "http://10.39.1.99:9090/solicitud/Logica/Solicitud.svc/Solicitud";
  apiUrl :string = "solicitud/Logica/Solicitud.svc/Solicitud";
  userDetail: Usuario;
  cartProducts: Tarifa[];

  constructor(
      private http: HttpClient,
      private authService: AuthService,
      private productService: ProductService) {
      this.userDetail = authService.getLoggedInUser();
  }

 buscarSolicitud(idUsuario: number){
    const headers = new HttpHeaders({'Content-Type': 'application/json'});         
    const x = this.http.get(this.apiUrl+'/buscarUsuario/'+idUsuario, { headers })
    .subscribe(
        data => {
            this.solicitudes = <Solicitud[]>(<Respuesta>data).objeto;
        },
        error => {
        });
    return this.solicitudes;
 } 

 solicitudPorUsuario(idUsuario: number){
    const headers = new HttpHeaders({'Content-Type': 'application/json'});         
    const x = this.http.get(this.apiUrl+'/productousuarioget/'+idUsuario, { headers })
    .subscribe(
        data => {
            this.productosCliente = <ProductosCliente[]>(<Respuesta>data).objeto;
        },
        error => {
        });
    return this.productosCliente;
 }

 insertProductoUsuario(idProducto: Number, idUsuario: number){
    const headers = new HttpHeaders({'Content-Type': 'application/json'});         
    const x = this.http.post(this.apiUrl+'/ productousuario/'+idProducto+'/'+idUsuario, { headers })
    .subscribe(
        data => {
            this.resultado = <String>data;
        },
        error => {
        });
    return this.resultado;
 }

 updateProductoUsuario(idUsuario: Number, idOrden: Number){
    if(idUsuario != undefined && idOrden != undefined){ 
        const headers = new HttpHeaders({'Content-Type': 'application/json'});         
        const x = this.http.post(this.apiUrl+'/productousuarioupdate/'+idUsuario+'/'+idOrden, { headers })
        .subscribe(
        data => {
            this.resultado = <String>data;
        },
        error => {
        });
    }else{
        return "usuario y/o orden vacios";   
    }
    return this.resultado;
 }

  crearSolicitud(): Respuesta{ 
    let solicitud: Solicitud;
    this.cartProducts = this.productService.getLocalCartProducts();

    //for(let i :number = 10; i < this.cartProducts.length; i++){
    //    solicitud.nombreProducto  = this.cartProducts[i].nombre;
    //    solicitud.itinerarioList = this.cartProducts[i].itinerarioDTOlist;
    //}


    const headers = new HttpHeaders({'Content-Type': 'application/json'});         
    const x = this.http.post(this.apiUrl+'/crear/', solicitud, { headers })
    .subscribe(
        data => {
            this.respuesta = <Respuesta>data;
        },
        error => {
        });
    return this.respuesta;
  }
}