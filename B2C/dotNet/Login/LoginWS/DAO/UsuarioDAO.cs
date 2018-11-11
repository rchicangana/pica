using LoginWS.DTO;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Data;

namespace LoginWS.DAO
{
    public class UsuarioDAO
    {
        private touresbalonEntities2 context = new touresbalonEntities2();

        public ResponseData listarUsuarios(string desde, string hasta)
        {
            ResponseData respuesta = new ResponseData();
            List<usuarios> listadoUsuarios = new List<usuarios>();
            try {             
                string consulta= "SELECT * FROM ( SELECT    ROW_NUMBER() OVER ( ORDER BY id ) AS RowNum, * "+
                "from usuarios where activo=1) AS tabla "+
                "WHERE   RowNum >=" + desde+" AND RowNum < " + hasta+ " ORDER BY RowNum";
                listadoUsuarios = this.context.usuarios.SqlQuery(consulta).ToList();
                respuesta.mensaje = "Usuarios consultados";
                respuesta.resultado = "OK";
                respuesta.objeto = listadoUsuarios;
            }
            catch(Exception ex){
                respuesta.mensaje = ex.ToString();
                respuesta.resultado = "Fallido";
            }
            return respuesta;
        }

        public ResponseData crearUsuario(usuarios usuario)
        {
            ResponseData respuesta = new ResponseData();
            try
            {
                if (usuario != null)
                {
                    usuario.fecha_creacion = DateTime.Now;
                    usuario.activo = true;
                    usuario.id = null;

                    if (usuario.pais == null)
                    {
                        usuario.pais = "";
                    }
                    if (usuario.departamento == null)
                    {
                        usuario.departamento = "";
                    }
                    if (usuario.ciudad == null)
                    {
                        usuario.ciudad = "";
                    }
                    this.context.usuarios.Add(usuario);
                    this.context.SaveChanges();
                    respuesta.mensaje = "Usuario creado con exito";
                    respuesta.resultado = "OK";
                }
                else
                {
                    respuesta.mensaje = "Llegaron datos nulos";
                    respuesta.resultado = "Fallo";
                }
            }
            catch (Exception ex) { 
                respuesta.mensaje="Ocurrio un error interno";
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

        public ResponseData consulta(string loginUsuario, string password)
        {
            ResponseData respuesta = new ResponseData();
            List<usuarios> usuario = new List<usuarios>();
            try
            {
                string consulta = "SELECT * " +
                "from usuarios where login = '" +loginUsuario+
                "' and password = '"+password+"'";
                usuario = this.context.usuarios.SqlQuery(consulta).ToList();
 
                //usuario = consulta;
                respuesta.objeto = usuario;
                respuesta.mensaje = "Usuario encontrado con exito";
                respuesta.resultado = "OK";
            }catch(Exception ex){
                respuesta.mensaje = "Ocurrio un error interno";
                respuesta.resultado = "Fallo";
            }
            return respuesta;
        }

        public ResponseData consulta2(string loginUsuario, string password)
        {
            ResponseData respuesta = new ResponseData();
            List<usuarios> usuario = new List<usuarios>();
            try
            {
                var consulta = (from usu in this.context.usuarios
                                where usu.login == loginUsuario && usu.password == password
                                select usu).First();
                //usuario = consulta;
                usuario.Add((usuarios)consulta);
                respuesta.objeto = usuario;
                respuesta.mensaje = "Usuario encontrado con exito";
                respuesta.resultado = "OK";
            }
            catch (Exception ex)
            {
                respuesta.mensaje = "Ocurrio un error interno";
                respuesta.resultado = "Fallo";
            }
            return respuesta;
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