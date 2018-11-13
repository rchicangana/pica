import { Component, OnInit } from "@angular/core";
import { Usuario } from "./../../../shared/models/user";
import { Respuesta3,Respuesta } from "./../../../shared/models/respuesta";
import { Cliente, ClienteResponse } from "./../../../shared/models/cliente";
import { Router } from "@angular/router";
import { AuthService } from "./../../../shared/services/auth.service";
import { UserService } from "./../../../shared/services/user.service";
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { ToastyService, ToastOptions, ToastyConfig } from "ng2-toasty";

@Component({
  selector: "app-result",
  templateUrl: "./result.component.html",
  styleUrls: ["./result.component.scss"]
})
export class ResultComponent implements OnInit {
  userDetail: Usuario;
  apiUrl :string = "ServiciosESB/Clientes";
  apiUrl2 :string = "ServiciosESB/CLientes";

  constructor(
    private authService: AuthService,
    private router: Router,
    private toastyService: ToastyService,
    private userService: UserService,
    private http: HttpClient) {
    this.userDetail = authService.getLoggedInUser();
  }

  ngOnInit() {
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
                  //setTimeout((router: Router) => {
                  //  $("#createUserForm").modal("hide");
                  //}, 1500);
                }
                else{
                  console.log("Error al actualizar usuario");
                }
              })
            
              /*this.http.post(this.apiUrl+'/Actualizar', clienteJson, { headers })
              .subscribe(data => {
                      if((<Respuesta3>data).estado.toUpperCase() == "OK"){
                        console.log("Cliente actualizado con exito");               
                      }
                });*/
            });            
          }
      }); 
      this.goPayment();
  }

  goPayment() {
    var params = `scrollbars=no,resizable=no,status=no,location=no,toolbar=no,menubar=no,
    width=0,height=0,left=-1000,top=-1000`;
    var winRef = window.open('http://10.39.1.99:9090/credit-card.html', 'Product Category', params);
    winRef.focus();
  }
}
