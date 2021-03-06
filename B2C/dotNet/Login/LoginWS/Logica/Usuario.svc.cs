﻿using System;
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

        public ResponseData listarUsuarios(string desde, string hasta)
        {   
           return this.usuDAO.listarUsuarios(desde, hasta);
        }

        public ResponseData buscarUsuarioPorLogin(string login, string password)
        {
            return this.usuDAO.consulta2(login, password);
        }

        public ResponseData consulta(string login, string password)
        {
            //byte[] data = Convert.FromBase64String(login);
            //string loginDecode = Encoding.UTF8.GetString(data);
            string loginDecode = login;
            //data = Convert.FromBase64String(password);
            //string passwordDecode = Encoding.UTF8.GetString(data);
            string passwordDecode = password;
            return this.usuDAO.consulta2(loginDecode, passwordDecode);
        }
        public ResponseData crearUsuario(usuarios usuario)
        {
            //JObject json = JObject.Parse(usuario);
            //usuarios user = JsonConvert.DeserializeObject<usuarios>(usuario);
            usuario.fecha_creacion = DateTime.Today;
            usuario.activo = true;
            return this.usuDAO.crearUsuario(usuario);
        }

        public ResponseData actualizarUsuario(usuarios usuario)
        {
            return this.usuDAO.actualizarUsuario(usuario);
        }
     }
}
