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
  paises: Pais[];

  constructor(
    private authService: AuthService,
    private utilService: UtilService
  ) {
    this.userDetail = authService.getLoggedInUser();
    this.paises = utilService.getPaises();
  }

  ngOnInit() {}

  updateUserDetails(form: NgForm) {
    const data = form.value;

    //data["emailId"] = this.userDetails.emailId;
    data["userName"] = this.userDetail.login;

    console.log("Data: ", data);
  }
}
