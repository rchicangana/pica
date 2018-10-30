import { Component, OnInit, OnDestroy } from "@angular/core";
import { ActivatedRoute } from "@angular/router";
import { Product } from "../../shared/models/product";
import { Respuesta } from "../../shared/models/respuesta";
import { ProductService } from "../../shared/services/product.service";
import { LoaderSpinnerService } from "../../shared/loader-spinner/loader-spinner";
import { Tarifa } from "../../shared/models/tarifa";

@Component({
  selector: "app-product-detail",
  templateUrl: "./product-detail.component.html",
  styleUrls: ["./product-detail.component.scss"]
})
export class ProductDetailComponent implements OnInit, OnDestroy {
  private sub: any;
  product: Tarifa;

  public imageSources: string[] = [];
  public imagenProducto: string;
  public nombreProducto: string;

  constructor(
    private route: ActivatedRoute,
    private productService: ProductService,
    private spinnerService: LoaderSpinnerService
  ) {
    this.product = new Tarifa();
  }

  ngOnInit() {
    this.sub = this.route.params.subscribe(params => {
      const id = params["id"]; 
      const imagen = params["imagen"];
      const nombre = params["nombre"];
      this.imagenProducto = imagen;
      this.nombreProducto = nombre;
      this.getProductDetail(id);
    });
  }

  getProductDetail(id: string) {
    this.spinnerService.show();
    const x = this.productService.getProductById(id)
    .subscribe(
      data => {
          //this.product = <Product> data.productoPorIdResult;
          if((<Respuesta>data).codigo=="OK"){
            this.product = <Tarifa> (<Respuesta>data).object;
            for (let item of this.product.itinerarioDTOlist[0].idHospedaje.habitacionList[0].imagenHabitacionList){
              this.imageSources.push("http://10.39.1.140/imagenes/"+item.imagen);
            }
            this.product.nombre = this.nombreProducto;
            this.product.imagen = this.imagenProducto;
          }
      },
      error => {
      });

 
  }

  ngOnDestroy() {
    this.sub.unsubscribe();
  }

  addToCart(product: Tarifa) {
    this.productService.addToCart(product);
  }
}
