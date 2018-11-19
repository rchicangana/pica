import { Injectable } from "@angular/core";
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Solicitud } from "../models/solicitud";
import { Respuesta } from "../models/respuesta";
import { AuthService } from "../services/auth.service";
import { EnviarOrden, Orden, DetalleOrdenCompras } from "../models/Orden";
import { Usuario } from "../models/user";
import { Tarifa } from "../../shared/models/tarifa";
import { ProductService } from "../../shared/services/product.service";
import { DatePipe } from "../../../../node_modules/@angular/common";

@Injectable()
export class OrdenService {
  enviarOrden: EnviarOrden;
  ordenes: Orden[];
  resultadoN:Number;
  respuesta : Respuesta; 
  apiUrl :string = "ServiciosESB/Ordenes";
  userDetail: Usuario;
  cartProducts: Tarifa[];
  resultado: String;
  numero:Number;

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
    return this.http.get(this.apiUrl+'/obtenerOrden/idPedido/'+idSolicitud, { headers });
 }

  crearOrden(nroSolicitud: Number){ 
    let solicitud: Solicitud;
    let detalle:DetalleOrdenCompras[];

    this.cartProducts = this.productService.getLocalCartProducts();
    this.enviarOrden = new EnviarOrden(null, null, null,null,null,null,null);
    this.enviarOrden.estadoOrdenCompra = {idEstadoOrdenCompra:0,estado:"ABIERTA"};
    let fecha = new Date();

    let fechaString = fecha.getFullYear().toString()+'-'+(fecha.getMonth()+1).toString()+'-'+fecha.getDate().toString();
    
    this.enviarOrden.fechaCreacion = fechaString;
    this.enviarOrden.fechaVencimiento = fechaString;
    this.enviarOrden.idCliente = this.userDetail.idcliente;
    this.enviarOrden.numeroSolicitud = nroSolicitud;

    let contador:number=0;

    this.cartProducts.forEach((nos) => { 
        this.enviarOrden.valorTotal = nos.total;
        this.numero = nos.boleteriaDTO.id;
  
        this.enviarOrden.detalleOrdenCompras = 
        [
            {
                producto: {
                    idProducto: this.numero,
                    imagenProductos: [{}]
                },
                valor: nos.boleteriaDTO.valor
            }
        ];
        contador = contador+1;
    });  
      
    return this.http.post(this.apiUrl+'/Crear', this.enviarOrden,{responseType: 'text'});
  }
}