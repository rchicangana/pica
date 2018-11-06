import { Component, OnInit } from "@angular/core";
import { Tarifa } from "../../shared/models/tarifa";
import { ProductService } from "../../shared/services/product.service";
import { AuthService } from "../../shared/services/auth.service";

@Component({
  selector: "app-cart-products",
  templateUrl: "./cart-products.component.html",
  styleUrls: ["./cart-products.component.scss"]
})
export class CartProductsComponent implements OnInit {
  cartProducts: Tarifa[];
  showDataNotFound = true;
  messageTitle = "No se encontraron paquetes en el Carrito";
  messageDescription = "Agregue paquetes a su carrito";

  constructor(
    private productService: ProductService,
    private authService: AuthService
    ) {
     
    }

  ngOnInit() {
    this.getCartProduct();
  }

  removeCartProduct(tarifa: Tarifa) {
    this.productService.removeLocalCartProduct(tarifa);
    this.getCartProduct();
  }

  getCartProduct() {
    //if(this.authService.isLoggedIn()){
    //  this.cartProducts = this.productService.getUsersCartProducts();
   // }
   // else{
      this.cartProducts = this.productService.getLocalCartProducts();
   // }
  }
}
