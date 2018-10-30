import { Component, OnInit } from "@angular/core";
import { Product } from "../../shared/models/product";
import { Mensaje } from '../../shared/models/mensaje';
import { Respuesta } from '../../shared/models/respuesta';
import { AuthService } from "../../shared/services/auth.service";
import { ProductService } from "../../shared/services/product.service";
import { LoaderSpinnerService } from "../../shared/loader-spinner/loader-spinner";
//dj router para capturar el parametro
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: "app-product-list-s",
  templateUrl: "./product-list-s.component.html",
  styleUrls: ["./product-list-s.component.scss"]
})
export class ProductListComponentS implements OnInit {
  productList: Product[];
  mensaje : Mensaje;
  respuesta : Respuesta;
  brands = ["Todos", "Futbol", "Ciclisto", "Olimpicos", "Boxeo", "Tenis"];

  selectedBrand: "All";
  tipo:string;


  page = 1;
  constructor(
    //dj Inicio
    private activatedRoute:ActivatedRoute,
    //dj fin

    public authService: AuthService,
    private productService: ProductService,
    private spinnerService: LoaderSpinnerService
  ) {


  }

  ngOnInit() {
    //this.getAllProducts();

    //DJ Inicio


        this.activatedRoute.params.subscribe( params => {
        this.tipo= params['tipo'];
        console.log('este es el tipo del tipo'+this.tipo);
    if ( params['tipo'] == 'D' )
    {
              if (typeof params['termino'] === 'undefined' )
              {
                this.getAllProductsS("D","*");
                }
                else{
                  this.getAllProductsS( params['tipo'], params['termino']);
                }
    }
    else if ( params['tipo'] == 'C' ){

      if (typeof params['termino'] === 'undefined' )
      {
        this.getAllProductsS("C","*");
        }
        else{
          this.getAllProductsS( params['tipo'], params['termino']);
        }


    }
    else if ( params['tipo'] == 'P' ){

      if (typeof params['termino'] === 'undefined' )
      {
        this.getAllProductsS("P","*");
        }
        else{
          this.getAllProductsS( params['tipo'], params['termino']);
        }
    }

            })
        //dj fin

  }

  getAllProductsS(t1:String, t2:String) {
    this.spinnerService.show();
    const x = this.productService.getProductsS(t1 ,t2)
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
    /*x.snapshotChanges()
    .subscribe(product => {
      this.spinnerService.hide();
      this.productList = [];
      product.forEach(element => {
        const y = element.payload.toJSON();
        y["$key"] = element.key;
        this.productList.push(y as Product);
      });
    });*/
  }

  removeProduct(key: string) {
    this.productService.deleteProduct(key);
  }

  addFavourite(product: Product) {
    this.productService.addFavouriteProduct(product);
  }

  addToCart(product: Product) {
    this.productService.addToCart(product);
  }
}