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
            return this.solDAO.crearSolicitud(solicitud);
        }

        public ResponseData ProductoUsuario(string producto, string usuario)
        {
            return this.solDAO.ProductoUsuario(producto, usuario);   
        }

        public ResponseData ProductoUsuarioUpdate(string usuario, string orden)
        {
            return this.solDAO.ProductoUsuarioUpdate(usuario, orden);
        }

        public ResponseData ProductoUsuarioGet(string usuario)
        {
            return this.solDAO.ProductoUsuarioGet(usuario);
        }
    }
}
