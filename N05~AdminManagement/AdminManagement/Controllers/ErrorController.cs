using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace AdminManagement.Controllers
{
    public class ErrorController : Controller
    {
        // GET: Error
        public ViewResult Error404()
        {
            return View();
        }
    }
}