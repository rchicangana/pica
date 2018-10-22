import { Component, OnInit } from '@angular/core';
import { ProductosService } from '../../services/productos.service';

@Component({
  selector: 'app-producto',
  templateUrl: './producto.component.html',
  styleUrls: []
})
export class ProductoComponent implements OnInit {

  constructor(private productosService: ProductosService) { }
  elementos: any[] = [];

  ngOnInit() {
    this.productosService
      .getProductos()
      .subscribe((data: any) => {
        console.log(data);
        this.elementos = data;
      });
  }

}
