import { Component, OnInit, OnDestroy } from "@angular/core";
import { ActivatedRoute } from "@angular/router";
import { Product } from "../../shared/models/product";
import { ProductService } from "../../shared/services/product.service";
import { LoaderSpinnerService } from "../../shared/loader-spinner/loader-spinner";

@Component({
  selector: "app-product-detail",
  templateUrl: "./product-detail.component.html",
  styleUrls: ["./product-detail.component.scss"]
})
export class ProductDetailComponent implements OnInit, OnDestroy {
  private sub: any;
  product: Product;

  constructor(
    private route: ActivatedRoute,
    private productService: ProductService,
    private spinnerService: LoaderSpinnerService
  ) {
    this.product = new Product();
  }

  ngOnInit() {
    this.sub = this.route.params.subscribe(params => {
      const id = params["id"]; // (+) converts string 'id' to a number
      this.getProductDetail(id);
    });
  }

  getProductDetail(id: string) {
    this.spinnerService.show();
    const x = this.productService.getProductById(id)
    .subscribe(
      data => {
          //this.product = <Product> data.productoPorIdResult;
          if(data.codigo=="OK"){
            this.product = <Product> data.object;
            this.product.precio = 100;
          }
      },
      error => {
      });
  }

  ngOnDestroy() {
    this.sub.unsubscribe();
  }

  addToCart(product: Product) {
    this.productService.addToCart(product);
  }
}
