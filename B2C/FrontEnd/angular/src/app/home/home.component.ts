import { Component, OnInit } from '@angular/core';

import { Usuario } from '../_models';
import { UserService } from '../_services';

@Component({
   // moduleId: module.id,
    templateUrl: 'home.component.html'
})

export class HomeComponent implements OnInit {
    currentUser: Usuario;
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
        this.userService.getAll();//.subscribe(users => { this.users = users; });
    }
}