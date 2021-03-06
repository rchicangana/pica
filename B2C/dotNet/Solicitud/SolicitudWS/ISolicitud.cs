﻿using SolicitudWS.DTO;
using System;
using System.Collections.Generic;
using System.Runtime.Serialization;
using System.Linq;
using System.Web;
using System.ServiceModel;
using System.ServiceModel.Channels;
using System.ServiceModel.Web;
using System.Text;

namespace SolicitudWS
{
    [ServiceContract]
    public interface ISolicitud
    {
        [OperationContract]
        [WebInvoke(Method = "GET",
            RequestFormat = WebMessageFormat.Json,
            ResponseFormat = WebMessageFormat.Json,
            BodyStyle = WebMessageBodyStyle.Wrapped,
            UriTemplate = "buscarUsuario/{idUsuario}")]
        ResponseData ListarSolicitudesPorUsuario(string idUsuario);

        [OperationContract]
        [WebInvoke(Method = "GET",
            RequestFormat = WebMessageFormat.Json,
            ResponseFormat = WebMessageFormat.Json,
            BodyStyle = WebMessageBodyStyle.Wrapped,
            UriTemplate = "buscarId/{idSolicitud}")]
        ResponseData consultarSolicitudPorId(string idSolicitud);

        [OperationContract]
        [WebInvoke(Method = "GET",
            RequestFormat = WebMessageFormat.Json,
            ResponseFormat = WebMessageFormat.Json,
            BodyStyle = WebMessageBodyStyle.Wrapped,
            UriTemplate = "cancelar/{idSolicitud}")]
        void CancelarSolicitud(string idSolicitud);    
        [OperationContract]
        [WebInvoke(Method = "POST",
            RequestFormat = WebMessageFormat.Json,
            ResponseFormat = WebMessageFormat.Json,
            BodyStyle = WebMessageBodyStyle.Bare,
            UriTemplate = "crear")]
        ResponseData CrearSolicitud(SOLICITUD solicitud);
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