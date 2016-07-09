using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace AdminManagement.Models
{
    public class Discounts
    {
        public int ID_Discounts { get; set; }
        public int UserCategoryID { get; set; }
        public string UserCategoryName { get; set; }
        public double Discount { get; set; }
        public int MinPoint { get; set; }
        public DateTime DateAdded { get; set; }
        public DateTime DateUpdated { get; set; }
    }
}