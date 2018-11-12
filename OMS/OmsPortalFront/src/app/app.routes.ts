import { Routes } from '@angular/router';
import { HomeComponent } from './components/home/home.component';
import { LoginComponent } from './components/login/login.component';
import { NeedAuthGuard } from 'src/auth.guard';



export const ROUTES: Routes = [
    {path: 'home', component: HomeComponent, canActivate: [NeedAuthGuard]},
    {path: 'login', component: LoginComponent},
    {path: '', pathMatch: 'full', redirectTo: 'home'},
    {path: '**', pathMatch: 'full', redirectTo: 'home'}
];
