using System;
using SolicitudWS.DAO;
using SolicitudWS.DTO;

namespace SolicitudWS
{
    public class Solicitud : ISolicitud
    {
        private SolicitudDAO solDAO = new SolicitudDAO();
        
        public ResponseData ListarSolicitudesPorUsuario(String idUsuario)
        {
            return this.solDAO.listarSolicitudesPorUsuario(idUsuario);
        }

        public ResponseData consultarSolicitudPorId(String idSolicitud) {
            return this.solDAO.lconsultarSolicitudPorId(idSolicitud);
        }

        public void CancelarSolicitud(String idSolicitud)
        {
            this.solDAO.cancelarSolicitud(idSolicitud);
        }
        
        public ResponseData CrearSolicitud(SOLICITUD solicitud)
        {
            solicitud.fechacreacion = DateTime.Now;
            ESTADOSOLICITUD estadoOrden = new ESTADOSOLICITUD();
            estadoOrden.estado = "ABIERTA";
            solicitud.ESTADOSOLICITUD = estadoOrden;
            return this.solDAO.crearSolicitud(solicitud); ;
        }
    }
}
