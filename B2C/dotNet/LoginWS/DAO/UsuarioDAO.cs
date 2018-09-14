using LoginWS.DTO;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace LoginWS.DAO
{
    public class UsuarioDAO
    {
        private touresbalonEntities2 context = new touresbalonEntities2();

        public List<usuarios> listarUsuarios() {
            List<usuarios> listadoUsuarios = new List<usuarios>();
            try {
                listadoUsuarios = this.context.usuarios.ToList();
            }
            catch(Exception ex){
            }
            return listadoUsuarios;
        }

        public ResponseData crearUsuario(usuarios usuario)
        {
            ResponseData respuesta = new ResponseData();
            //ContextoUsuario context = new ContextoUsuario();
            if(usuario != null){
                usuario.fecha_creacion = DateTime.Now;
                usuario.activo = true;
                usuario.id = null;
                this.context.usuarios.Add(usuario);
                this.context.SaveChanges();
                respuesta.mensaje = "Usuario creado con exito";
                respuesta.resultado = "OK";
            }
            else{
                respuesta.mensaje = "Llegaron datos nulos";
                respuesta.resultado = "Fallo";
            }
            return respuesta;
        }

        public void actualizarUsuario(usuarios usuario) { 
            var consulta = (from usu in this.context.usuarios
                            where usu.id == usuario.id
                            select usu).First();
            consulta.nombres = usuario.nombres;
            consulta.apellidos = usuario.apellidos;
            consulta.login = usuario.login;
            consulta.password = usuario.password;
            this.context.SaveChanges();
        }

        public usuarios buscarUsuario(String loginUsuario)
        {
            usuarios usuario = new usuarios();
            try
            {
                var consulta = (from usu in this.context.usuarios
                                where usu.login == loginUsuario
                                select usu).First();
                usuario = consulta;
            }catch(Exception ex){
            
            }
            return usuario;
        }

        public void borrarUsuario(int id){
            var consulta = (from usu in this.context.usuarios
                            where usu.id == id
                            select usu).First();
            this.context.usuarios.Remove(consulta);
            this.context.SaveChanges();
        }
    }
}