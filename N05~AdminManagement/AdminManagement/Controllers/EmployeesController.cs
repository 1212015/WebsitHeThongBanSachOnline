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
    public class EmployeesController : Controller
    {
        private OnlineSaleEntities db = new OnlineSaleEntities();

        // GET: Employees
        public ActionResult Index()
        {
            string isLogin = (string)Session["IsLogin"];
            string role = (string)Session["department"];
            if (isLogin != "1")
            {
                return RedirectToAction("Login", "Account", null);
            }
            var employees = db.Employees.Include(e => e.Department).Include(e => e.Grade);
            ViewBag.PageLevelName = "QUẢN LÝ THÔNG TIN NHÂN VIÊN";
            return View(employees.ToList());
        }

        // GET: Employees/Details/5
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
            Employee employee = db.Employees.Find(id);
            if (employee == null)
            {
                return HttpNotFound();
            }
            ViewBag.PageLevelName = "QUẢN LÝ THÔNG TIN NHÂN VIÊN";
            return View(employee);
        }

        // GET: Employees/Create
        public ActionResult Create()
        {
            string isLogin = (string)Session["IsLogin"];
            string role = (string)Session["department"];
            if (isLogin != "1" || role != "1")
            {
                return RedirectToAction("Login", "Account", null);
            }
            ViewBag.DepartmentID = new SelectList(db.Departments, "ID_Departments", "Name");
            ViewBag.GradeID = new SelectList(db.Grades, "ID_Grades", "Name");
            ViewBag.PageLevelName = "QUẢN LÝ THÔNG TIN NHÂN VIÊN";
            return View();
        }

        // POST: Employees/Create
        // To protect from overposting attacks, please enable the specific properties you want to bind to, for 
        // more details see http://go.microsoft.com/fwlink/?LinkId=317598.
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Create([Bind(Include = "ID_Employees,Password,FirstName,LastName,IDNo,Gender,Birthday,Phone,Address,Email,Salary,GradeID,DepartmentID,DateAdded,DateUpdated")] Employee employee)
        {
            string isLogin = (string)Session["IsLogin"];
            string role = (string)Session["department"];
            if (isLogin != "1" || role != "1")
            {
                return RedirectToAction("Login", "Account", null);
            }
            if (ModelState.IsValid)
            {
                employee.DateAdded = DateTime.Now;
                employee.DateUpdated = DateTime.Now;
                db.Employees.Add(employee);
                db.SaveChanges();
                return RedirectToAction("Index");
            }

            ViewBag.DepartmentID = new SelectList(db.Departments, "ID_Departments", "Name", employee.DepartmentID);
            ViewBag.GradeID = new SelectList(db.Grades, "ID_Grades", "Name", employee.GradeID);
            ViewBag.PageLevelName = "QUẢN LÝ THÔNG TIN NHÂN VIÊN";
            return View(employee);
        }

        // GET: Employees/Edit/5
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
            Employee employee = db.Employees.Find(id);
            if (employee == null)
            {
                return HttpNotFound();
            }
            ViewBag.DepartmentID = new SelectList(db.Departments, "ID_Departments", "Name", employee.DepartmentID);
            ViewBag.GradeID = new SelectList(db.Grades, "ID_Grades", "Name", employee.GradeID);
            ViewBag.PageLevelName = "QUẢN LÝ THÔNG TIN NHÂN VIÊN";
            return View(employee);
        }

        // POST: Employees/Edit/5
        // To protect from overposting attacks, please enable the specific properties you want to bind to, for 
        // more details see http://go.microsoft.com/fwlink/?LinkId=317598.
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Edit([Bind(Include = "ID_Employees,Password,FirstName,LastName,IDNo,Gender,Birthday,Phone,Address,Email,Salary,GradeID,DepartmentID,DateAdded,DateUpdated")] Employee employee)
        {
            string isLogin = (string)Session["IsLogin"];
            string role = (string)Session["department"];
            if (isLogin != "1" || role != "1")
            {
                return RedirectToAction("Login", "Account", null);
            }
            if (ModelState.IsValid)
            {
                employee.DateUpdated = DateTime.Now;
                db.Entry(employee).State = EntityState.Modified;
                db.SaveChanges();
                return RedirectToAction("Index");
            }
            ViewBag.DepartmentID = new SelectList(db.Departments, "ID_Departments", "Name", employee.DepartmentID);
            ViewBag.GradeID = new SelectList(db.Grades, "ID_Grades", "Name", employee.GradeID);
            ViewBag.PageLevelName = "QUẢN LÝ THÔNG TIN NHÂN VIÊN";
            return View(employee);
        }

        // GET: Employees/Delete/5
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
            Employee employee = db.Employees.Find(id);
            if (employee == null)
            {
                return HttpNotFound();
            }
            db.Employees.Remove(employee);
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
