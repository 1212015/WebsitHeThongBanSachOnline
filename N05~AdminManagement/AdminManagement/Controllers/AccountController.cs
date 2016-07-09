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
using System.Data.Entity.SqlServer;

namespace AdminManagement.Controllers
{
    public class AccountController : Controller
    {
        private OnlineSaleEntities db = new OnlineSaleEntities();

        // GET: Account
        public ActionResult Index()
        {
            string isLogin = (string)Session["IsLogin"];
            if (isLogin != "1")
            {
                return RedirectToAction("Login");
            }
            return RedirectToAction("Index", "Home", null);
        }

        public ActionResult Login()
        {
            return View();
        }

        [HttpPost]
        public ActionResult Login(string email = "", string password = "")
        {            
            var result = from Employees in db.Employees
                         where
                           Employees.Email == email &&
                           Employees.Password == password
                         select new
                         {
                             ID_Employees = Employees.ID_Employees,
                             Password = Employees.Password,
                             Email = Employees.Email,
                             DepartmentID = Employees.DepartmentID,
                             Firstname = Employees.FirstName
                         };
            if (result.Count() == 0)
            {
                ViewBag.error = "Sai email hoặc mật khẩu";
                return View();
            }
            var account = result.First();
            Session["IsLogin"] = "1";
            Session["IDEmp"] = account.ID_Employees.ToString();
            Session["Email"] = email;
            Session["Password"] = password;
            Session["Department"] = account.DepartmentID.ToString();
            Session["FirstName"] = account.Firstname;
            return RedirectToAction("Index", "Home", null);
        }

        public ActionResult Logout()
        {
            if ((string)Session["IsLogin"] != null)
            {
                Session["IsLogin"] = null;
                Session["IDEmp"] = null;
                Session["Email"] = null;
                Session["Password"] = null;
                Session["Department"] = null;                
            }
            return RedirectToAction("Login");
        }
    }
}