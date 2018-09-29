using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.Serialization;
using System.ServiceModel;
using System.ServiceModel.Web;
using System.Text;
using LoginWS.DAO;
using LoginWS.DTO;

namespace LoginWS
{
    // NOTA: puede usar el comando "Rename" del menú "Refactorizar" para cambiar el nombre de clase "IUsuario" en el código, en svc y en el archivo de configuración.
    // NOTE: para iniciar el Cliente de prueba WCF para probar este servicio, seleccione Usuario.svc o Usuario.svc.cs en el Explorador de soluciones e inicie la depuración.
    public class Usuario : IUsuario
    {
        UsuarioDAO usuDAO = new UsuarioDAO();

        public List<usuarios> listarUsuarios()
        {   
           return this.usuDAO.listarUsuarios();
        }

        public usuarios buscarUsuarioPorLogin(string login)
        {
            return this.usuDAO.buscarUsuario(login);
        }

        public string getUsuarioByLoginPOST(string login)
        {
            string chiste = "{   el login fue: '" + login + "'}";
            return chiste;
        }

        public ResponseData crearUsuario(usuarios usuario)
        {
            //JObject json = JObject.Parse(usuario);
            //usuarios user = JsonConvert.DeserializeObject<usuarios>(usuario);
            return this.usuDAO.crearUsuario(usuario); ;
        }
    }
}
