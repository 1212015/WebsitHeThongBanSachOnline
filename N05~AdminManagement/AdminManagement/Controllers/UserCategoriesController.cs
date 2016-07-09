using System;
using System.Collections.Generic;
using System.Data;
using System.Data.Entity;
using System.Linq;
using System.Net;
using System.Web;
using System.Web.Mvc;
using AdminManagement.Models;

namespace AdminManagement.Controllers
{
    public class UserCategoriesController : Controller
    {
        private OnlineSaleEntities db = new OnlineSaleEntities();

        // GET: UserCategories
        public ActionResult Index()
        {
            string isLogin = (string)Session["IsLogin"];
            string role = (string)Session["department"];
            if (isLogin != "1")
            {
                return RedirectToAction("Login", "Account", null);
            }
            List<UserCategory> list = new List<UserCategory>();

            var result = from UserCategories in db.UserCategories
                         select new
                         {
                             ID_UserCategories = UserCategories.ID_UserCategories,
                             Name = UserCategories.Name,
                             MinPoint = UserCategories.MinPoint,
                             DateAdded = UserCategories.DateAdded,
                             DateUpdated = UserCategories.DateUpdated
                         };
            foreach (var i in result)
            {
                UserCategory temp = new UserCategory();
                temp.ID_UserCategories = i.ID_UserCategories;
                temp.Name = i.Name;
                temp.MinPoint = i.MinPoint;
                temp.DateAdded = i.DateAdded;
                temp.DateUpdated = i.DateUpdated;
                list.Add(temp);
            }
            ViewBag.PageLevelName = "QUẢN LÝ LOẠI KHÁCH HÀNG";
            ViewBag.usercategory = list;
            return View();
        }

        // GET: UserCategories/Create
        public ActionResult Create()
        {
            string isLogin = (string)Session["IsLogin"];
            string role = (string)Session["department"];
            if (isLogin != "1" || role != "2")
            {
                return RedirectToAction("Login", "Account", null);
            }
            ViewBag.PageLevelName = "QUẢN LÝ LOẠI KHÁCH HÀNG";
            return View();
        }

        // POST: UserCategories/Create
        // To protect from overposting attacks, please enable the specific properties you want to bind to, for 
        // more details see http://go.microsoft.com/fwlink/?LinkId=317598.
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Create([Bind(Include = "ID_UserCategories,Name,MinPoint,DateAdded,DateUpdated")] UserCategory userCategory)
        {
            string isLogin = (string)Session["IsLogin"];
            string role = (string)Session["department"];
            if (isLogin != "1" || role != "2")
            {
                return RedirectToAction("Login", "Account", null);
            }
            if (ModelState.IsValid)
            {
                userCategory.DateAdded = DateTime.Now;
                userCategory.DateUpdated = DateTime.Now;
                db.UserCategories.Add(userCategory);
                db.SaveChanges();
                return RedirectToAction("Index");
            }
            ViewBag.PageLevelName = "QUẢN LÝ LOẠI KHÁCH HÀNG";
            return View(userCategory);
        }

        // GET: UserCategories/Edit/5
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
            UserCategory userCategory = db.UserCategories.Find(id);
            if (userCategory == null)
            {
                return HttpNotFound();
            }
            ViewBag.PageLevelName = "QUẢN LÝ LOẠI KHÁCH HÀNG";
            return View(userCategory);
        }

        // POST: UserCategories/Edit/5
        // To protect from overposting attacks, please enable the specific properties you want to bind to, for 
        // more details see http://go.microsoft.com/fwlink/?LinkId=317598.
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Edit([Bind(Include = "ID_UserCategories,Name,MinPoint,DateAdded,DateUpdated")] UserCategory userCategory)
        {
            string isLogin = (string)Session["IsLogin"];
            string role = (string)Session["department"];
            if (isLogin != "1" || role != "2")
            {
                return RedirectToAction("Login", "Account", null);
            }
            if (ModelState.IsValid)
            {
                userCategory.DateUpdated = DateTime.Now;
                db.Entry(userCategory).State = EntityState.Modified;
                db.SaveChanges();
                return RedirectToAction("Index");
            }
            ViewBag.PageLevelName = "QUẢN LÝ LOẠI KHÁCH HÀNG";
            return View(userCategory);
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
            UserCategory userCategory = db.UserCategories.Find(id);
            if (userCategory == null)
            {
                return HttpNotFound();
            }
            db.UserCategories.Remove(userCategory);
            db.SaveChanges();
            return RedirectToAction("Index");
        }

        protected override void Dispose(bool disposing)
        {
            if (disposing)
            {
                db.Dispose();
            }
            base.Dispose(disposing);
        }
    }
}
