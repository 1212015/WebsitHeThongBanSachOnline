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
    
    public partial class Discount
    {
        [System.Diagnostics.CodeAnalysis.SuppressMessage("Microsoft.Usage", "CA2214:DoNotCallOverridableMethodsInConstructors")]
        public Discount()
        {
            this.Orders = new HashSet<Order>();
        }
    
        public int ID_Discounts { get; set; }
        public int UserCategoryID { get; set; }
        public double Discount1 { get; set; }
        public System.DateTime DateAdded { get; set; }
        public System.DateTime DateUpdated { get; set; }
    
        public virtual UserCategory UserCategory { get; set; }
        [System.Diagnostics.CodeAnalysis.SuppressMessage("Microsoft.Usage", "CA2227:CollectionPropertiesShouldBeReadOnly")]
        public virtual ICollection<Order> Orders { get; set; }
    }
}
