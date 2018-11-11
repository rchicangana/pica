import { Component, OnInit } from '@angular/core';
import { ProductosService } from 'src/app/services/productos.service';

@Component({
  selector: 'app-consulta',
  templateUrl: './consulta.component.html',
  styles: []
})
export class ConsultaComponent implements OnInit {

  elementos: any = [];
  page: any;
  itemsPerPage = 5;
  totalItems: any;


  constructor(private productoService: ProductosService) { }

  ngOnInit() {
  }

  loadPage() {
    
  }

}
