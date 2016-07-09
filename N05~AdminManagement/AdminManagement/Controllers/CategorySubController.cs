using System;
using System.Collections.Generic;
using System.Data;
using System.Data.Entity;
using System.Linq;
using System.Net;
using System.Web;
using System.Web.Mvc;
using AdminManagement.Models;
using System.Drawing;

namespace AdminManagement.Controllers
{
    public class CategorySubController : Controller
    {
        private OnlineSaleEntities db = new OnlineSaleEntities();

        // GET: CategorySub
        public ActionResult Index(int? id)
        {
            string isLogin = (string)Session["IsLogin"];
            string role = (string)Session["department"];
            if (isLogin != "1")
            {
                return RedirectToAction("Login", "Account", null);
            }
            List<CategorySub> list = new List<CategorySub>();
            
            if (id == null)
            {
                var result = from S in db.ProductCategoriesSubs
                             select new
                             {
                                 S.ID_ProductCategoriesSub,
                                 SName = S.Name,
                                 S.Image,
                                 S.DateAdded,
                                 S.DateUpdated,
                                 RName = S.ProductCategoriesRoot.Name
                             };
                foreach (var i in result)
                {
                    CategorySub temp = new CategorySub();
                    temp.ID = i.ID_ProductCategoriesSub;
                    temp.Name = i.SName;
                    temp.RName = i.RName;
                    temp.Image = i.Image;
                    temp.DateAdded = i.DateAdded;
                    temp.DateUpdated = i.DateUpdated;
                    list.Add(temp);
                }
            }
            else if (id != null)
            {
                var result = from S in db.ProductCategoriesSubs
                             where
                               S.ProductCategoriesRoot.ID_ProductCategoriesRoot == id
                             select new
                             {
                                 S.ID_ProductCategoriesSub,
                                 SName = S.Name,
                                 S.Image,
                                 S.DateAdded,
                                 S.DateUpdated,
                                 RName = S.ProductCategoriesRoot.Name
                             };
                foreach (var i in result)
                {
                    CategorySub temp = new CategorySub();
                    temp.ID = i.ID_ProductCategoriesSub;
                    temp.Name = i.SName;
                    temp.RName = i.RName;
                    temp.Image = i.Image;
                    temp.DateAdded = i.DateAdded;
                    temp.DateUpdated = i.DateUpdated;
                    list.Add(temp);
                }
            }
            ViewBag.PageLevelName = "QUẢN LÝ LOẠI SẢN PHẨM CON";
            ViewBag.categorysub = list;
            return View();
        }

        // GET: CategorySub/Details/5
        public ActionResult Details(int? id)
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
            ProductCategoriesSub productCategoriesSub = db.ProductCategoriesSubs.Find(id);
            if (productCategoriesSub == null)
            {
                return HttpNotFound();
            }

            ViewBag.PageLevelName = "QUẢN LÝ LOẠI SẢN PHẨM CON";

            return View(productCategoriesSub);
        }

        // GET: CategorySub/Create
        public ActionResult Create(string error = "")
        {
            string isLogin = (string)Session["IsLogin"];
            string role = (string)Session["department"];
            if (isLogin != "1" || role != "1")
            {
                return RedirectToAction("Login", "Account", null);
            }
            ViewBag.RID = new SelectList(db.ProductCategoriesRoots, "ID_ProductCategoriesRoot", "Name");
            ViewBag.PageLevelName = "QUẢN LÝ LOẠI SẢN PHẨM CON";
            ViewBag.error = error;
            return View();
        }

        // POST: CategorySub/Create
        // To protect from overposting attacks, please enable the specific properties you want to bind to, for 
        // more details see http://go.microsoft.com/fwlink/?LinkId=317598.
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Create([Bind(Include = "ID_ProductCategoriesSub,Name,Detail,ShortDetail,Image,RID,DateAdded,DateUpdated")] ProductCategoriesSub productCategoriesSub, HttpPostedFileBase file)
        {
            string isLogin = (string)Session["IsLogin"];
            string role = (string)Session["department"];
            if (isLogin != "1" || role != "1")
            {
                return RedirectToAction("Login", "Account", null);
            }
            if (ModelState.IsValid)
            {
                if (file != null && file.ContentLength > 0)
                {
                    String FileExtn = System.IO.Path.GetExtension(file.FileName).ToLower();

                    if (!(FileExtn == ".jpg" || FileExtn == ".png"))
                    {
                        string error = "Chỉ chấp nhận hình ảnh định dạng *.jpg và *.png";
                        ViewBag.RID = new SelectList(db.ProductCategoriesRoots, "ID_ProductCategoriesRoot", "Name", productCategoriesSub.RID);
                        ViewBag.error = error;
                        ViewBag.PageLevelName = "QUẢN LÝ LOẠI SẢN PHẨM CON";
                        return View(productCategoriesSub);
                    }
                    else
                    {
                        using (System.Drawing.Image Img = System.Drawing.Image.FromStream(file.InputStream))
                        {
                            String imgPath = String.Format("Content/categorysub/img/{0}", file.FileName);
                            if (System.IO.File.Exists(String.Format("{0}{1}", Server.MapPath("~"), imgPath)))
                            {
                                System.IO.File.Delete(String.Format("{0}{1}", Server.MapPath("~"), imgPath));
                            }
                            Img.Save(String.Format("{0}{1}", Server.MapPath("~"), imgPath), Img.RawFormat);
                            productCategoriesSub.Image = file.FileName;
                        }
                    }
                }

                productCategoriesSub.DateAdded = DateTime.Now;
                productCategoriesSub.DateUpdated = DateTime.Now;
                db.ProductCategoriesSubs.Add(productCategoriesSub);
                db.SaveChanges();
                return RedirectToAction("Create");
            }

            ViewBag.RID = new SelectList(db.ProductCategoriesRoots, "ID_ProductCategoriesRoot", "Name", productCategoriesSub.RID);
            ViewBag.PageLevelName = "QUẢN LÝ LOẠI SẢN PHẨM CON";
            return View(productCategoriesSub);
        }

        // GET: CategorySub/Edit/5
        public ActionResult Edit(int? id, string error = "")
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
            ProductCategoriesSub productCategoriesSub = db.ProductCategoriesSubs.Find(id);
            if (productCategoriesSub == null)
            {
                return HttpNotFound();
            }
            ViewBag.RID = new SelectList(db.ProductCategoriesRoots, "ID_ProductCategoriesRoot", "Name", productCategoriesSub.RID);
            ViewBag.PageLevelName = "QUẢN LÝ LOẠI SẢN PHẨM CON";
            ViewBag.error = error;
            return View(productCategoriesSub);
        }

        // POST: CategorySub/Edit/5
        // To protect from overposting attacks, please enable the specific properties you want to bind to, for 
        // more details see http://go.microsoft.com/fwlink/?LinkId=317598.
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Edit([Bind(Include = "ID_ProductCategoriesSub,Name,Detail,ShortDetail,Image,RID,DateAdded,DateUpdated")] ProductCategoriesSub productCategoriesSub, int? oldRID, HttpPostedFileBase file)
        {
            string isLogin = (string)Session["IsLogin"];
            string role = (string)Session["department"];
            if (isLogin != "1" || role != "1")
            {
                return RedirectToAction("Login", "Account", null);
            }
            if (ModelState.IsValid)
            {
                if (file != null && file.ContentLength > 0)
                {
                    String FileExtn = System.IO.Path.GetExtension(file.FileName).ToLower();

                    if (!(FileExtn == ".jpg" || FileExtn == ".png"))
                    {
                        string error = "Chỉ chấp nhận hình ảnh định dạng *.jpg và *.png";
                        return RedirectToAction("Edit", new { id = productCategoriesSub.ID_ProductCategoriesSub, error = error });
                    }
                    else
                    {
                        using (System.Drawing.Image Img = System.Drawing.Image.FromStream(file.InputStream))
                        {
                            String imgPath = String.Format("Content/categorysub/img/{0}", file.FileName);
                            if (System.IO.File.Exists(String.Format("{0}{1}", Server.MapPath("~"), imgPath)))
                            {
                                System.IO.File.Delete(String.Format("{0}{1}", Server.MapPath("~"), imgPath));
                            }
                            Img.Save(String.Format("{0}{1}", Server.MapPath("~"), imgPath), Img.RawFormat);
                            productCategoriesSub.Image = file.FileName;
                        }
                    }
                }

                var queryProducts = from Products in db.Products
                                    where
                                      Products.CategorySID == productCategoriesSub.ID_ProductCategoriesSub &&
                                      Products.CategoryRID == oldRID
                                    select Products;
                foreach (var Products in queryProducts)
                {
                    Products.CategoryRID = productCategoriesSub.RID;
                }
                productCategoriesSub.DateUpdated = DateTime.Now;
                db.Entry(productCategoriesSub).State = EntityState.Modified;
                db.SaveChanges();
                return RedirectToAction("Index");
            }
            ViewBag.RID = new SelectList(db.ProductCategoriesRoots, "ID_ProductCategoriesRoot", "Name", productCategoriesSub.RID);
            ViewBag.PageLevelName = "QUẢN LÝ LOẠI SẢN PHẨM CON";
            return View(productCategoriesSub);
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
            ProductCategoriesSub productCategoriesSub = db.ProductCategoriesSubs.Find(id);
            if (productCategoriesSub == null)
            {
                return HttpNotFound();
            }
            db.ProductCategoriesSubs.Remove(productCategoriesSub);
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
