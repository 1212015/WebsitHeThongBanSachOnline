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
    public class UsersController : Controller
    {
        private OnlineSaleEntities db = new OnlineSaleEntities();

        // GET: Users
        public ActionResult Index(int? id)
        {
            string isLogin = (string)Session["IsLogin"];
            string role = (string)Session["department"];
            if (isLogin != "1")
            {
                return RedirectToAction("Login", "Account", null);
            }
            List<Users> list = new List<Users>();
            
            if (id != null)
            {
                var result = from U in db.Users
                             where
                               U.UserCategory.ID_UserCategories == id
                             select new
                             {
                                 U.ID_Users,
                                 U.Email,
                                 U.FirstName,
                                 U.LastName,
                                 U.Gender,
                                 U.UserCategory.Name
                             };

                foreach (var i in result)
                {
                    Users temp = new Users();
                    temp.ID_Users = i.ID_Users;
                    temp.Email = i.Email;
                    temp.Firstname = i.FirstName;
                    temp.LastName = i.LastName;
                    temp.Gender = i.Gender;
                    temp.CategoryName = i.Name;
                    list.Add(temp);
                }
            }
            else if (id == null)
            {
                var result = from U in db.Users
                             select new
                             {
                                 U.ID_Users,
                                 U.Email,
                                 U.FirstName,
                                 U.LastName,
                                 U.Gender,
                                 U.UserCategory.Name
                             };

                foreach (var i in result)
                {
                    Users temp = new Users();
                    temp.ID_Users = i.ID_Users;
                    temp.Email = i.Email;
                    temp.Firstname = i.FirstName;
                    temp.LastName = i.LastName;
                    temp.Gender = i.Gender;
                    temp.CategoryName = i.Name;
                    list.Add(temp);
                }
            }

            ViewBag.PageLevelName = "QUẢN LÝ THÔNG TIN KHÁCH HÀNG";
            ViewBag.users = list;

            return View();
        }

        public ActionResult Details(int? id)
        {
            string isLogin = (string)Session["IsLogin"];
            string role = (string)Session["department"];
            if (isLogin != "1")
            {
                return RedirectToAction("Login", "Account", null);
            }
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            User user = db.Users.Find(id);
            if (user == null)
            {
                return HttpNotFound();
            }
            ViewBag.PageLevelName = "QUẢN LÝ THÔNG TIN KHÁCH HÀNG";
            return View(user);
        }
                
        public ActionResult Create()
        {
            string isLogin = (string)Session["IsLogin"];
            string role = (string)Session["department"];
            if (isLogin != "1" || role != "2")
            {
                return RedirectToAction("Login", "Account", null);
            }
            ViewBag.Category = new SelectList(db.UserCategories, "ID_UserCategories", "Name");
            ViewBag.Status = new SelectList(db.UserStatuses, "ID_UserStatuses", "Name");
            ViewBag.PageLevelName = "QUẢN LÝ THÔNG TIN KHÁCH HÀNG";
            return View();
        }
                
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Create([Bind(Include = "ID_Users,Email,Password,FirstName,LastName,Gender,Birthday,Phone,Address,Status,Point,Category,DateAdded,DateUpdated")] User user)
        {
            string isLogin = (string)Session["IsLogin"];
            string role = (string)Session["department"];
            if (isLogin != "1" || role != "2")
            {
                return RedirectToAction("Login", "Account", null);
            }
            if (ModelState.IsValid)
            {
                user.Point = 0;
                user.DateAdded = DateTime.Now;
                user.DateUpdated = DateTime.Now;
                db.Users.Add(user);
                db.SaveChanges();
                return RedirectToAction("Index");
            }

            ViewBag.Category = new SelectList(db.UserCategories, "ID_UserCategories", "Name", user.Category);
            ViewBag.Status = new SelectList(db.UserStatuses, "ID_UserStatuses", "Name", user.Status);
            ViewBag.PageLevelName = "QUẢN LÝ THÔNG TIN KHÁCH HÀNG";
            return View(user);
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
            User user = db.Users.Find(id);
            if (user == null)
            {
                return HttpNotFound();
            }
            ViewBag.Category = new SelectList(db.UserCategories, "ID_UserCategories", "Name", user.Category);
            ViewBag.Status = new SelectList(db.UserStatuses, "ID_UserStatuses", "Name", user.Status);
            ViewBag.PageLevelName = "QUẢN LÝ THÔNG TIN KHÁCH HÀNG";
            return View(user);
        }
                
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Edit([Bind(Include = "ID_Users,Email,Password,FirstName,LastName,Gender,Birthday,Phone,Address,Status,Point,Category,DateAdded,DateUpdated")] User user)
        {
            string isLogin = (string)Session["IsLogin"];
            string role = (string)Session["department"];
            if (isLogin != "1" || role != "2")
            {
                return RedirectToAction("Login", "Account", null);
            }
            if (ModelState.IsValid)
            {
                user.DateUpdated = DateTime.Now;
                db.Entry(user).State = EntityState.Modified;
                db.SaveChanges();
                return RedirectToAction("Index");
            }
            ViewBag.Category = new SelectList(db.UserCategories, "ID_UserCategories", "Name", user.Category);
            ViewBag.Status = new SelectList(db.UserStatuses, "ID_UserStatuses", "Name", user.Status);
            ViewBag.PageLevelName = "QUẢN LÝ THÔNG TIN KHÁCH HÀNG";
            return View(user);
        }
    }
}
