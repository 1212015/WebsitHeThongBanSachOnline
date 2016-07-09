using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace AdminManagement.Models
{
    public class Orders
    {
        public int OrderID { get; set; }
        public string ShipName { get; set; }
        public string ShipAddress { get; set; }
        public string ShipPhone { get; set; }
        public DateTime ShipDate { get; set; }
        public int ProductID { get; set; }
        public int Quantity { get; set; }
        public int Price { get; set; }
        public int UserID { get; set; }
        public int Status { get; set; }
        public string Name { get; set; }
        public int DiscountID { get; set; }
        public DateTime DateAdded { get; set; }
        public DateTime DateUpdated { get; set; }
        public double Discount { get; set; }
        public string ProductName { get; set; }
        public string ShortDetail{ get; set; }
        public string Detail { get; set; }
        public DateTime Year { get; set; }
        public string Size { get; set; }
        public string Company { get; set; }
    }
}