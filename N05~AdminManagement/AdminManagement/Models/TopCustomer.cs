using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace AdminManagement.Models
{
    public class TopCustomer
    {
        public int ID_USer { get; set; }
        public string FirstName { get; set; }
        public string LastName { get; set; }
        public string Category { get; set; }
        public int Count { get; set; }
        public int Total { get; set; }
    }
}