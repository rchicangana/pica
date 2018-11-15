import { Component, OnInit } from "@angular/core";
import { Product } from "../../shared/models/product";
import { Tarifa } from "../../shared/models/tarifa";
import { Mensaje } from '../../shared/models/mensaje';
import { Respuesta, Respuesta2 } from '../../shared/models/respuesta';
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
  numeroProductos:number;


  page = 1;
  constructor(
    public authService: AuthService,
    private productService: ProductService,
    private spinnerService: LoaderSpinnerService
  ) {}

  ngOnInit() {

    this.numeroProductos = 1000000 //this.CountProductsS();

this.getPage(1);
    // this.getAllProducts();
  }

  getPage(p:number) {
    this.page=p;
    console.log(p);

    let cantidad = this.CountProducts();

    console.log("CountProducts()"+this.CountProducts());
    console.log(this.numeroProductos);


    this.spinnerService.show();
    const x = this.productService.getProducts(p)
    .subscribe(
      data => {
          this.productList = [];
          if((<Respuesta2>data).codigo=="OK"){
            let productos = <Product[]> (<Respuesta2>data).object;
            productos.forEach(elemento => {
              if(elemento.imagenProductoList.length <= 0){
                elemento.imagenProductoList = [{idImagenProducto: 1, imagen: "sinimagen.jpg", esprincipal: 1, idProducto: 1} ];
              }
              this.productList.push(elemento);
              console.log(elemento);
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


  CountProducts() {

    const x = this.productService.CountProducts()
    .subscribe(
      data => {

          this.numeroProductos = 0;
          if((<Respuesta2>data).codigo=="OK"){
            let cantidad  =   <number> (<Respuesta2>data).cantidad;
            this.numeroProductos = cantidad;
            console.log("numeroproductos"+this.numeroProductos );
          }
      },
      error => {
      });

  }



}
