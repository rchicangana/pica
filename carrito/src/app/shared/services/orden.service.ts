import { Injectable } from "@angular/core";
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Solicitud } from "../models/solicitud";
import { Respuesta } from "../models/respuesta";
import { AuthService } from "../services/auth.service";
import { EnviarOrden, Orden } from "../models/Orden";
import { Usuario } from "../models/user";
import { Tarifa } from "../../shared/models/tarifa";
import { ProductService } from "../../shared/services/product.service";

@Injectable()
export class OrdenService {
  enviarOrden: EnviarOrden;
  ordenes: Orden[];
  orden:Orden;
  respuesta : Respuesta; 
  apiUrl :string = "ServiciosESB/Ordenes";
  userDetail: Usuario;
  cartProducts: Tarifa[];
  resultado: String;

  constructor(
      private http: HttpClient,
      private authService: AuthService,
      private productService: ProductService) {
      this.userDetail = authService.getLoggedInUser();
  }

 cancelarOrden(idOrden: number){
    const headers = new HttpHeaders({'Content-Type': 'application/json'});         
    const x = this.http.get(this.apiUrl+'/ActualizarEstado/'+idOrden+'/3', { headers })
    .subscribe(
        data => {
            this.resultado = <String>data;
        },
        error => {
        });
    return this.resultado;
 }

 consultarOrdenesPorCliente(idCliente: number){
    const headers = new HttpHeaders({'Content-Type': 'application/json'});         
    const x = this.http.get(this.apiUrl+'/obtenerOrdenesPorCliente/'+idCliente+'/1/5', { headers })
    .subscribe(
        data => {
            this.ordenes = <Orden[]>data;
        },
        error => {
        });
    return this.ordenes;
 }

 consultarIdOrdenPorSolicitud(idSolicitud: Number){
    const headers = new HttpHeaders({'Content-Type': 'application/json'});         
    const x = this.http.get(this.apiUrl+'/obtenerOrden/idPedido/'+idSolicitud, { headers })
    .subscribe(
        data => {
            this.orden = <Orden>data;
        },
        error => {
        });
    return this.orden;
 }

  crearOrden(nroSolicitud: Number){ 
    let solicitud: Solicitud;
    this.cartProducts = this.productService.getLocalCartProducts();

    this.enviarOrden.estadoOrdenCompra = {idEstadoOrdenCompra:0,estado:"ABIERTA"};
    this.enviarOrden.fechaCreacion = new Date();
    this.enviarOrden.fechaVencimiento = new Date();
    this.enviarOrden.idCliente = this.userDetail.idcliente;
    this.enviarOrden.numeroSolicitud = nroSolicitud;
     
    this.cartProducts.forEach((nos) => { 
        this.enviarOrden.valorTotal = nos.total;
        let prod = {
            producto: {
                idProducto: nos.boleteriaDTO.id,
                imagenProductos: {}[0]
            },
            valor: nos.boleteriaDTO.valor
        };
        this.enviarOrden.detalleOrdenCompras.push(prod);  
    })  

    const headers = new HttpHeaders({'Content-Type': 'application/json'});         
    const x = this.http.post(this.apiUrl+'/Crear/', this.enviarOrden, { headers })
    .subscribe(
        data => {
            this.resultado = <String>data;
        },
        error => {
        });
    return this.resultado;
  }
}