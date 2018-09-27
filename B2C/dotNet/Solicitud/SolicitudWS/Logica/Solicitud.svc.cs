using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.Serialization;
using System.ServiceModel;
using System.ServiceModel.Web;
using System.Text;
using SolicitudWS.DAO;
using SolicitudWS.DTO;

namespace SolicitudWS
{
    // NOTA: puede usar el comando "Rename" del menú "Refactorizar" para cambiar el nombre de clase "IUsuario" en el código, en svc y en el archivo de configuración.
    // NOTE: para iniciar el Cliente de prueba WCF para probar este servicio, seleccione Usuario.svc o Usuario.svc.cs en el Explorador de soluciones e inicie la depuración.
    public class Solicitud : ISolicitud
    {
        SolicitudDAO solDAO = new SolicitudDAO();

        public ResponseData listarSolicitudes(int idUsuario)
        {
            return this.solDAO.listarSolicitudes(idUsuario);
        }

        public void cancelarSolicitud(int idSolicitud)
        {
            this.solDAO.cancelarSolicitud(idSolicitud);
        }

        public ResponseData crearUsuario(SOLICITUD solicitud)
        {
            //JObject json = JObject.Parse(usuario);
            //usuarios user = JsonConvert.DeserializeObject<usuarios>(usuario);
            solicitud.FECHA_CREACION = DateTime.Today;
            solicitud.ID_ESTADO_SOLICITUD = 1;
            return this.solDAO.crearSolicitud(solicitud); ;
        }
    }
}
