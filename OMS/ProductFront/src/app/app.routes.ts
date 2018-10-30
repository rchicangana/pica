import { Routes } from '@angular/router';
import { ProductoComponent } from './components/producto/producto.component';


export const ROUTES: Routes = [
    {path: 'producto', component: ProductoComponent},
    {path: '', pathMatch: 'full', redirectTo: 'producto'},
    {path: '**', pathMatch: 'full', redirectTo: 'producto'}
];
