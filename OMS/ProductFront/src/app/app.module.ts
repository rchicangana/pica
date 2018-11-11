import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';

import {NgxPaginationModule} from 'ngx-pagination';
import {NgbModule} from '@ng-bootstrap/ng-bootstrap';

import { AppComponent } from './app.component';
import { ProductoComponent } from './components/producto/producto.component';


// Importar Rutas
import { ROUTES } from './app.routes';
import { CargarimagenesComponent } from './components/cargarimagenes/cargarimagenes.component';
import { ItinerarioComponent } from './components/itinerario/itinerario.component';
import { BoleteriaComponent } from './components/boleteria/boleteria.component';
import { ConsultaComponent } from './components/consulta/consulta.component';

@NgModule({
  declarations: [
    AppComponent,
    ProductoComponent,
    CargarimagenesComponent,
    ItinerarioComponent,
    BoleteriaComponent,
    ConsultaComponent
  ],
  imports: [
    BrowserModule,
    NgxPaginationModule,
    HttpClientModule,
    FormsModule,
    NgbModule,
    RouterModule.forRoot( ROUTES, {useHash: true} )
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
