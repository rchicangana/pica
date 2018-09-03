import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { CarritoCompraComponent } from './carrito-compra/carrito-compra.component';
import { CampanasComponent } from './campanas/campanas.component';
import { BuscadorComponent } from './buscador/buscador.component';
import { HeaderComponent } from './header/header.component';
import { FooterComponent } from './footer/footer.component';
import { AcercadeComponent } from './acercade/acercade.component';
import { ServiciosComponent } from './servicios/servicios.component';
import { NoticiasComponent } from './noticias/noticias.component';
import { ContactoComponent } from './contacto/contacto.component';
import {EnrutadorModule} from './enrutador/enrutador.module';
import { InicioComponent } from './inicio/inicio.component';

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
    InicioComponent
  ],
  imports: [
    BrowserModule,
    EnrutadorModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
