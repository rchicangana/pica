export class Cliente{
  $key: number;
  tipo_documento: string;
  no_documento: string;
  nombres: string;
  apellido1: string;
  apellido2: string;
  razon_social: string;
  estado: string;
  id_contacto_def: number;
  id_categoria: number;
  fecha_ult_modificacion: Date;
  fecha_creacion: Date;
}

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
  idcliente: number;
  constructor(login: string, password: string, nombres: string, apellidos: string, tipodoc: String, identificacion : String) {
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
  }
}