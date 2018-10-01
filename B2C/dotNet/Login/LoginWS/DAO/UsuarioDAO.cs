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

        public ResponseData listarUsuarios()
        {
            ResponseData respuesta = new ResponseData();
            List<usuarios> listadoUsuarios = new List<usuarios>();
            try {
                listadoUsuarios = this.context.usuarios.ToList();
                respuesta.mensaje = "Usuarios consultados";
                respuesta.resultado = "OK";
                respuesta.objeto = listadoUsuarios;
            }
            catch(Exception ex){
            }
            return respuesta;
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

        public usuarios buscarUsuario(String loginUsuario, string password)
        {
            usuarios usuario = new usuarios();
            try
            {
                var consulta = (from usu in this.context.usuarios
                                where usu.login == loginUsuario && usu.password == password 
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

        public List<Product> productos()
        {
            ResponseData respuesta = new ResponseData();
            List<Product> productos = new List<Product>();
            Product producto = new Product();
            Product producto2 = new Product();

            producto.key = "1";
            producto.productId = 1;
            producto.productName = "mundial";
            producto.productCategory = "futbol";
            producto.productDescription = "Mundial de futbol en Rusia";
            producto.productPrice = 2650;
            producto.productImageUrl = "habitacion.jpg";
            producto.productQuatity = 0;
            producto.productSeller = "Touresbalon";
            producto.ratings = 0;
            producto.productAdded = 0;
            //char quote = '"';
            respuesta.objeto = producto;
            respuesta.mensaje = "Test";
            respuesta.resultado = "OK";
            productos.Add(producto);

            producto2.key = "2";
            producto2.productId = 2;
            producto2.productName = "mundial";
            producto2.productCategory = "hotel";
            producto2.productDescription = "Mundial de futbol en Rusia";
            producto2.productPrice = 600;
            producto2.productImageUrl = "hospedaje.jpg";
            producto2.productQuatity = 0;
            producto2.productSeller = "Touresbalon";
            producto2.ratings = 0;
            producto2.productAdded = 0;
            productos.Add(producto2);
            //char quote = '"';
            //respuesta.objeto = producto;
            //respuesta.mensaje = "Test";
            //respuesta.resultado = "OK";
            return productos;
            //respuesta.objeto = "{"+quote+"$key" + quote + ":" + quote + "1" + quote + ";" + quote + "productId" + quote + ":" + quote + "1" + quote + ";" + quote + "productName" + quote + ":" + quote + "mundial" + quote + ";"   + quote + "productCategory" + quote + ":"  + quote + "Futbol" + quote + ";"  + quote + "productPrice" + quote + ":"  + quote + "5600" + quote + ";"  + quote + "productDescription" + quote + ":"  + quote + "Mundial de futbol en Rusia" + quote + ";"  + quote + "productImageUrl" + quote + ":"  + quote + "habitacion.jpg" + quote + ";"  + quote + "productAdded" + quote + ":"  + quote + "0" + quote + ";"  + quote + "productQuatity" + quote + ":"  + quote + "0" + quote + ";"  + quote + "ratings" + quote + ":"  + quote + "10" + quote + ";" + quote + "favourite" + quote + ":"  + quote + "false" + quote + ";"  + quote + "productSeller" + quote + ":"  + quote + "turesbalon" + quote + ";}" ;

            //return respuesta;
        }

        public Product productoPorId(string id)
        {
            Product producto = new Product();
            Product producto2 = new Product();

            producto.key = "1";
            producto.productId = 1;
            producto.productName = "mundial";
            producto.productCategory = "futbol";
            producto.productDescription = "Mundial de futbol en Rusia";
            producto.productPrice = 2650;
            producto.productImageUrl = "habitacion.jpg";
            producto.productQuatity = 0;
            producto.productSeller = "Touresbalon";
            producto.ratings = 0;
            producto.productAdded = 0;

            producto2.key = "2";
            producto2.productId = 2;
            producto2.productName = "mundial";
            producto2.productCategory = "hotel";
            producto2.productDescription = "Mundial de futbol en Rusia";
            producto2.productPrice = 600;
            producto2.productImageUrl = "hospedaje.jpg";
            producto2.productQuatity = 0;
            producto2.productSeller = "Touresbalon";
            producto2.ratings = 0;
            producto2.productAdded = 0;

            if (id == "1")
            {
                producto2=producto;
            }

            return producto2;
        }
    }
}