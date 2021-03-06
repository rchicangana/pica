import { NgModule } from "@angular/core";
import { CommonModule } from "@angular/common";
import { NoProductsFoundComponent } from "./components/no-products-found/no-products-found.component";
import { MDBBootstrapModule } from "angular-bootstrap-md";
import { FormsModule, FormBuilder } from "@angular/forms";
import { ToastyModule } from "ng2-toasty";
import { RouterModule, Router } from "@angular/router";
import { OwlModule } from "ngx-owl-carousel";
import { NgxPaginationModule } from "ngx-pagination";
import { HttpClientModule } from "@angular/common/http";
import { AgmCoreModule } from "@agm/core";
import { NoAccessComponent } from "./components/no-access/no-access.component";
import { PageNotFoundComponent } from "./components/page-not-found/page-not-found.component";
import { FilterByBrandPipe } from "./pipes/filterByBrand.pipe";
import { ProductService } from "./services/product.service";
import { AdminGaurd } from "./services/admin-gaurd";
import { AuthGuard } from "./services/auth_gaurd";
import { AuthService } from "./services/auth.service";
import { UserService } from "./services/user.service";
import { LoaderSpinnerService } from "./loader-spinner/loader-spinner";
import { UtilService } from "./services/util.service";

@NgModule({
  imports: [
    CommonModule,
    MDBBootstrapModule.forRoot(),
    FormsModule,
    HttpClientModule,
    RouterModule,
    ToastyModule.forRoot(),
    OwlModule,
    NgxPaginationModule,
    AgmCoreModule.forRoot({
      apiKey: "AIzaSyDMbxW3MlwUP2vrAZVJyu7pYqZa1LthvTE"
    })
  ],
  declarations: [
    NoProductsFoundComponent,
    FilterByBrandPipe,
    NoAccessComponent,
    PageNotFoundComponent
  ],
  exports: [
    NoProductsFoundComponent,
    FormsModule,
    MDBBootstrapModule,
    FormsModule,
    ToastyModule,
    RouterModule,
    OwlModule,
    NgxPaginationModule,
    FilterByBrandPipe,
    AgmCoreModule,
    NoAccessComponent,
    PageNotFoundComponent
  ],
  providers: [
    AuthService,
    AuthGuard,
    AdminGaurd,
    ProductService,
    UserService,
    FormBuilder,
    LoaderSpinnerService,
    UtilService
  ]
})
export class SharedModule {}
