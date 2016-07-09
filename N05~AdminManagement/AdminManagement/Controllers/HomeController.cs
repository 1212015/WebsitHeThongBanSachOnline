using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace AdminManagement.Controllers
{
    public class HomeController : Controller
    {
        public ActionResult Index()
        {
            string isLogin = (string)Session["IsLogin"];
            if (isLogin != "1")
            {
                return RedirectToAction("Login", "Account", null);
            }
            ViewBag.PageLevelName = "BẢNG ĐIỀU KHIỂN";
            return View();
        }        
    }
}