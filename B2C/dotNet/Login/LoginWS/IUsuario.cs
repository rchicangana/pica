using LoginWS.DTO;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.Serialization;
using System.ServiceModel;
using System.ServiceModel.Channels;
using System.ServiceModel.Web;
using System.Text;

namespace LoginWS
{
    [ServiceContract]
    public interface IUsuario
    {
        [OperationContract]
        [WebInvoke(Method = "GET",
            RequestFormat = WebMessageFormat.Json,
            ResponseFormat = WebMessageFormat.Json, 
            UriTemplate = "usuarios/{desde}/{hasta}")]
        ResponseData listarUsuarios(string desde, string hasta);

        [OperationContract]
        [WebInvoke(Method = "GET",
            RequestFormat = WebMessageFormat.Json,
            ResponseFormat = WebMessageFormat.Json,
            BodyStyle = WebMessageBodyStyle.WrappedRequest,
            UriTemplate = "consulta/{login}/{password}")]
        ResponseData consulta(string login, string password);
        
        [OperationContract]
        [WebInvoke(Method = "POST",
            RequestFormat = WebMessageFormat.Json,
            ResponseFormat = WebMessageFormat.Json,
            BodyStyle = WebMessageBodyStyle.Bare, 
            UriTemplate = "crearusuario")]
        ResponseData crearUsuario(usuarios usuario);

        [OperationContract]
        [WebInvoke(Method = "POST",
            RequestFormat = WebMessageFormat.Json,
            ResponseFormat = WebMessageFormat.Json,
            BodyStyle = WebMessageBodyStyle.Bare,
            UriTemplate = "actualizarusuario")]
        void actualizarUsuario(usuarios usuario);
    }

    public class SampleContentTypeMapper : WebContentTypeMapper
    {
        public override WebContentFormat GetMessageFormatForContentType(string contentType)
        {
            if (string.IsNullOrWhiteSpace(contentType))
                return WebContentFormat.Raw;
            else
                return WebContentFormat.Raw;
        }
    }
}
