import { Component, OnInit } from '@angular/core';

import { Usuario, Mensaje } from '../_models';
import { UserService } from '../_services';

@Component({
   // moduleId: module.id,
    templateUrl: 'home.component.html'
})

export class HomeComponent implements OnInit {
    currentUser: Usuario;
    mensaje : Mensaje;
    users: Usuario[] = [];

    constructor(private userService: UserService) {
        this.currentUser = JSON.parse(localStorage.getItem('currentUser'));
    }

    ngOnInit() {
        this.loadAllUsers();
    }

    deleteUser(id: number) {
        this.userService.delete(id).subscribe(() => { this.loadAllUsers() });
    }

    private loadAllUsers() {
        this.userService.getAll()           
        .subscribe(
            data => {
                this.mensaje = <Mensaje> data; 
                this.users = <Usuario[]>this.mensaje.objeto;
                //this.alertService.success('Registro Exitoso!', true);
                //this.router.navigate(['/login']);
            },
            error => {
               //this.alertService.error(error);
               // this.loading = false;
            });
    }
}