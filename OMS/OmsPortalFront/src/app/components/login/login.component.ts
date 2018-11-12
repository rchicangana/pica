import { Component, OnInit } from '@angular/core';
import { LoginService } from 'src/app/services/login.service';
import { CustomerService } from '../../../customer.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  datosFormulario = {'login': '', 'password': ''};

  constructor(private api: LoginService, private customer: CustomerService, private router: Router) { }

  ngOnInit() {
  }

  tryLogin() {
    this.api.login(this.datosFormulario).subscribe(
      (response: any) => {
        if ( response.codigo === 'OK' ) {
          this.customer.setToken(response.object.tokenJwt);
          this.customer.setUser(JSON.stringify(response.object));
          this.router.navigateByUrl('/home');
        } else {
          alert('Credenciales Invalidas');
        }
      }
    );
  }

}
