using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.Serialization;
using System.Web;

namespace LoginWS.DTO
{
    [DataContract]
    public class RequestData
    {
        [DataMember]
        public string detalles { get; set; }
    }
}