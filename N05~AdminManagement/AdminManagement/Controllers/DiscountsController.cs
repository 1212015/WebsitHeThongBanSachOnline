using System;
using System.Collections.Generic;
using System.Data;
using System.Data.Entity;
using System.Linq;
using System.Threading.Tasks;
using System.Net;
using System.Web;
using System.Web.Mvc;
using System.IO;
using AdminManagement.Models;

namespace AdminManagement.Controllers
{
    public class DiscountsController : Controller
    {
        private OnlineSaleEntities db = new OnlineSaleEntities();

        // GET: Discounts
        public ActionResult Index()
        {
            string isLogin = (string)Session["IsLogin"];
            string role = (string)Session["department"];
            if (isLogin != "1")
            {
                return RedirectToAction("Login", "Account", null);
            }
            var result = from D in db.Discounts
                         select new
                         {
                             D.ID_Discounts,
                             D.UserCategoryID,
                             D.UserCategory.Name,
                             D.Discount1,
                             D.UserCategory.MinPoint,
                             D.DateAdded,
                             D.DateUpdated
                         };

            List<Discounts> list = new List<Discounts>();

            foreach (var i in result)
            {
                Discounts temp = new Discounts();
                temp.ID_Discounts = i.ID_Discounts;
                temp.UserCategoryID = i.UserCategoryID;
                temp.UserCategoryName = i.Name;
                temp.Discount = i.Discount1;
                temp.MinPoint = i.MinPoint;
                temp.DateAdded = i.DateAdded;
                temp.DateUpdated = i.DateUpdated;
                list.Add(temp);
            }

            ViewBag.PageLevelName = "QUẢN LÝ TẬP KHÁCH HÀNG GIẢM GIÁ";
            ViewBag.discounts = list;
            return View();
        }

        public ActionResult Create()
        {
            string isLogin = (string)Session["IsLogin"];
            string role = (string)Session["department"];
            if (isLogin != "1" || role != "2")
            {
                return RedirectToAction("Login", "Account", null);
            }
            ViewBag.UserCategoryID = new SelectList(db.UserCategories, "ID_UserCategories", "Name");
            ViewBag.PageLevelName = "QUẢN LÝ TẬP KHÁCH HÀNG GIẢM GIÁ";
            return View();
        }

        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Create([Bind(Include = "ID_Discounts,UserCategoryID,Discount1,DateAdded,DateUpdated")] Discount discount)
        {
            string isLogin = (string)Session["IsLogin"];
            string role = (string)Session["department"];
            if (isLogin != "1" || role != "2")
            {
                return RedirectToAction("Login", "Account", null);
            }
            if (ModelState.IsValid)
            {
                discount.DateAdded = DateTime.Now;
                discount.DateUpdated = DateTime.Now;
                db.Discounts.Add(discount);
                db.SaveChanges();
                return RedirectToAction("Index");
            }

            ViewBag.UserCategoryID = new SelectList(db.UserCategories, "ID_UserCategories", "Name", discount.UserCategoryID);
            ViewBag.PageLevelName = "QUẢN LÝ TẬP KHÁCH HÀNG GIẢM GIÁ";
            return View(discount);
        }

        public ActionResult Edit(int? id)
        {
            string isLogin = (string)Session["IsLogin"];
            string role = (string)Session["department"];
            if (isLogin != "1" || role != "2")
            {
                return RedirectToAction("Login", "Account", null);
            }
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            Discount discount = db.Discounts.Find(id);
            if (discount == null)
            {
                return HttpNotFound();
            }
            ViewBag.UserCategoryID = new SelectList(db.UserCategories, "ID_UserCategories", "Name", discount.UserCategoryID);
            ViewBag.PageLevelName = "QUẢN LÝ TẬP KHÁCH HÀNG GIẢM GIÁ";
            return View(discount);
        }

        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Edit([Bind(Include = "ID_Discounts,UserCategoryID,Discount1,DateAdded,DateUpdated")] Discount discount)
        {
            string isLogin = (string)Session["IsLogin"];
            string role = (string)Session["department"];
            if (isLogin != "1" || role != "2")
            {
                return RedirectToAction("Login", "Account", null);
            }
            if (ModelState.IsValid)
            {
                discount.DateUpdated = DateTime.Now;
                db.Entry(discount).State = EntityState.Modified;
                db.SaveChanges();
                return RedirectToAction("Index");
            }
            ViewBag.UserCategoryID = new SelectList(db.UserCategories, "ID_UserCategories", "Name", discount.UserCategoryID);
            ViewBag.PageLevelName = "QUẢN LÝ TẬP KHÁCH HÀNG GIẢM GIÁ";
            return View(discount);
        }

        public ActionResult Delete(int? id)
        {
            string isLogin = (string)Session["IsLogin"];
            string role = (string)Session["department"];
            if (isLogin != "1" || role != "2")
            {
                return RedirectToAction("Login", "Account", null);
            }
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            Discount discount = db.Discounts.Find(id);
            if (discount == null)
            {
                return HttpNotFound();
            }
            db.Discounts.Remove(discount);
            db.SaveChanges();
            return RedirectToAction("Index");
        }
    }
}