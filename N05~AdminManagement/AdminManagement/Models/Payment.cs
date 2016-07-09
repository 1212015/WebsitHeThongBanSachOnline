//------------------------------------------------------------------------------
// <auto-generated>
//     This code was generated from a template.
//
//     Manual changes to this file may cause unexpected behavior in your application.
//     Manual changes to this file will be overwritten if the code is regenerated.
// </auto-generated>
//------------------------------------------------------------------------------

namespace AdminManagement.Models
{
    using System;
    using System.Collections.Generic;
    
    public partial class Payment
    {
        public int ID_Payments { get; set; }
        public int OrderID { get; set; }
        public int PaymentMethodID { get; set; }
        public int Status { get; set; }
        public System.DateTime DateAdded { get; set; }
        public System.DateTime DateUpdated { get; set; }
    
        public virtual Order Order { get; set; }
        public virtual PaymentMethod PaymentMethod { get; set; }
        public virtual PaymentStatus PaymentStatus { get; set; }
        public virtual Card Card { get; set; }
        public virtual Cash Cash { get; set; }
    }
}