import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';

import { AppComponent } from './app.component';
import { RouterModule } from '@angular/router';
import { HttpClientModule } from '@angular/common/http';


import { LoginComponent } from './components/login/login.component';
import { HomeComponent } from './components/home/home.component';



// Importar Rutas
import { ROUTES } from './app.routes';
import { NeedAuthGuard } from 'src/auth.guard';


@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    HomeComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    FormsModule,
    RouterModule.forRoot( ROUTES, { useHash: true } )
  ],
  providers: [NeedAuthGuard],
  bootstrap: [AppComponent]
})
export class AppModule { }
