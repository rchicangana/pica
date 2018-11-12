import { Component, OnInit } from '@angular/core';
import { CustomerService } from '../../../customer.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  usuario: any = {};
  constructor(private customerService: CustomerService, private router: Router) { }

  ngOnInit() {
    this.usuario = JSON.parse(localStorage.getItem('USER'));
  }

  close() {
    this.customerService.close();
    this.router.navigateByUrl('/login');
  }

}
