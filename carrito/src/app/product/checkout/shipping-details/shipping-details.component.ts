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
  ciudades: Ciudad[];
  public paises: Pais[];
  utilService2: UtilService;
  idPais : Number=0;

  constructor(
    private authService: AuthService,
    private utilService: UtilService
  ) {
    this.userDetail = authService.getLoggedInUser();
    this.paises = utilService.getPaises();
  }

  ngOnInit() { 
    this.utilService2 = this.utilService;
    this.userDetail.login = atob(this.userDetail.login);
  }

  updateUserDetails(form: NgForm) {
    const data = form.value;
    data["userName"] = this.userDetail.login;
    console.log("Data: ", data);
  }

  listarciudades(idPais){
    this.utilService2.getCiudades(idPais)
    .subscribe(
      data => {
        this.ciudades = <Ciudad[]> data;
      },
      error => {
      });
  }
}
