export class Usuario {
  id: number;
  nombres: string;
  apellidos: string;
  login: string;
  password: string;
  activo: boolean;
  fecha_creacion: Date;
  direccion: String;
  pais: String;
  departamento: String;
  ciudad: String;
  tipodoc: String;
  identificacion: String;
  idcliente: Number;
  constructor(login: string, password: string, nombres: string, apellidos: string, tipodoc: String, identificacion : String, idcliente :Number) {
    this.login = login;
    this.password = password;
    this.nombres = nombres;
    this.apellidos = apellidos;
    this.direccion = "";
    this.pais = "";
    this.departamento = "";
    this.ciudad = "";
    this.tipodoc = tipodoc;
    this.identificacion = identificacion;
<<<<<<< HEAD
    this.idcliente = idcliente;
=======
>>>>>>> c850cb9c67b078b76792d3effd6430a8a71a5fe4
  }
}