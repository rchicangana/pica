import { Usuario } from "./../../../shared/models/user";
import { AuthService } from "./../../../shared/services/auth.service";
import { Component, OnInit } from "@angular/core";
import { NgForm } from "../../../../../node_modules/@angular/forms";

@Component({
  selector: "app-shipping-details",
  templateUrl: "./shipping-details.component.html",
  styleUrls: ["./shipping-details.component.scss"]
})
export class ShippingDetailsComponent implements OnInit {
  userDetail: Usuario;

  constructor(private authService: AuthService) {
    this.userDetail = authService.getLoggedInUser();
  }

  ngOnInit() {}

  updateUserDetails(form: NgForm) {
    const data = form.value;

    //data["emailId"] = this.userDetails.emailId;
    data["userName"] = this.userDetail.login;

    console.log("Data: ", data);
  }
}
