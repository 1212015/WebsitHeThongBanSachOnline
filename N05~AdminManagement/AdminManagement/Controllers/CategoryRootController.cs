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
    public class CategoryRootController : Controller
    {
        private OnlineSaleEntities db = new OnlineSaleEntities();

        // GET: CategoryRoot
        public ActionResult Index()
        {
            string isLogin = (string)Session["IsLogin"];
            string role = (string)Session["department"];
            if (isLogin != "1")
            {
                return RedirectToAction("Login", "Account", null);
            }
            ViewBag.PageLevelName = "QUẢN LÝ LOẠI SẢN PHẨM";
            return View(db.ProductCategoriesRoots.ToList());
        }

        // GET: CategoryRoot/Create
        public ActionResult Create()
        {
            string isLogin = (string)Session["IsLogin"];
            string role = (string)Session["department"];
            if (isLogin != "1" || role != "1")
            {
                return RedirectToAction("Login", "Account", null);
            }
            ViewBag.PageLevelName = "QUẢN LÝ LOẠI SẢN PHẨM";
            return View();
        }

        // POST: CategoryRoot/Create
        // To protect from overposting attacks, please enable the specific properties you want to bind to, for 
        // more details see http://go.microsoft.com/fwlink/?LinkId=317598.
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Create([Bind(Include = "ID_ProductCategoriesRoot,Name,DateAdded,DateUpdated")] ProductCategoriesRoot productCategoriesRoot)
        {
            string isLogin = (string)Session["IsLogin"];
            string role = (string)Session["department"];
            if (isLogin != "1" || role != "1")
            {
                return RedirectToAction("Login", "Account", null);
            }
            if (ModelState.IsValid)
            {
                productCategoriesRoot.DateAdded = DateTime.Now;
                productCategoriesRoot.DateUpdated = DateTime.Now;
                db.ProductCategoriesRoots.Add(productCategoriesRoot);
                db.SaveChanges();
                return RedirectToAction("Create");
            }
            ViewBag.PageLevelName = "QUẢN LÝ LOẠI SẢN PHẨM";
            return View(productCategoriesRoot);
        }

        // GET: CategoryRoot/Edit/5
        public ActionResult Edit(int? id)
        {
            string isLogin = (string)Session["IsLogin"];
            string role = (string)Session["department"];
            if (isLogin != "1" || role != "1")
            {
                return RedirectToAction("Login", "Account", null);
            }
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            ProductCategoriesRoot productCategoriesRoot = db.ProductCategoriesRoots.Find(id);
            if (productCategoriesRoot == null)
            {
                return HttpNotFound();
            }
            ViewBag.PageLevelName = "QUẢN LÝ LOẠI SẢN PHẨM";
            return View(productCategoriesRoot);
        }

        // POST: CategoryRoot/Edit/5
        // To protect from overposting attacks, please enable the specific properties you want to bind to, for 
        // more details see http://go.microsoft.com/fwlink/?LinkId=317598.
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Edit([Bind(Include = "ID_ProductCategoriesRoot,Name,DateAdded,DateUpdated")] ProductCategoriesRoot productCategoriesRoot)
        {
            string isLogin = (string)Session["IsLogin"];
            string role = (string)Session["department"];
            if (isLogin != "1" || role != "1")
            {
                return RedirectToAction("Login", "Account", null);
            }
            if (ModelState.IsValid)
            {
                productCategoriesRoot.DateUpdated = DateTime.Now;
                db.Entry(productCategoriesRoot).State = EntityState.Modified;
                db.SaveChanges();
                return RedirectToAction("Index");
            }
            ViewBag.PageLevelName = "QUẢN LÝ LOẠI SẢN PHẨM";
            return View(productCategoriesRoot);
        }

        public ActionResult Delete(int? id)
        {
            string isLogin = (string)Session["IsLogin"];
            string role = (string)Session["department"];
            if (isLogin != "1" || role != "1")
            {
                return RedirectToAction("Login", "Account", null);
            }
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            ProductCategoriesRoot productCategoriesRoot = db.ProductCategoriesRoots.Find(id);
            if (productCategoriesRoot == null)
            {
                return HttpNotFound();
            }
            db.ProductCategoriesRoots.Remove(productCategoriesRoot);
            db.SaveChanges();
            return RedirectToAction("Index");
        }
    }
}
