using SolicitudWS.DTO;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace SolicitudWS.DAO
{
    public class DetalleSolicitudDAO
    {
        private touresbalonEntities2 context = new touresbalonEntities2();

       /* public ResponseData crearDetalleSolicitud(DETALLE_SOLICITUD dsolicitud)
        {
            ResponseData respuesta = new ResponseData();
            if (dsolicitud != null)
            {
                dsolicitud.ID_DETALLE_SOLICITUD = null;
                this.context.DETALLE_SOLICITUD.Add(dsolicitud);
                this.context.SaveChanges();
                respuesta.mensaje = "Detalle de Solicitud creada con exito";
                respuesta.resultado = "OK";
            }
            else
            {
                respuesta.mensaje = "Llegaron datos nulos";
                respuesta.resultado = "Fallo";
            }
            return respuesta;
        }*/
        /*
        public ResponseData listarDetalleSolicitud(int idSolicitud)
        {
            ResponseData respuesta = new ResponseData();
            List<DETALLE_SOLICITUD> listadoSolicitudes = new List<DETALLE_SOLICITUD>();
            try
            {
                listadoSolicitudes = (from dsol in this.context.DETALLE_SOLICITUD
                                   where dsol.NO_SOLICITUD == idSolicitud
                                   select dsol).ToList();

                listadoSolicitudes = this.context.DETALLE_SOLICITUD.ToList();
                respuesta.mensaje = "Detalle de Solicitud consultada";
                respuesta.resultado = "OK";
                respuesta.objeto = listadoSolicitudes;
            }
            catch (Exception ex)
            {
            }
            return respuesta;
        }*/
    }
}