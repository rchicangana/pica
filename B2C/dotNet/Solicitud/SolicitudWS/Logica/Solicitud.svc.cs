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

        public void CancelarSolicitud(String idSolicitud)
        {
            this.solDAO.cancelarSolicitud(idSolicitud);
        }
        
        public ResponseData CrearSolicitud(SOLICITUD solicitud)
        {
            solicitud.fechacreacion = DateTime.Now;
            ESTADOSOLICITUD estadoOrden = new ESTADOSOLICITUD();
            estadoOrden.Idestadoordencompra = 0;
            estadoOrden.estado = "ABIERTA";
            solicitud.estadoordencompraid = estadoOrden.Idestadoordencompra;
            return this.solDAO.crearSolicitud(solicitud); ;
        }
    }
}
