using SolicitudWS.DTO;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace SolicitudWS.DAO
{
    public class SolicitudDAO
    {
        private touresbalonEntities2 context = new touresbalonEntities2();

        public ResponseData crearSolicitud(SOLICITUD solicitud)
        {
            ResponseData respuesta = new ResponseData();
            if (solicitud != null)
            {
                solicitud.FECHA_CREACION = DateTime.Now;
                solicitud.ID_ESTADO_SOLICITUD = 1;
                solicitud.NO_SOLICITUD = null;
                this.context.SOLICITUD.Add(solicitud);
                this.context.SaveChanges();
                respuesta.mensaje = "Solicitud creada con exito";
                respuesta.resultado = "OK";
            }
            else
            {
                respuesta.mensaje = "Llegaron datos nulos";
                respuesta.resultado = "Fallo";
            }
            return respuesta;
        }

        public ResponseData listarSolicitudes(string idSolicitud)
        {
            ResponseData respuesta = new ResponseData();
            List<SOLICITUD> listadoSolicitudes = new List<SOLICITUD>();
            try
            {
                listadoSolicitudes = (from sol in this.context.SOLICITUD
                                      where sol.NO_SOLICITUD == Int32.Parse(idSolicitud)
                                select sol).ToList();

                listadoSolicitudes = this.context.SOLICITUD.ToList();
                respuesta.mensaje = "Solicitudes consultadas";
                respuesta.resultado = "OK";
                respuesta.objeto = listadoSolicitudes;
            }
            catch (Exception ex)
            {
            }
            return respuesta;
        }

        public void cancelarSolicitud(string idSolicitud)
        {
            var consulta = (from sol in this.context.SOLICITUD
                            where sol.NO_SOLICITUD == Int32.Parse(idSolicitud)
                            select sol).First();
            consulta.ID_ESTADO_SOLICITUD = 2;
            this.context.SaveChanges();
        }
    }
}