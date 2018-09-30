using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.Serialization;
using System.Web;

namespace LoginWS.DTO
{
    [DataContract]
    public class Product
    {
        [DataMember]
          public string key { get; set; }
        [DataMember]  
        public int productId { get; set; }
        [DataMember]  
        public string productName { get; set; }
        [DataMember]  
        public string productCategory { get; set; }
        [DataMember]  
        public int productPrice { get; set; }
        [DataMember]  
        public string productDescription { get; set; }
        [DataMember]  
        public string productImageUrl { get; set; }
        [DataMember]  
        public int productAdded { get; set; }
        [DataMember]  
        public int productQuatity { get; set; }
        [DataMember]  
        public int ratings { get; set; }
        [DataMember]  
        public bool favourite { get; set; }
        [DataMember]  
        public string productSeller { get; set; }
    }
}