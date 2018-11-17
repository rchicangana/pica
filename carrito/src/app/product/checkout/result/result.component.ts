import { Component, OnInit } from "@angular/core";
import { Usuario } from "./../../../shared/models/user";
import { Router } from "@angular/router";
import { AuthService } from "./../../../shared/services/auth.service";

@Component({
  selector: "app-result",
  templateUrl: "./result.component.html",
  styleUrls: ["./result.component.scss"]
})
export class ResultComponent implements OnInit {
  userDetail: Usuario;
  constructor(
    private authService: AuthService,
    private router: Router) {
    this.userDetail = authService.getLoggedInUser();
  }

  ngOnInit() {
    window.open("http://10.39.1.99:9090/credit-card.html");
  }
}
