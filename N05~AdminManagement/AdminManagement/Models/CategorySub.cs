using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace AdminManagement.Models
{
    public class CategorySub
    {
        public int ID { get; set; }
        public string Name { get; set; }
        public string RName { get; set; }
        public string Image { get; set; }
        public DateTime DateAdded { get; set; }
        public DateTime DateUpdated { get; set; }
    }
}