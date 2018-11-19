import { Component, OnInit } from "@angular/core";
import { Usuario } from "../../../shared/models/user";
import { Respuesta3,Respuesta } from "../../../shared/models/respuesta";
import { Cliente, ClienteResponse } from "../../../shared/models/cliente";
import { Router, ActivatedRoute } from "@angular/router";
import { AuthService } from "../../../shared/services/auth.service";
import { UserService } from "../../../shared/services/user.service";
import { OrdenService } from "../../../shared/services/orden.service";
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { ToastyService, ToastOptions, ToastyConfig } from "ng2-toasty";
import { SolicitudService } from "../../../shared/services/solicitud.service";
import { Orden } from "../../../shared/models/Orden";
import { Tarifa } from "../../../shared/models/tarifa";
import { ProductService } from "../../../shared/services/product.service";

@Component({
  selector: "app-result",
  templateUrl: "./result.component.html",
  styleUrls: ["./result.component.scss"]
})
export class ResultComponent implements OnInit {
  userDetail: Usuario;
  apiUrl :string = "ServiciosESB/Clientes";
  apiUrl2 :string = "ServiciosESB/CLientes";
  mensaje: String;
  cartProducts : Tarifa[];
  
  private parametersObservable: any;

  constructor( 
    private authService: AuthService,
    private router: Router,
    private ordenService:OrdenService,
    private route: ActivatedRoute,
    private toastyService: ToastyService,
    private userService: UserService,
    private solicitudService:SolicitudService,
    private productService:ProductService,
    private http: HttpClient) {
    this.userDetail = authService.getLoggedInUser();
  }

  ngOnInit() {
    this.parametersObservable = this.route.params.subscribe(params => {
      //"product" is obtained from 'ProductResolver'
      let parametro = this.route.snapshot.data['pagado'];
    });
    let cliente = new Cliente(
      this.userDetail.tipodoc,
      this.userDetail.identificacion,
      this.userDetail.nombres,
      this.userDetail.apellidos,
      "","","ACTIVO",2 
    );
    let clienteJson = JSON.stringify(cliente);   
    const headers = new HttpHeaders({'Content-Type': 'application/json'}); 

    console.log("Se intentara crear un cliente...");
    this.http.post(this.apiUrl+'/Crear', clienteJson, { headers })
    .subscribe(data => {
          if((<Respuesta3>data).estado.toUpperCase() == "OK"){
            console.log("Cliente creado con exito");
            this.http.get(this.apiUrl2+'/Consultar/'+this.userDetail.tipodoc+'/'+this.userDetail.identificacion, { headers })
            .subscribe(data => {
              this.userDetail.idcliente = (<ClienteResponse>data).idCliente;
              console.log("El cliente creado tiene id: "+this.userDetail.idcliente);
              this.userService.updateUser(this.userDetail);
            });
          }
          else{
            console.log((<Respuesta3>data).estado.toUpperCase());
            console.log("Error: "+(<Respuesta3>data).descripcion);
            this.http.get(this.apiUrl2+'/Consultar/'+this.userDetail.tipodoc+'/'+this.userDetail.identificacion, { headers })
            .subscribe(data => {
              this.userDetail.idcliente = (<ClienteResponse>data).idCliente;
              console.log("El cliente creado tiene id: "+this.userDetail.idcliente);

              this.userService.updateUser(this.userDetail)
              .subscribe(res => {
                if((<Respuesta>res).resultado == "OK"){
                  console.log("Usuario actualizado", res);
                  const toastOption: ToastOptions = {
                    title: "Actuallizar Usuario",
                    msg: "Actualizando",
                    showClose: true,
                    timeout: 3000,
                    theme: "material"
                  };
                  this.toastyService.wait(toastOption);
                }
                else{
                  console.log("Error al actualizar usuario");
                }
              })
            });            
          }
      });
      let param1 = this.route.snapshot.queryParams["pagado"]; 
      if(param1 == 0){
        this.mensaje = "Redirigiendo a pagina de pago...";
        this.cartProducts = this.productService.getLocalCartProducts();
        this.goPayment(this.cartProducts[0].nombre, this.cartProducts[0].total);
      }
      else if(param1 == 1){
        this.mensaje = "Pago realizado con exito!";
        let idSolicitud : Number = 12346;
        let resultado: String = "";
        let ordenResultado:Number;
        let idUsuario = this.userDetail.id;
        //creamos la orden
        this.ordenService.crearOrden(idSolicitud).subscribe(
          (data:any) => {
              resultado = data;
              if(resultado == "OrdenCompra creada exitosamente : true"){
                //obtenemos el id con el que se creo la orden
                this.ordenService.consultarIdOrdenPorSolicitud(idSolicitud)
                .subscribe(
                  data => {
                    ordenResultado = (<Orden>data).noOrden;
                    //actualizamos el numero de orden en la tabla de solicitud
                    this.solicitudService.updateProductoUsuario(idUsuario,ordenResultado)
                    .subscribe(
                      data => {
                          console.log(<String>data);
                      },
                      error => {
                      });
                  },
                  error => {
                    console.log(error);
                });
              }
          },
          error => {
            console.log(error);
          });
      }
  }

  goPayment(producto:String, total:Number) {
    window.location.href = 'http://10.39.1.99:9090/credit-card.html?producto='+producto+'&total='+total.toString();
  }
}
