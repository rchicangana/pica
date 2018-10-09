using System;
using SolicitudWS.DAO;
using SolicitudWS.DTO;

namespace SolicitudWS
{
    public class Solicitud : ISolicitud
    {
        private SolicitudDAO solDAO = new SolicitudDAO();

        public ResponseData ListarSolicitudes(int idSolicitud)
        {
            return this.solDAO.listarSolicitudes(idSolicitud);
        }

        public void CancelarSolicitud(int idSolicitud)
        {
            this.solDAO.cancelarSolicitud(idSolicitud);
        }

        public ResponseData CrearSolicitud(SOLICITUD solicitud)
        {
            solicitud.FECHA_CREACION = DateTime.Today;
            solicitud.ID_ESTADO_SOLICITUD = 1;
            return this.solDAO.crearSolicitud(solicitud); ;
        }
    }
}
