using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;

namespace SolicitudTest
{
    [TestClass]
    public class PruebaUnitaria
    {
        [TestMethod]
        public void TestCrearSolicitud()
        {
            SolicitudWS.SOLICITUD solicitud = new SolicitudWS.SOLICITUD();
            SolicitudWS.usuarios users = new SolicitudWS.usuarios();
            SolicitudWS.DETALLESOLICITUD detalle = new SolicitudWS.DETALLESOLICITUD();

            detalle.valor = "2500000";
            detalle.productoid = 1;

            users.activo = true;
            users.id = 1;
            users.nombres = "pepito";
            users.apellidos = "perez";
            users.ciudad = "BOGOTA";
            users.pais = "COLOMBIA";
            users.login = "johnefe84@gmail.com";
            users.password = "12345678";

            solicitud.idusuario = 1;
            solicitud.noorden = "1";
            solicitud.valortotal = 540000;
            solicitud.usuarios = users;
            solicitud.fechavencimiento = new DateTime();
            solicitud.numerosolicitud = 1;
            solicitud.DETALLESOLICITUD = detalle;

            SolicitudWS.Solicitud claseSolicitud = new SolicitudWS.Solicitud();
            SolicitudWS.DTO.ResponseData respuesta = new SolicitudWS.DTO.ResponseData(); 
            respuesta = claseSolicitud.CrearSolicitud(solicitud);

            Assert.AreEqual(respuesta.resultado, "OK");
        }
    }
}
