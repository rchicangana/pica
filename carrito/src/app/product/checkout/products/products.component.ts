import { ProductService } from "./../../../shared/services/product.service";
import { Component, OnInit } from "@angular/core";
import { Product } from "../../../shared/models/product";
import { Tarifa } from "../../../shared/models/tarifa";

@Component({
  selector: "app-products",
  templateUrl: "./products.component.html",
  styleUrls: ["./products.component.scss"]
})
export class ProductsComponent implements OnInit {
  checkoutProducts: Tarifa[];

  totalPrice = 0;
  constructor(private productService: ProductService) {
    const products = productService.getLocalCartProducts();

    this.checkoutProducts = products;

    products.forEach(product => {
      console.log("Checkout", product.total);
      this.totalPrice += product.total.valueOf();
    });
  }

  ngOnInit() {}
}
