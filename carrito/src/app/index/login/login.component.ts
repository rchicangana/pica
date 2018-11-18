import { NgForm, EmailValidator } from "@angular/forms";
import { Component, OnInit } from "@angular/core";
import { ToastyService, ToastOptions, ToastyConfig } from "ng2-toasty";
import { Router, ActivatedRoute } from "@angular/router";
import { AuthService } from "../../shared/services/auth.service";
import { Usuario } from "../../shared/models/user";
import { UserService } from "../../shared/services/user.service";
import { Respuesta } from '../../shared/models/respuesta';

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
  errorInLoginUser = false;
  errorMessage: any;
  createUser;
  usuario: Usuario;

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
<<<<<<< HEAD
    this.createUser = new Usuario("","","","","","",0);
  }

  ngOnInit() {
    this.usuario = new Usuario("","","","","","",0);
=======
    this.createUser = new Usuario("","","","","","");
  }

  ngOnInit() {
    this.usuario = new Usuario("","","","","","");
>>>>>>> c850cb9c67b078b76792d3effd6430a8a71a5fe4
  }

  addUser(userForm: NgForm) {
    userForm.value["isAdmin"] = false;
    var usuario = new Usuario(
      btoa(userForm.value["emailId"]), 
      btoa(userForm.value["password"]), 
      userForm.value["nombres"],
      userForm.value["apellidos"],
      userForm.value["tipodoc"],
      userForm.value["identificacion"],
<<<<<<< HEAD
      0
=======
>>>>>>> c850cb9c67b078b76792d3effd6430a8a71a5fe4
     );
    this.userService
      .createUser(usuario)
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
  }

  signInWithEmail(userForm: NgForm) {
    this.authService
      .signInRegular(userForm.value["emailId"], userForm.value["loginPassword"])
      .subscribe(res => {
        if ((<Respuesta>res).resultado == "Fallo"){
          console.log("Usuario NO logeado: ", (<Respuesta>res).mensaje);
          this.errorInLoginUser = true;
          this.errorMessage = "Credenciales incorectas";
        }
        else{
          let respuesta: Respuesta = <Respuesta>res;
          this.usuario = <Usuario>respuesta.objeto[0];
          console.log("Usuario logeado: ", this.usuario.nombres);

          if(this.usuario.login !== undefined){
            this.user.emailId = this.usuario.login;
            this.user.loginPassword = this.usuario.password;
            localStorage.setItem("usuarioLogeado", JSON.stringify(this.usuario));
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
            this.errorInLoginUser = false;
            this.router.navigate(["/"]);
          }
          else{
            this.errorInLoginUser = true;
            this.errorMessage = "Credenciales incorrectas";
          }
        }
      },
      error => {
        this.errorInLoginUser = true;
        this.errorMessage = "Credenciales incorrectas";
      });
  }
}
