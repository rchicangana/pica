import { Component, OnInit } from "@angular/core";
import { NgForm, FormBuilder, FormGroup, Validators } from "@angular/forms";
import { Usuario } from "../../shared/models/user";
import { Solicitud } from "../../shared/models/solicitud";
import { AuthService } from "../../shared/services/auth.service";
import { SolicitudService } from "../../shared/services/solicitud.service";

@Component({
  selector: "app-user-account",
  templateUrl: "./user-account.component.html",
  styleUrls: ["./user-account.component.scss"]
})
export class UserAccountComponent implements OnInit {
  loggedUser: Usuario;
  solicitudes: Solicitud[];
  // Enable Update Button

  constructor(
    private authService: AuthService,
    private solicitudService: SolicitudService
    ) {}

  ngOnInit() {
    //this.loggedUser = this.authService.getLoggedInUser();
    //this.solicitudes = this.solicitudService.buscarSolicitud(this.loggedUser.id);
  }
}
