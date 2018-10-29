import { Component, OnInit } from "@angular/core";
import { Product } from "../../shared/models/product";
import { Tarifa } from "../../shared/models/tarifa";
import { Mensaje } from '../../shared/models/mensaje';
import { Respuesta } from '../../shared/models/respuesta';
import { AuthService } from "../../shared/services/auth.service";
import { ProductService } from "../../shared/services/product.service";
import { LoaderSpinnerService } from "../../shared/loader-spinner/loader-spinner";

@Component({
  selector: "app-product-list",
  templateUrl: "./product-list.component.html",
  styleUrls: ["./product-list.component.scss"]
})
export class ProductListComponent implements OnInit {
  productList: Product[];
  mensaje : Mensaje;
  respuesta : Respuesta;
  brands = ["Todos", "Futbol", "Ciclisto", "Olimpicos", "Boxeo", "Tenis"];

  selectedBrand: "All";

  page = 1;
  constructor(
    public authService: AuthService,
    private productService: ProductService,
    private spinnerService: LoaderSpinnerService
  ) {}

  ngOnInit() {
    this.getAllProducts();
  }

  getAllProducts() {
    this.spinnerService.show();
    const x = this.productService.getProducts()
    .subscribe(
      data => {
          this.productList = [];
          if((<Respuesta>data).codigo=="OK"){
            let productos = <Product[]> (<Respuesta>data).object;
            productos.forEach(elemento => {
              this.productList.push(elemento);
            });
          }
      },
      error => {
      });
  }

  addFavourite(product: Product) {
    this.productService.addFavouriteProduct(product);
  }

  addToCart(product: Tarifa) {
    this.productService.addToCart(product);
  }
}
