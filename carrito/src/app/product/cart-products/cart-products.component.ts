import { Component, OnInit } from "@angular/core";
import { Tarifa } from "../../shared/models/tarifa";
import { ProductService } from "../../shared/services/product.service";

@Component({
  selector: "app-cart-products",
  templateUrl: "./cart-products.component.html",
  styleUrls: ["./cart-products.component.scss"]
})
export class CartProductsComponent implements OnInit {
  cartProducts: Tarifa[];
  showDataNotFound = true;

  // Not Found Message
  messageTitle = "No se encontraron paquetes en el Carrito";
  messageDescription = "Agregue paquetes a su carrito";

  constructor(private productService: ProductService) {}

  ngOnInit() {
    this.getCartProduct();
  }

  removeCartProduct(tarifa: Tarifa) {
    this.productService.removeLocalCartProduct(tarifa);

    // Recalling
    this.getCartProduct();
  }

  getCartProduct() {
    this.cartProducts = this.productService.getLocalCartProducts();
  }
}
