export class Solicitud{
  descripcion: String;
   fechaLlegada: Date;
   fechaSalida: Date;
   idProducto: number;
   idTipoProducto:{  
      idEstadoTipoProducto:{  
         estado: string;
         idEstadoTipoProducto:number
      };
      idTipoProducto:number;
      nombre:string;
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
           nombre: string
        };
        nombre: string;
     };
     idHospedaje:{  
        estrellas: number;
        habitacionList:[  
           {  
              idHabitacion: number;
              idHospedaje: number;
              idTipoHabitacion:{  
                 idTipoHabitacion: number;
                 tipo:string;
              };
              imagenHabitacionList:[  
                 {  
                    esprincipal: number;
                    idHabitacion: number;
                    idImagenHabitacion: number;
                    imagen: string;
                 }
              ];
              numero: number;
           }
        ];
        idCiudad:{  
           idCiudad: number;
           idPais:{  
              idPais: number;
              nombre: string;
           };
           nombre: string;
        };
        idHospedaje: number;
        imagenHospedajeList:[  
           {  
              esprincipal: number;
              idHospedaje: number;
              idImagenHospedaje: number;
              imagen: string;
           }
        ];
        nombre: string;
     };
     idItinerario: number;
     idProducto: number;
    }
  ];  
  nombreProducto: string;
}