import { Component, OnInit } from "@angular/core";
import { Tarifa } from "../../shared/models/tarifa";
import { ProductService } from "../../shared/services/product.service";
import { AuthService } from "../../shared/services/auth.service";
import { SolicitudService } from "../../shared/services/solicitud.service";
import { ProductosCliente } from "../../shared/models/solicitud";
import { Usuario } from "../../shared/models/user";
import { Respuesta, Respuesta2 } from "../../shared/models/respuesta";

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
  productosCliente: ProductosCliente[];
  userDetail: Usuario;

  constructor(
    private productService: ProductService,
    private authService: AuthService,
    private solicitudService: SolicitudService
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
    if(this.authService.isLoggedIn()){
      this.userDetail = this.authService.getLoggedInUser();
      this.solicitudService.solicitudPorUsuario(this.userDetail.id)
      .subscribe(
      data => {
          this.productosCliente = <ProductosCliente[]>(<Respuesta>data).objeto;
          if(this.productosCliente != undefined){
            this.productosCliente.forEach((nos) => { 
              this.productService.getProductById(nos.idproducto.toString())
              .subscribe(
                data => {
                    if((<Respuesta2>data).codigo=="OK"){
                      let producto: Tarifa = <Tarifa> (<Respuesta2>data).object;
                      this.cartProducts.push(producto);
                    }
                },
                error => {
                });
            });
          }
      },
      error => {
      });
    }
    else{
      this.cartProducts = this.productService.getLocalCartProducts();
    }
  }
}
