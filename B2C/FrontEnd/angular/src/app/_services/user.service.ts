import { Injectable } from '@angular/core';
import { HttpClient, HttpParams, HttpHeaders } from '@angular/common/http';
//import { Http, Headers, Response, RequestOptions, RequestMethod } from '@angular/http';
import { Usuario } from '../_models';

@Injectable()
export class UserService {
    constructor(private http: HttpClient) { }

    getAll() {
        //var apiUrl = "http://localhost";
       // return this.http.get<Usuario[]>(apiUrl+'/users');
    }

    getByLogin(login: string) {
        var apiUrl = "./Usuario.svc/Usuario";
        return this.http.get(apiUrl+'/consultausuario/' + login);
    }

    register(usuario: Usuario) {
        var apiUrl = "./Usuario.svc/Usuario";
        let usuarioJson = JSON.stringify(usuario);            
        //let usuarioJson = usuario;   
        let headers = new HttpHeaders();
        headers.append('Accept', 'application/json');
        headers.append('Content-Type', 'application/json');
        headers.append('Access-Control-Allow-Headers', 'Content-Type');
        headers.append('Access-Control-Allow-Methods', 'POST');
        headers.append('Access-Control-Allow-Origin', '*');
        let params = "json="+usuarioJson;
 
                //Establecemos cabeceras
        //let headers = new HttpHeaders().set('Content-Type','application/json');
        //let head = new Headers({ 'Content-Type': 'application/json' });
        //head.append('Accept', 'application/json');
        //let options = new RequestOptions({ headers: head });
        return this.http.post(apiUrl+'/crearusuario', usuarioJson, { headers: headers })
        .subscribe(
            data => {
                console.log("Datos enviados con exito ", data);
            },
            error => {
                console.log("Error", error);
            }
        );
    }

    update(user: Usuario) {
        //var apiUrl = "http://localhost";
        return this.http.put('/.users/' + user.id, user);
    }

    delete(id: number) {
        //var apiUrl = "http://localhost";
        return this.http.delete('./users/' + id);
    }
}