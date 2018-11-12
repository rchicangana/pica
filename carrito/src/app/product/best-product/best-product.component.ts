import { Component, OnInit } from "@angular/core";
import { Product, Top5 } from "../../shared/models/product";
import { ProductService } from "../../shared/services/product.service";
import { Respuesta, Respuesta2 } from '../../shared/models/respuesta';
declare var $: any;

@Component({
  selector: "app-best-product",
  templateUrl: "./best-product.component.html",
  styleUrls: ["./best-product.component.scss"]
})
export class BestProductComponent implements OnInit {
  bestProducts: Top5[] = [];
  options: any;
  constructor(private productService: ProductService) {}

  ngOnInit() {
    this.options = {
      dots: false,
      responsive: {
        "0": { items: 1, margin: 5 },
        "430": { items: 2, margin: 5 },
        "550": { items: 3, margin: 5 },
        "670": { items: 4, margin: 5 }
      },
      autoplay: true,
      loop: true,
      autoplayTimeout: 3000,
      lazyLoad: true
    };
    this.getAllProducts();
  }

  getAllProducts() {
    const x = this.productService.getTopFive()
    //x.snapshotChanges()
    .subscribe(
      data => {
          this.bestProducts = [];
          if((<Respuesta2>data).codigo=="OK"){
            let productos = <Top5[]> (<Respuesta2>data).object;
            productos.forEach(elemento => {
              this.bestProducts.push(elemento);
            });
          }
      },
      error => {
      });
  }
}
