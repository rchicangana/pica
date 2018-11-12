import { Routes } from '@angular/router';
import { ProductoComponent } from './components/producto/producto.component';
import { ConsultaComponent } from './components/consulta/consulta.component';


export const ROUTES: Routes = [
    {path: 'producto', component: ProductoComponent},
    {path: 'consultar', component: ConsultaComponent},
    {path: '', pathMatch: 'full', redirectTo: 'producto'},
    {path: '**', pathMatch: 'full', redirectTo: 'producto'}
];

