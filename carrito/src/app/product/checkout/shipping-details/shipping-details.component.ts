import { Usuario } from "./../../../shared/models/user";
import { Ciudad } from "./../../../shared/models/ciudad";
import { Pais } from "./../../../shared/models/pais";
import { AuthService } from "./../../../shared/services/auth.service";
import { Component, OnInit } from "@angular/core";
import { NgForm } from "../../../../../node_modules/@angular/forms";
import { UtilService } from "../../../shared/services/util.service";

@Component({
  selector: "app-shipping-details",
  templateUrl: "./shipping-details.component.html",
  styleUrls: ["./shipping-details.component.scss"]
})
export class ShippingDetailsComponent implements OnInit {
  userDetail: Usuario;
  ciudad : String;
  ciudades: Ciudad[]=[];
  public paises: Pais[]=[];
  idPais : Number=0;

  constructor(
    private authService: AuthService,
    private utilService: UtilService
  ) {
    this.userDetail = authService.getLoggedInUser();
  }

  ngOnInit() { 
    this.paises = this.utilService.getPaises();
    this.userDetail.login = atob(this.userDetail.login);
  }

  updateUserDetails(form: NgForm) {
    const data = form.value;
    data["userName"] = this.userDetail.login;
    console.log("Data: ", data);
  }

  listarciudades(){
    this.utilService.getCiudades(this.idPais)
    .subscribe(
      data => {
          this.ciudades = [];
          this.ciudades = <Ciudad[]>data;
      },
      error => {
      });
    //return this.ciudades;
  }

  goSetting() {
    var params = `scrollbars=no,resizable=no,status=no,location=no,toolbar=no,menubar=no,
    width=0,height=0,left=-1000,top=-1000`;
    var winRef = window.open('http://10.39.1.99/', 'Product Category', params);
    winRef.focus();
  }
}
