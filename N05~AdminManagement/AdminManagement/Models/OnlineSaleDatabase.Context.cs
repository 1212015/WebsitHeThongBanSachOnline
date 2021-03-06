﻿//------------------------------------------------------------------------------
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
    using System.Data.Entity;
    using System.Data.Entity.Infrastructure;
    
    public partial class OnlineSaleEntities : DbContext
    {
        public OnlineSaleEntities()
            : base("name=OnlineSaleEntities")
        {
        }
    
        protected override void OnModelCreating(DbModelBuilder modelBuilder)
        {
            throw new UnintentionalCodeFirstException();
        }
    
        public virtual DbSet<Department> Departments { get; set; }
        public virtual DbSet<Discount> Discounts { get; set; }
        public virtual DbSet<Employee> Employees { get; set; }
        public virtual DbSet<Grade> Grades { get; set; }
        public virtual DbSet<OfferDetail> OfferDetails { get; set; }
        public virtual DbSet<Offer> Offers { get; set; }
        public virtual DbSet<OfferStatus> OfferStatuses { get; set; }
        public virtual DbSet<OrderDetail> OrderDetails { get; set; }
        public virtual DbSet<Order> Orders { get; set; }
        public virtual DbSet<OrderStatus> OrderStatuses { get; set; }
        public virtual DbSet<PaymentMethod> PaymentMethods { get; set; }
        public virtual DbSet<Payment> Payments { get; set; }
        public virtual DbSet<PaymentStatus> PaymentStatuses { get; set; }
        public virtual DbSet<ProductCategoriesRoot> ProductCategoriesRoots { get; set; }
        public virtual DbSet<ProductCategoriesSub> ProductCategoriesSubs { get; set; }
        public virtual DbSet<Product> Products { get; set; }
        public virtual DbSet<ProductStatus> ProductStatuses { get; set; }
        public virtual DbSet<UserCategory> UserCategories { get; set; }
        public virtual DbSet<User> Users { get; set; }
        public virtual DbSet<UserStatus> UserStatuses { get; set; }
        public virtual DbSet<Topic> Topics { get; set; }
        public virtual DbSet<TopicDetail> TopicDetails { get; set; }
        public virtual DbSet<TopicStatus> TopicStatuses { get; set; }
        public virtual DbSet<BookShelf> BookShelves { get; set; }
        public virtual DbSet<ClassifyOwn> ClassifyOwns { get; set; }
        public virtual DbSet<ClassifyOwnDetail> ClassifyOwnDetails { get; set; }
        public virtual DbSet<Comment> Comments { get; set; }
        public virtual DbSet<Card> Cards { get; set; }
        public virtual DbSet<Cash> Cashes { get; set; }
    }
}
