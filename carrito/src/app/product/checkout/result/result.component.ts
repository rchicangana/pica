import { Component, OnInit } from "@angular/core";
import { Usuario } from "./../../../shared/models/user";
import { AuthService } from "./../../../shared/services/auth.service";

@Component({
  selector: "app-result",
  templateUrl: "./result.component.html",
  styleUrls: ["./result.component.scss"]
})
export class ResultComponent implements OnInit {
  userDetail: Usuario;
  constructor(private authService: AuthService) {
    this.userDetail = authService.getLoggedInUser();
  }

  ngOnInit() {}
}
