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
    
    public partial class OfferStatus
    {
        [System.Diagnostics.CodeAnalysis.SuppressMessage("Microsoft.Usage", "CA2214:DoNotCallOverridableMethodsInConstructors")]
        public OfferStatus()
        {
            this.Offers = new HashSet<Offer>();
        }
    
        public int ID_OfferStatuses { get; set; }
        public string Name { get; set; }
        public System.DateTime DateAdded { get; set; }
        public System.DateTime DateUpdated { get; set; }
    
        [System.Diagnostics.CodeAnalysis.SuppressMessage("Microsoft.Usage", "CA2227:CollectionPropertiesShouldBeReadOnly")]
        public virtual ICollection<Offer> Offers { get; set; }
    }
}
