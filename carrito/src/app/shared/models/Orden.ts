export class EnviarOrden{
    estadoOrdenCompra: {
        idEstadoOrdenCompra: Number;
        estado: String;//ABIERTA
    };
    fechaCreacion: String;
    fechaVencimiento: String;
    numeroSolicitud: Number;
    valorTotal: Number;
    idCliente: Number;
    detalleOrdenCompras: [
        {
            producto: {
                idProducto: Number;
                imagenProductos: [{}];
            },
            valor: Number;
        }
    ];
    constructor(estadoOrdenCompra: any,    
        fechaCreacion: String,
        fechaVencimiento: String,
        numeroSolicitud: Number,
        valorTotal: Number,
        idCliente: Number,
        detalleOrdenCompras: any){
            this.estadoOrdenCompra = estadoOrdenCompra, 
            this.fechaCreacion = fechaCreacion,
            this.fechaVencimiento = fechaVencimiento,
            this.numeroSolicitud = numeroSolicitud,
            this.valorTotal = valorTotal,
            this.idCliente = idCliente,
            this.detalleOrdenCompras = detalleOrdenCompras
    }
}

export class DetalleOrdenCompras
{
    producto: {
        idProducto: Number;
        imagenProductos: [{}];
    };
    valor: Number;
    constructor(producto : any, valor : Number){
        this.producto = producto;
        this.valor = valor;
    }
}

export class Orden
{  
    noOrden:Number;
    estadoOrdenCompra:{  
       idEstadoOrdenCompra:Number;
       estado:String;
       ordenCompras:[  
        {
        }
       ];
       inicio:Number;
       cuantos:Number;
    };
    fechaCreacion:Date;
    fechaVencimiento:Date;
    numeroSolicitud:Number;
    valorTotal:Number;
    detalleOrdenCompras:[  
       {  
          idDetalleOrden:Number;
          ordenCompra:Number;
          producto:{  
             idProducto:Number;
             tipoProducto:{  
                idTipoProducto:Number;
                estadoTipoProducto:{  
                   idEstadoTipoProducto:Number;
                   estado:String;
                   tipoProductos:[  
                    {
                    }
                   ];
                   inicio:Number;
                   cuantos:Number;
                };
                nombre:String;
                productos:[  
                    {
                    }
                ];
                inicio:Number;
                cuantos:Number;
             };
             nombreProducto:String;
             fechaSalida:Date;
             fechaLlegada:Date;
             campannas:[  
                {
                }
             ];
             detalleOrdenCompras:[  
                {
                }
             ];
             imagenProductos:[  
                {
                }
             ];
             auditoriaVentases:[  
                {
                }
             ];
             inicio:Number;
             cuantos:Number;
          };
          valor:Number;
          inicio:Number;
          cuantos:Number;
       }
    ];
    inicio:Number;
    cuantos:Number;
 }

 export class Orden2 {
    fechaCreacion: Date;
    noOrden: Number;
    valorTotal: Number;
    fechaVencimiento: Date;
    detalleOrdenCompras: [{
        valor: Number;
        producto: {
            tipoProducto: {
                nombre: String;
                idTipoProducto: Number;
            };
            idProducto: Number;
            fechaLlegada: Date;
            nombreProducto: String;
            imagenProductos: [{
                imagen: String;
                esprincipal: Number;
                idImagenProducto: Number;
            }, {
                imagen: String;
                esprincipal: Number;
                idImagenProducto: Number;
            }, {
                imagen: String;
                esprincipal: Number;
                idImagenProducto: Number;
            }];
            fechaSalida: Date;
        };
        idDetalleOrden: Number;
    }, {
        valor: Number;
        producto: {
            tipoProducto: {
                nombre: String;
                idTipoProducto: Number;
            };
            idProducto: Number;
            fechaLlegada: Date;
            nombreProducto: String;
            imagenProductos: [{
                imagen: String;
                esprincipal: Number;
                idImagenProducto: Number;
            }, {
                imagen: String;
                esprincipal: Number;
                idImagenProducto: Number;
            }, {
                imagen: String;
                esprincipal: Number;
                idImagenProducto: Number;
            }];
            fechaSalida: Date
        };
        idDetalleOrden: Number;
    }, {
        valor: Number;
        producto: {
            tipoProducto: {
                nombre: String;
                idTipoProducto: Number;
            };
            idProducto: Number;
            fechaLlegada: Date;
            nombreProducto: String;
            imagenProductos: [{
                imagen: String;
                esprincipal: Number;
                idImagenProducto: Number;
            }, {
                imagen: String;
                esprincipal: Number;
                idImagenProducto: Number;
            }, {
                imagen: String;
                esprincipal: Number;
                idImagenProducto: Number;
            }];
            fechaSalida: Date;
        };
        idDetalleOrden: Number;
    }];
    estadoOrdenCompra: {
        idEstadoOrdenCompra: Number;
        estado: String;
    };
    numeroSolicitud: Number;
}