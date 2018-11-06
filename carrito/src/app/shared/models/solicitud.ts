export class Solicitud{
  descripcion: String;
   fechaLlegada: Date;
   fechaSalida: Date;
   idProducto: number;
   idTipoProducto:{  
      idEstadoTipoProducto:{  
         estado: String;
         idEstadoTipoProducto:number
      };
      idTipoProducto:number;
      nombre:String;
   };
   imagenProductoList:[  
    {  
       esprincipal:Number;
       idImagenProducto:Number;
       idProducto:Number;
       imagen: String;
    }
   ];
   itinerarioList:[  
    {  
      idCiudad:{  
        idCiudad: number;
        idPais:{  
           idPais: number;
           nombre: String
        };
        nombre: String;
     };
     idHospedaje:{  
        estrellas: number;
        habitacionList:[  
           {  
              idHabitacion: number;
              idHospedaje: number;
              idTipoHabitacion:{  
                 idTipoHabitacion: number;
                 tipo:String;
              };
              imagenHabitacionList:[  
                 {  
                    esprincipal: number;
                    idHabitacion: number;
                    idImagenHabitacion: number;
                    imagen: String;
                 }
              ];
              numero: number;
           }
        ];
        idCiudad:{  
           idCiudad: number;
           idPais:{  
              idPais: number;
              nombre: String;
           };
           nombre: String;
        };
        idHospedaje: number;
        imagenHospedajeList:[  
           {  
              esprincipal: number;
              idHospedaje: number;
              idImagenHospedaje: number;
              imagen: String;
           }
        ];
        nombre: String;
     };
     idItinerario: number;
     idProducto: number;
    }
  ];  
  nombreProducto: String;
}