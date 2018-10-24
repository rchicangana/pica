import { NgForm, EmailValidator } from "@angular/forms";
import { Component, OnInit } from "@angular/core";
import { ToastyService, ToastOptions, ToastyConfig } from "ng2-toasty";
import { Router, ActivatedRoute } from "@angular/router";
import { UserService } from "../../shared/services/user.service";
import { AuthService } from "../../shared/services/auth.service";
import { Usuario } from "../../shared/models/user";
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

  constructor(
    private authService: AuthService,
    private toastyService: ToastyService,
    private router: Router,
    private route: ActivatedRoute,
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
        console.log("created User", res);
        const toastOption: ToastOptions = {
          title: "User Registeration",
          msg: "Registering",
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
