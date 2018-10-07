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
            BodyStyle = WebMessageBodyStyle.Wrapped, 
            UriTemplate = "usuarios")]
        ResponseData listarUsuarios();

        [OperationContract]
        [WebInvoke(Method = "GET",
            RequestFormat = WebMessageFormat.Json,
            ResponseFormat = WebMessageFormat.Json, 
            BodyStyle = WebMessageBodyStyle.Wrapped, 
            UriTemplate = "consultausuario/{login}/{password}")]
        usuarios buscarUsuarioPorLogin(string login, string password);
        
        [OperationContract]
        [WebInvoke(Method = "POST",
            RequestFormat = WebMessageFormat.Json,
            ResponseFormat = WebMessageFormat.Json,
            BodyStyle = WebMessageBodyStyle.Bare, 
            UriTemplate = "crearusuario")]
        ResponseData crearUsuario(usuarios usuario);
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
