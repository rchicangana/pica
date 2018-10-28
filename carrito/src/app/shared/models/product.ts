/*export class Product {
  $key: string;
  productId: number;
  productName: string;
  productCategory: string;
  productPrice: number;
  productDescription: string;
  productImageUrl: string;
  productAdded: number;
  productQuatity: number;
  ratings: number;
  favourite: boolean;
  productSeller: string;
  /*constructor(jsonStr: string) {
    let jsonObj: any = JSON.parse(jsonStr);
    for (let prop in jsonObj) {
        this[prop] = jsonObj[prop];
    }
  }*/
//}

export class Product{
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

export class Top5{  
  cantidad:Number;
  idProducto:Number;
  nombre:String;
  imagen:String;
}