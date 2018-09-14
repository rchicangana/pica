import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Routes, RouterModule } from '@angular/router';
//componentes
import {InicioComponent} from '../inicio/inicio.component';
import {AcercadeComponent} from '../acercade/acercade.component';
import {ServiciosComponent} from '../servicios/servicios.component';
import {NoticiasComponent} from '../noticias/noticias.component';
import {ContactoComponent} from '../contacto/contacto.component';
import { HomeComponent } from '../home';
import { LoginComponent } from '../login';
import { LoginInicioComponent } from '../loginInicio';
import { RegisterComponent } from '../register';
import { AuthGuard } from '../_guards';

const routes: Routes = [
  {path: '', component: InicioComponent},
  {path: 'inicio', component: InicioComponent},
  {path: 'acercade', component: AcercadeComponent},
  {path: 'servicios', component: ServiciosComponent},
  {path: 'noticias', component: NoticiasComponent},
  {path: 'contacto', component: ContactoComponent},
  {path: 'loginInicio', component: LoginInicioComponent},
  { path: 'login', component: LoginComponent },
  { path: 'register', component: RegisterComponent }
  ];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class EnrutadorModule { }
