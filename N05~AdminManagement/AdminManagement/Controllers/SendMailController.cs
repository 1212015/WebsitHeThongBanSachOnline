using System;
using System.Collections.Generic;
using System.Data;
using System.Data.Entity;
using System.Linq;
using System.Threading.Tasks;
using System.Net;
using System.Web;
using System.Web.Mvc;

using MvcSendMail.Models;
using AdminManagement.Models;
namespace MvcSendMail.Controllers
{
    public class SendMailController : Controller
    {
        private OnlineSaleEntities db = new OnlineSaleEntities();
        //
        // GET: /SendMail/

        public ActionResult Index()
        {
            string isLogin = (string)Session["IsLogin"];
            string role = (string)Session["department"];
            if (isLogin != "1")
            {
                return RedirectToAction("Login", "Account", null);
            }
            var model = new ContactModel();
            return View(model);
        }
        [HttpPost]
        public ActionResult Index(ContactModel model, string status="")
        {
            string isLogin = (string)Session["IsLogin"];
            string role = (string)Session["department"];
            if (isLogin != "1")
            {
                return RedirectToAction("Login", "Account", null);
            }
            if (ModelState.IsValid)
            {
                string smtpUserName = "nguyentiendung880@gmail.com";
                string smtpPassword = "srwpgbbqufibbqdr";//srwpgbbqufibbqdr password được tạo ra để đăng nhập thay cho mật khẩu đăng nhập.
                string smtpHost = "smtp.gmail.com";
                int smtpPort = 587;

                string emailTo = model.EmailTo; // Khi có liên hệ sẽ gửi về thư của mình
                string subject = model.Subject;
                string body = string.Format("Bạn vừa nhận được liên hệ từ: <b>{0}</b><br/>Email: {1}<br/>Nội dung: </br>{2}",
                    model.UserName, model.Email, model.Message);

                EmailService service = new EmailService();

                bool kq = service.Send(smtpUserName, smtpPassword, smtpHost, smtpPort,
                    emailTo, subject, body);

                if (kq)
                {
                    ModelState.AddModelError("", "Gửi thư thành công");
                }
                else ModelState.AddModelError("", "Gửi thư thất bại, vui lòng thử lại.");
            }
            return View(model);
            
        }

        public ActionResult Reply(int id, string email = "", string status = "")
        {
            string isLogin = (string)Session["IsLogin"];
            string role = (string)Session["department"];
            if (isLogin != "1")
            {
                return RedirectToAction("Login", "Account", null);
            }
            ViewBag.id = id;
            ViewBag.email = email;
            ViewBag.status = status;
            var model = new ContactModel_PhanHoi();
            return View(model);
        }
        [HttpPost]
        public ActionResult Reply(ContactModel_PhanHoi model, int id, string email = "", string status = "")
        {
            string isLogin = (string)Session["IsLogin"];
            string role = (string)Session["department"];
            if (isLogin != "1")
            {
                return RedirectToAction("Login", "Account", null);
            }
            if (ModelState.IsValid)
            {
                string smtpUserName = "nguyentiendung880@gmail.com";
                string smtpPassword = "srwpgbbqufibbqdr";
                string smtpHost = "smtp.gmail.com";
                int smtpPort = 587;

                string emailTo = email; // Khi có liên hệ sẽ gửi về thư của mình
                string subject = model.Subject;
                string body = string.Format("Bạn vừa nhận được liên hệ từ: <b>{0}</b><br/>Nội dung: </br>{1}",
                    model.UserName, model.Message);

                EmailService service = new EmailService();

                bool kq = service.Send(smtpUserName, smtpPassword, smtpHost, smtpPort,
                    emailTo, subject, body);

                if (kq)
                {
                    ModelState.AddModelError("", "Gửi thư thành công");
                    var queryTopics =
	                from Topics in db.Topics
	                where
	                  Topics.ID_Topic == id
	                select Topics;
                    foreach (var Topics in queryTopics)
                    {
	                    Topics.Status = 1;
                    }
                    db.SaveChanges();
                    
                }
                else ModelState.AddModelError("", "Gửi thư thất bại, vui lòng thử lại.");
            }
            return View(model);
        }
    }
}
