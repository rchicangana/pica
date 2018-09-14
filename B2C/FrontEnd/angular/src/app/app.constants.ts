import { Injectable } from '@angular/core';

@Injectable()
export class Configuration {
    public Server = 'http://localhost:3135';
    public ApiUrl = 'Usuario.svc/usuarios/usuarios/';
    public ServerWithApiUrl = this.Server + this.ApiUrl;
}