using System;
using SolicitudWS.DAO;
using SolicitudWS.DTO;

namespace SolicitudWS
{
    public class Solicitud : ISolicitud
    {
        private SolicitudDAO solDAO = new SolicitudDAO();

        public ResponseData ListarSolicitudes(String idSolicitud)
        {
            return this.solDAO.listarSolicitudes(idSolicitud);
        }

        public void CancelarSolicitud(String idSolicitud)
        {
            this.solDAO.cancelarSolicitud(idSolicitud);
        }

        public ResponseData CrearSolicitud(SOLICITUD solicitud)
        {
            solicitud.fechaCreacion = DateTime.Today.ToString();
            SOLICITUD.EstadoOrdenCompra estadoOrden = new SOLICITUD.EstadoOrdenCompra();
            estadoOrden.idEstadoOrdenCompra = 0;
            estadoOrden.estado = "ABIERTA";
            solicitud.estadoOrdenCompra = estadoOrden;
            return this.solDAO.crearSolicitud(solicitud); ;
        }
    }
}
