import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
//import { Http, Headers, Response, RequestOptions, RequestMethod } from '@angular/http';
import { Usuario } from '../_models';

@Injectable()
export class UserService {
    constructor(private http: HttpClient) { }
    apiUrl :string = "./Usuario.svc/Usuario";

    getAll() {
        return this.http.get(this.apiUrl+'/usuarios');
    }

    getByLoginPassword(login: string, password: string) {
        return this.http.get(this.apiUrl+'/consultausuario/' + login+'/'+password);
    }

    register(usuario: Usuario) {
        let usuarioJson = JSON.stringify(usuario);   
        const headers = new HttpHeaders({'Content-Type': 'application/json'});         
        return this.http.post(this.apiUrl+'/crearusuario', usuarioJson, { headers });
    }

    update(user: Usuario) {
        return this.http.put('/.users/' + user.id, user);
    }

    delete(id: number) {
        return this.http.delete('./users/' + id);
    }
}