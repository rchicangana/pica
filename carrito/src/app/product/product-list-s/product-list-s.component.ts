import { Component, OnInit } from "@angular/core";
import { Product } from "../../shared/models/product";
import { Mensaje } from '../../shared/models/mensaje';
import { Respuesta, Respuesta2 } from '../../shared/models/respuesta';
import { AuthService } from "../../shared/services/auth.service";
import { ProductService } from "../../shared/services/product.service";
import { LoaderSpinnerService } from "../../shared/loader-spinner/loader-spinner";
import { ActivatedRoute } from '@angular/router';



@Component({
  selector: "app-product-list-s",
  templateUrl: "./product-list-s.component.html",
  styleUrls: ["./product-list-s.component.scss"]
})
export class ProductListComponentS implements OnInit {
  productList: Product[];
  producto: Product;
  mensaje : Mensaje;
  respuesta : Respuesta;
  brands = ["Todos", "Futbol", "Ciclisto", "Olimpicos", "Boxeo", "Tenis"];
  selectedBrand: "All";
  tipo:string;
  numeroProductos:number;
  numeroProductosS:number;

  page = 1;
  constructor(
    private activatedRoute:ActivatedRoute,
    public authService: AuthService,
    private productService: ProductService,
    private spinnerService: LoaderSpinnerService
  ) {
  }

  ngOnInit(){
    this.getPage(1);
    this.numeroProductosS = 10 //this.CountProductsS();
    console.log('CANTIDAD EN EL ONINIT SSS:'+ this.numeroProductosS);
  }

  getPage(p:number){
    //this.getAllProducts();
this.page=p;
    //DJ Inicio
console.log(p);

        this.activatedRoute.params.subscribe( params => {
        this.tipo= params['tipo'];
        console.log('este es el tipo del tipo sss'+this.tipo);
        let cantidad = this.CountProductsS(params['termino']);
        console.log(cantidad);

    if ( params['tipo'] == 'D' )
    {
              if (typeof params['termino'] === 'undefined' )
              {
                this.getAllProductsS("D","*",this.page);
                }
                else{
                  this.getAllProductsS( params['tipo'], params['termino'],this.page);
                }
    }
    else if ( params['tipo'] == 'C' ){

      if (typeof params['termino'] === 'undefined' )
      {
        this.getAProductsS("C","*");
        }
        else{
          this.getAProductsS( params['tipo'], params['termino']);
        }
    }
    else if ( params['tipo'] == 'P' ){

      if (typeof params['termino'] === 'undefined' )
      {
        this.getAllProductsS("P","*",this.page);
        }
        else{
          this.getAllProductsS( params['tipo'], params['termino'],this.page);
        }
    }
    })
  }

  getAllProductsS(t1:String, t2:String, p:number ) {
    this.spinnerService.show();
    const x = this.productService.getProductsS(t1 ,t2, p)
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
            });
          }
      },
      error => {
      });
  }


  CountProductsS(t?:string) {

    const x = this.productService.CountProductsS(t)
    .subscribe(
      data => {

          this.numeroProductosS = 0;
          if((<Respuesta2>data).codigo=="OK"){
            let cantidad  =   <number> (<Respuesta2>data).cantidad;
            this.numeroProductosS = cantidad;
            console.log("numeroproductosS"+this.numeroProductosS );
          }
      },
      error => {
      });

  }


  getAProductsS(t1:String, t2:String) {
    this.spinnerService.show();
    const x = this.productService.getProductsS(t1 ,t2)
    .subscribe(
      data => {

          this.productList = [];
          if((<Respuesta2>data).codigo=="OK"){
            let productos = <Product> (<Respuesta2>data).object;
            if(productos.imagenProductoList.length <= 0){
              productos.imagenProductoList = [{idImagenProducto: 1, imagen: "sinimagen.jpg", esprincipal: 1, idProducto: 1} ];
            }
            this.producto = productos;

            console.log(this.producto);
          }
      },
      error => {
      });
  }




}
