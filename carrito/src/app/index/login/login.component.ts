import { NgForm, EmailValidator } from "@angular/forms";
import { Component, OnInit } from "@angular/core";
import { ToastyService, ToastOptions, ToastyConfig } from "ng2-toasty";
import { Router, ActivatedRoute } from "@angular/router";
import { AuthService } from "../../shared/services/auth.service";
import { Usuario,UsuarioOMS } from "../../shared/models/user";
import { UserService } from "../../shared/services/user.service";

declare var $: any;
@Component({
  selector: "app-login",
  templateUrl: "./login.component.html",
  styleUrls: ["./login.component.scss"],
  providers: [EmailValidator]
})
export class LoginComponent implements OnInit {
  user = {
    emailId: "",
    loginPassword: ""
  };

  errorInUserCreate = false;
  errorMessage: any;
  createUser;
  private usuarioOMS:UsuarioOMS;

  constructor(
    private authService: AuthService,
    private toastyService: ToastyService,
    private router: Router,
    private route: ActivatedRoute,
    private userService:UserService,
    private toastyConfig: ToastyConfig
  ) {
    this.toastyConfig.position = "top-right";
    this.toastyConfig.theme = "material";

    this.createUser = new Usuario("","","","");
  }

  ngOnInit() {}

  addUser(userForm: NgForm) {
    userForm.value["isAdmin"] = false;
    var usuario = new Usuario(userForm.value["emailId"], userForm.value["password"], userForm.value["nombres"],userForm.value["apellidos"] );
    this.authService
      .createUserWithEmailAndPassword(usuario)
      .subscribe(res => {
        console.log("Usuario creado", res);
        const toastOption: ToastOptions = {
          title: "Registro de Usuario",
          msg: "Registrando",
          showClose: true,
          timeout: 3000,
          theme: "material"
        };
        this.toastyService.wait(toastOption);
        setTimeout((router: Router) => {
          $("#createUserForm").modal("hide");
          this.router.navigate(["/"]);
        }, 1500);
      });
    this.usuarioOMS = new UsuarioOMS(usuario.nombres+' '+usuario.apellidos,usuario.login,usuario.login );
    this.userService.createUser(this.usuarioOMS);
  }

  signInWithEmail(userForm: NgForm) {
    this.authService
      .signInRegular(userForm.value["emailId"], userForm.value["loginPassword"])
      .subscribe(res => {
        console.log("Usuario logeado: ", res);
        this.user.emailId = (<Usuario>res).login;
        this.user.loginPassword = (<Usuario>res).password;
        localStorage.setItem("usuarioLogeado", JSON.stringify(res));

        const toastOption: ToastOptions = {
          title: "Authenticacion exitosa",
          msg: "Autenticando, por favor espere",
          showClose: true,
          timeout: 5000,
          theme: "material"
        };
        this.toastyService.wait(toastOption);
        const returnUrl = this.route.snapshot.queryParamMap.get("returnUrl");

        setTimeout((router: Router) => {
          this.router.navigate([returnUrl || "/"]);
        }, 1500);

        this.router.navigate(["/"]);
      },
      error => {
      });
  }
}
