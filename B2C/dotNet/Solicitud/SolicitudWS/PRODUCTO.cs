//------------------------------------------------------------------------------
// <auto-generated>
//    Este código se generó a partir de una plantilla.
//
//    Los cambios manuales en este archivo pueden causar un comportamiento inesperado de la aplicación.
//    Los cambios manuales en este archivo se sobrescribirán si se regenera el código.
// </auto-generated>
//------------------------------------------------------------------------------

namespace SolicitudWS
{
    using System;
    using System.Collections.Generic;
    
    public partial class PRODUCTO
    {
        public PRODUCTO()
        {
            this.DETALLESOLICITUD = new HashSet<DETALLESOLICITUD>();
        }
    
        public int Idproducto { get; set; }
        public int tipoproductoid { get; set; }
        public string nombreproducto { get; set; }
        public System.DateTime fechasalida { get; set; }
        public System.DateTime fechallegada { get; set; }
        public Nullable<int> imagenproductos { get; set; }
    
        public virtual ICollection<DETALLESOLICITUD> DETALLESOLICITUD { get; set; }
        public virtual IMAGENPRODUCTO IMAGENPRODUCTO { get; set; }
        public virtual TIPOPRODUCTO TIPOPRODUCTO { get; set; }
    }
}
