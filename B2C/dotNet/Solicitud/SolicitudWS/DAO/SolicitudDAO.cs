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
                solicitud.fechacreacion = DateTime.Now;
                solicitud.numerosolicitud = 0;
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

        public ResponseData ProductoUsuario(string producto, string usuario)
        {
            ResponseData respuesta = new ResponseData();
            if (producto!= "" && usuario != "")
            {
                try
                {
                    string consulta = "insert into productoscliente(idproducto,idusuario) values(" + producto + "," + usuario + ")";
                    this.context.productoscliente.SqlQuery(consulta).ToList();

                    respuesta.mensaje = "datos insertados";
                    respuesta.resultado = "OK";
                }
                catch (Exception ex)
                {
                    respuesta.mensaje = "Ocurrio un error interno";
                    respuesta.resultado = "Fallo";
                }
            }
            else
            {
                respuesta.mensaje = "Llegaron datos nulos";
                respuesta.resultado = "Fallo";
            }
            return respuesta;
        }

        public ResponseData ProductoUsuarioUpdate(string usuario, string orden)
        {
            ResponseData respuesta = new ResponseData();
            if (orden != "" && usuario != "")
            {
                try
                {
                    string consulta = "update productoscliente " +
                    " set idorden = " + orden +
                    " where idusuario = " + usuario;
                    this.context.productoscliente.SqlQuery(consulta).ToList();

                    respuesta.mensaje = "datos actualizados";
                    respuesta.resultado = "OK";
                }
                catch (Exception ex)
                {
                    respuesta.mensaje = "Ocurrio un error interno";
                    respuesta.resultado = "Fallo";
                }
            }
            else
            {
                respuesta.mensaje = "Llegaron datos nulos";
                respuesta.resultado = "Fallo";
            }
            return respuesta;
        }

        public void ProductoUsuarioDelete(int id)
        {
            var consulta = (from sol in this.context.productoscliente
                            where sol.id == id
                            select sol).First();
            this.context.productoscliente.Remove(consulta);
            this.context.SaveChanges();
        }

        public ResponseData ProductoUsuarioGet(string usuario)
        {
            ResponseData respuesta = new ResponseData();
            if (usuario != "")
            {
                try
                {
                    List<productoscliente> items = new List<productoscliente>();
                    string consulta = "select * from productoscliente " +
                    " where idusuario = " + usuario+
                    " and idorden is null";
                    items = this.context.productoscliente.SqlQuery(consulta).ToList();

                    respuesta.objeto = items;
                    respuesta.mensaje = "datos encontrados";
                    respuesta.resultado = "OK";
                }
                catch (Exception ex)
                {
                    respuesta.mensaje = "Ocurrio un error interno";
                    respuesta.resultado = "Fallo";
                }
            }
            else
            {
                respuesta.mensaje = "Llegaron datos nulos";
                respuesta.resultado = "Fallo";
            }
            return respuesta;
        }

        public ResponseData listarSolicitudesPorUsuario(string idUsuario)
        {
            ResponseData respuesta = new ResponseData();
            List<SOLICITUD> listadoSolicitudes = new List<SOLICITUD>();
            try
            {
                listadoSolicitudes = (from sol in this.context.SOLICITUD
                                      where sol.idusuario == Int32.Parse(idUsuario)
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

        
        public ResponseData lconsultarSolicitudPorId(string idSolicitud)
        {
            ResponseData respuesta = new ResponseData();
            List<SOLICITUD> listadoSolicitudes = new List<SOLICITUD>();
            try
            {
                listadoSolicitudes = (from sol in this.context.SOLICITUD
                                      where sol.numerosolicitud == Int32.Parse(idSolicitud)
                                      select sol).ToList();

                listadoSolicitudes = this.context.SOLICITUD.ToList();
                respuesta.mensaje = "Solicitudes consultada con exito";
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
                            where sol.numerosolicitud == Int32.Parse(idSolicitud)
                            select sol).First();
            this.context.SaveChanges();
        }
    }
}