using System;
using System.Collections.Generic;
using System.Data;
using System.Data.Entity;
using System.Linq;
using System.Threading.Tasks;
using System.Net;
using System.Web;
using System.Web.Mvc;
using AdminManagement.Models;


namespace AdminManagement.Controllers
{
    public class TopicDetailsController : Controller
    {
        private OnlineSaleEntities db = new OnlineSaleEntities();

        // GET: TopicDetails
        public async Task<ActionResult> Index()
        {
            string isLogin = (string)Session["IsLogin"];
            string role = (string)Session["department"];
            if (isLogin != "1")
            {
                return RedirectToAction("Login", "Account", null);
            }
            var topicDetails = db.TopicDetails.Include(t => t.Topic);
            ViewBag.PageLevelName = "Chi tiết bài đăng";
            return View(await topicDetails.ToListAsync());
        }

        // GET: TopicDetails/Details/5
        public async Task<ActionResult> Details(int? id)
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
            TopicDetail topicDetail = await db.TopicDetails.FindAsync(id);
            if (topicDetail == null)
            {
                return HttpNotFound();
            }
            ViewBag.PageLevelName = "Chi tiết bài đăng";
            return View(topicDetail);
        }

        // GET: TopicDetails/Create
        public ActionResult Create()
        {
            string isLogin = (string)Session["IsLogin"];
            string role = (string)Session["department"];
            if (isLogin != "1" || role != "1")
            {
                return RedirectToAction("Login", "Account", null);
            }
            ViewBag.TopicID = new SelectList(db.Topics, "ID_Topic", "ID_Topic");
            ViewBag.PageLevelName = "Chi tiết bài đăng";
            return View();
        }

        // POST: TopicDetails/Create
        // To protect from overposting attacks, please enable the specific properties you want to bind to, for 
        // more details see http://go.microsoft.com/fwlink/?LinkId=317598.
        [HttpPost]
        [ValidateAntiForgeryToken]
        public async Task<ActionResult> Create([Bind(Include = "ID_TopicDetails,TopicID,Detail,ShortDetail,DateAdded,DateUpdated")] TopicDetail topicDetail)
        {
            string isLogin = (string)Session["IsLogin"];
            string role = (string)Session["department"];
            if (isLogin != "1" || role != "1")
            {
                return RedirectToAction("Login", "Account", null);
            }
            if (ModelState.IsValid)
            {
                db.TopicDetails.Add(topicDetail);
                await db.SaveChangesAsync();
                return RedirectToAction("Index");
            }

            ViewBag.TopicID = new SelectList(db.Topics, "ID_Topic", "ID_Topic", topicDetail.TopicID);
            ViewBag.PageLevelName = "Chi tiết bài đăng";
            return View(topicDetail);
        }

        // GET: TopicDetails/Edit/5
        public async Task<ActionResult> Edit(int? id)
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
            TopicDetail topicDetail = await db.TopicDetails.FindAsync(id);
            if (topicDetail == null)
            {
                return HttpNotFound();
            }
            ViewBag.TopicID = new SelectList(db.Topics, "ID_Topic", "ID_Topic", topicDetail.TopicID);
            ViewBag.PageLevelName = "Chi tiết bài đăng";
            return View(topicDetail);
        }

        // POST: TopicDetails/Edit/5
        // To protect from overposting attacks, please enable the specific properties you want to bind to, for 
        // more details see http://go.microsoft.com/fwlink/?LinkId=317598.
        [HttpPost]
        [ValidateAntiForgeryToken]
        public async Task<ActionResult> Edit([Bind(Include = "ID_TopicDetails,TopicID,Detail,ShortDetail,DateAdded,DateUpdated")] TopicDetail topicDetail)
        {
            string isLogin = (string)Session["IsLogin"];
            string role = (string)Session["department"];
            if (isLogin != "1" || role != "1")
            {
                return RedirectToAction("Login", "Account", null);
            }
            if (ModelState.IsValid)
            {
                db.Entry(topicDetail).State = EntityState.Modified;
                await db.SaveChangesAsync();
                return RedirectToAction("Index");
            }
            ViewBag.TopicID = new SelectList(db.Topics, "ID_Topic", "ID_Topic", topicDetail.TopicID);
            ViewBag.PageLevelName = "Chi tiết bài đăng";
            return View(topicDetail);
        }

        // GET: TopicDetails/Delete/5
        public async Task<ActionResult> Delete(int? id)
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
            TopicDetail topicDetail = await db.TopicDetails.FindAsync(id);
            if (topicDetail == null)
            {
                return HttpNotFound();
            }
            ViewBag.PageLevelName = "Chi tiết bài đăng";
            return View(topicDetail);
        }

        // POST: TopicDetails/Delete/5
        [HttpPost, ActionName("Delete")]
        [ValidateAntiForgeryToken]
        public async Task<ActionResult> DeleteConfirmed(int id)
        {
            string isLogin = (string)Session["IsLogin"];
            string role = (string)Session["department"];
            if (isLogin != "1" || role != "1")
            {
                return RedirectToAction("Login", "Account", null);
            }
            TopicDetail topicDetail = await db.TopicDetails.FindAsync(id);
            db.TopicDetails.Remove(topicDetail);
            await db.SaveChangesAsync();
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





