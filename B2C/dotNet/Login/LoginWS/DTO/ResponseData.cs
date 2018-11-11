using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.Serialization;
using System.Web;

namespace LoginWS.DTO
{
    [DataContract]

    public class ResponseData
    {
        [DataMember]
        public String resultado { get; set; }
        [DataMember]
        public String mensaje { get; set; }
        [DataMember]
        public List<usuarios> objeto { get; set; }
    }
}