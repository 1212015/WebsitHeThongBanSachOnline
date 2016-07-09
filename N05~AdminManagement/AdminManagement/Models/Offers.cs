using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace AdminManagement.Models
{
    public class Offers
    {
        public int ID_Offers { get; set; }
        public string NameOffer { get; set; }
        public DateTime StartDate { get; set; }
        public DateTime EndDate { get; set; }
        public DateTime DateAddedOffer { get; set; }
        public DateTime DateUpdatedOffer { get; set; }
        public int ID_OfferDetails { get; set; }
        public int ProductID { get; set; }
        public string ProductName { get; set; }
        public double Discount { get; set; }
        public int UserCategoryID { get; set; }
        public string UserCategoryName { get; set; }
        public DateTime DateAddedOfferDetail { get; set; }
        public DateTime DateUpdatedOfferDetail { get; set; }
        public int StatusID { get; set; }
        public string StatusName { get; set; }
    }
}