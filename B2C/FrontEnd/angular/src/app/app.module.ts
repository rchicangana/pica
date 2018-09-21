import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { HttpModule } from '@angular/http';

import { AppComponent } from './app.component';
import { CarritoCompraComponent } from './carrito-compra/carrito-compra.component';
import { CampanasComponent } from './campanas/campanas.component';
import { BuscadorComponent } from './buscador/buscador.component';
import { HeaderComponent } from './header/header.component';
import { FooterComponent } from './footer/footer.component';
import { AcercadeComponent } from './acercade/acercade.component';
import { ServiciosComponent } from './servicios/servicios.component';
import { NoticiasComponent } from './noticias/noticias.component';
import { ContactoComponent } from './contacto/contacto.component';
import { EnrutadorModule } from './enrutador/enrutador.module';
import { InicioComponent } from './inicio/inicio.component';

import { AlertComponent } from './_directives';
import { AuthGuard } from './_guards';
import { JwtInterceptor } from './_helpers';
import { AlertService, AuthenticationService, UserService } from './_services';
import { HomeComponent } from './home';
import { LoginComponent } from './login';
import { LoginInicioComponent } from './loginInicio';
import { RegisterComponent } from './register';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    CarritoCompraComponent,
    CampanasComponent,
    BuscadorComponent,
    HeaderComponent,
    FooterComponent,
    AcercadeComponent,
    ServiciosComponent,
    NoticiasComponent,
    ContactoComponent,
    InicioComponent,
    AlertComponent,
    HomeComponent,
    LoginInicioComponent,
    RegisterComponent
  ],
  imports: [
    BrowserModule,
    EnrutadorModule,
    FormsModule,
    HttpClientModule, 
    ReactiveFormsModule,
    HttpModule
  ],
  providers: [
    AuthGuard,
    AlertService,
    AuthenticationService,
    UserService,
    {
        provide: HTTP_INTERCEPTORS,
        useClass: JwtInterceptor,
        multi: true
    },
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
