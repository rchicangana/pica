export class Cliente{
    tipoDocumento:String;//"CC",
    noDocumento:String;//"1234435",
    nombres:String;//"opopop",
    apellido1:String;//"opopop",
    apellido2:String;//"opopop",
    razonSocial:String;//null;
    estado:String;//"ACTIVO",
    idCategoria:Number;//2
    constructor(tipoDocumento:String, noDocumento:String, nombres:String, apellido1:String,apellido2:String, razonSocial:String,estado:String,idCategoria:Number){
      this.tipoDocumento = tipoDocumento;
      this.noDocumento = noDocumento;
      this.nombres = nombres;
      this.apellido1 = apellido1;
      this.apellido2 = apellido2;
      this.razonSocial = razonSocial;
      this.estado = estado;
      this.idCategoria = idCategoria;
    }
  }

  export class ClienteResponse{
    apellido1:String;
    apellido2:String;
    estado:String;
    fechaCreacion:Date;
    fechaUltModificacion:Date;
    idCategoria:Number;
    idCliente:Number;
    noDocumento:String;
    nombres:String;
    tipoDocumento:String;
  }