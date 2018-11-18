// Core Dependencies
import { NgModule } from "@angular/core";
import { CommonModule } from "@angular/common";
import { RouterModule } from "@angular/router";

// configuration and services
import { ProductRoutes } from "./product.routing";

// Components
import { CheckoutModule } from "./checkout/checkout.module";

import { ProductComponent } from "./product.component";
import { BestProductComponent } from "./best-product/best-product.component";
import { BestProductComponent2 } from "./best-product2/best-product.component2";
import { ProductListComponent } from "./product-list/product-list.component";
import { ProductListComponentS } from "./product-list-s/product-list-s.component";
import { ProductDetailComponent } from "./product-detail/product-detail.component";
import { SharedModule } from "../shared/shared.module";
import { FavouriteProductsComponent } from "./favourite-products/favourite-products.component";
import { CartProductsComponent } from "./cart-products/cart-products.component";
import { CartCalculatorComponent } from "./cart-calculator/cart-calculator.component";
import {SlideshowModule} from 'ng-simple-slideshow';

@NgModule({
  imports: [
    CommonModule,
    RouterModule.forChild(ProductRoutes),
    SharedModule,
    CheckoutModule,
    SlideshowModule
  ],
  declarations: [
    ProductComponent,
    BestProductComponent,
    BestProductComponent2,
    ProductListComponent,
    ProductListComponentS,
    ProductDetailComponent,
    FavouriteProductsComponent,
    CartProductsComponent,
    CartCalculatorComponent
  ],
  exports: [BestProductComponent,BestProductComponent2]
})
export class ProductModule {}
