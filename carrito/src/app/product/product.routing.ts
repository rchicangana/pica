import { CheckoutComponent } from "./checkout/checkout.component";
import { CartProductsComponent } from "./cart-products/cart-products.component";
import { FavouriteProductsComponent } from "./favourite-products/favourite-products.component";
import { ProductListComponentS } from "./product-list-s/product-list-s.component";
import { ProductListComponent } from "./product-list/product-list.component";
import { Routes } from "@angular/router";
import { IndexComponent } from "../index/index.component";
import { ProductDetailComponent } from "./product-detail/product-detail.component";
import {ConsultarcampanaComponent} from '../campanas/campanas.component';

export const ProductRoutes: Routes = [
  {
    path: "products",
    children: [
      {
        path: "",
        component: IndexComponent
      },
      {
     path: "campanas",
     component: ConsultarcampanaComponent
     },
     {
        path: "all-products-s/:tipo/:termino",
        component: ProductListComponentS
      },
      {
        path: "all-products",
        component: ProductListComponent
      },
      {
        path: "favourite-products",
        component: FavouriteProductsComponent
      },
      {
        path: "cart-items",
        component: CartProductsComponent
      },
      {
        path: "checkouts",
        loadChildren: "./checkout/checkout.module#CheckoutModule"
      },
      {
        path: "product/:id",
        component: ProductDetailComponent
      }
    ]
  }
];
