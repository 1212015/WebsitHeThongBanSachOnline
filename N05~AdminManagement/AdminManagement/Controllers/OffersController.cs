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
    public class OffersController : Controller
    {
        private OnlineSaleEntities db = new OnlineSaleEntities();

        // GET: Offers
        public async Task<ActionResult> Index()
        {
            string isLogin = (string)Session["IsLogin"];
            string role = (string)Session["department"];
            if (isLogin != "1")
            {
                return RedirectToAction("Login", "Account", null);
            }
            var offers = db.Offers.Include(o => o.OfferStatus);
            ViewBag.PageLevelName = "QUẢN LÝ KHUYẾN MÃI";
            return View(await offers.ToListAsync());
        }

        // GET: Offers/Details/5
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
            var result = from OD in db.OfferDetails
                         from O in db.Offers
                         
                         where
                           OD.Offer.ID_Offers == id && O.ID_Offers == id
                         select new
                         {
                             ID_Offers = (int?)OD.Offer.ID_Offers,
                             NameOffer = OD.Offer.Name,
                             StartDate = (DateTime?)OD.Offer.StartDate,
                             EndDate = (DateTime?)OD.Offer.EndDate,
                             DateAddedOffer = (DateTime?)OD.Offer.DateAdded,
                             DateUpdatedOffer = (DateTime?)OD.Offer.DateUpdated,
                             OD.ID_OfferDetails,
                             ID_Products = (int?)OD.Product.ID_Products,
                             NameProduct = OD.Product.Name,
                             OD.Discount,
                             ID_UserCategories = (int?)OD.UserCategory.ID_UserCategories,
                             NameUserCategory = OD.UserCategory.Name,
                             DateAddedOD = OD.DateAdded,
                             DateUpdatedOD = OD.DateUpdated,
                             StatusID = (int)OD.Offer.Status,
                             NameOfferStatus = OD.Offer.OfferStatus.Name
                         };
            List<Offers> list = new List<Offers>();
            foreach (var i in result)
            {
                Offers temp = new Offers();
                temp.DateAddedOffer = i.DateAddedOD;
                temp.DateAddedOfferDetail = i.DateAddedOffer.Value;
                temp.DateUpdatedOffer = i.DateUpdatedOD;
                temp.DateUpdatedOfferDetail = i.DateUpdatedOffer.Value;
                temp.Discount = i.Discount;
                temp.EndDate = i.EndDate.Value;
                temp.ID_OfferDetails = i.ID_OfferDetails;
                temp.ID_Offers = i.ID_Offers.Value;
                temp.NameOffer = i.NameOffer;
                temp.ProductID = i.ID_Products.Value;
                temp.ProductName = i.NameProduct;
                temp.StartDate = i.StartDate.Value;
                temp.UserCategoryID = i.ID_UserCategories.Value;
                temp.UserCategoryName = i.NameUserCategory;
                temp.StatusID = i.StatusID;
                temp.StatusName = i.NameOfferStatus;
                list.Add(temp);
            }
            ViewBag.offer = list;

            ViewBag.PageLevelName = "QUẢN LÝ KHUYẾN MÃI";
            return View();
        }

        // GET: Offers/Create
        public ActionResult Create()
        {
            string isLogin = (string)Session["IsLogin"];
            string role = (string)Session["department"];
            if (isLogin != "1" || role != "2")
            {
                return RedirectToAction("Login", "Account", null);
            }
            ViewBag.Status = new SelectList(db.OfferStatuses, "ID_OfferStatuses", "Name");
            ViewBag.PageLevelName = "QUẢN LÝ KHUYẾN MÃI";
            return View();
        }

        // POST: Offers/Create
        // To protect from overposting attacks, please enable the specific properties you want to bind to, for 
        // more details see http://go.microsoft.com/fwlink/?LinkId=317598.
        [HttpPost]
        [ValidateAntiForgeryToken]
        public async Task<ActionResult> Create([Bind(Include = "ID_Offers,Name,StartDate,EndDate,Status,DateAdded,DateUpdated")] Offer offer)
        {
            string isLogin = (string)Session["IsLogin"];
            string role = (string)Session["department"];
            if (isLogin != "1" || role != "2")
            {
                return RedirectToAction("Login", "Account", null);
            }
            if (ModelState.IsValid)
            {
                db.Offers.Add(offer);
                await db.SaveChangesAsync();
                return RedirectToAction("CreateDetail");
            }

            ViewBag.Status = new SelectList(db.OfferStatuses, "ID_OfferStatuses", "Name", offer.Status);
            ViewBag.PageLevelName = "QUẢN LÝ KHUYẾN MÃI";
            return View(offer);
        }

        // GET: Offers/CreateDetail
        public ActionResult CreateDetail()
        {
            string isLogin = (string)Session["IsLogin"];
            string role = (string)Session["department"];
            if (isLogin != "1" || role != "2")
            {
                return RedirectToAction("Login", "Account", null);
            }
            ViewBag.OfferID = new SelectList(db.Offers, "ID_Offers", "Name");
            ViewBag.ProductID = new SelectList(db.Products, "ID_Products", "Name");
            ViewBag.UserCategoryID = new SelectList(db.UserCategories, "ID_UserCategories", "Name");
            ViewBag.PageLevelName = "QUẢN LÝ KHUYẾN MÃI";
            return View();
        }

        // POST: Offers/CreateDetail
        // To protect from overposting attacks, please enable the specific properties you want to bind to, for 
        // more details see http://go.microsoft.com/fwlink/?LinkId=317598.
        [HttpPost]
        [ValidateAntiForgeryToken]
        public async Task<ActionResult> CreateDetail([Bind(Include = "ID_OfferDetails,OfferID,ProductID,UserCategoryID,Discount,DateAdded,DateUpdated")] OfferDetail offerdetail)
        {
            string isLogin = (string)Session["IsLogin"];
            string role = (string)Session["department"];
            if (isLogin != "1" || role != "2")
            {
                return RedirectToAction("Login", "Account", null);
            }
            if (ModelState.IsValid)
            {
                db.OfferDetails.Add(offerdetail);
                await db.SaveChangesAsync();
                return RedirectToAction("Index");
            }

            ViewBag.OfferID = new SelectList(db.OfferDetails, "ID_Offers", "ID_Offers", offerdetail.OfferID);
            ViewBag.ProductID = new SelectList(db.Products, "ID_Products", "ID_Products",offerdetail.ProductID);
            ViewBag.UserCategoryID = new SelectList(db.UserCategories, "ID_UserCategories", "ID_UserCategories", offerdetail.UserCategoryID);
            ViewBag.PageLevelName = "QUẢN LÝ KHUYẾN MÃI";
            return View(offerdetail);

        }

        public ActionResult CreateDetailSub()
        {
            string isLogin = (string)Session["IsLogin"];
            string role = (string)Session["department"];
            if (isLogin != "1" || role != "2")
            {
                return RedirectToAction("Login", "Account", null);
            }
            ViewBag.PageLevelName = "QUẢN LÝ KHUYẾN MÃI";
            ViewBag.Offer = db.Offers.ToList();
            ViewBag.ProCategorySub = db.ProductCategoriesSubs.ToList();
            ViewBag.UserCategory = db.UserCategories.ToList();
            return View();
        }

        [HttpPost]
        public ActionResult CreateDetailSub(int? idoffer, int? idprocatesub, int? idusercate, int? discount)
        {
            string isLogin = (string)Session["IsLogin"];
            string role = (string)Session["department"];
            if (isLogin != "1" || role != "2")
            {
                return RedirectToAction("Login", "Account", null);
            }
            var result = from P in db.Products
                         where
                           P.CategorySID == idprocatesub
                         select new
                         {
                             P.ID_Products
                         };
            if (discount == null)
            {
                discount = 0;
            }
            foreach (var i in result)
            {
                OfferDetail offerdetail = new OfferDetail
                { 
                OfferID = idoffer.Value,
                ProductID = i.ID_Products,
                UserCategoryID = idusercate.Value,
                Discount = discount.Value,
                DateAdded = DateTime.Now,
                DateUpdated = DateTime.Now
                };
                db.OfferDetails.Add(offerdetail);                
            }
            db.SaveChanges();
            ViewBag.PageLevelName = "QUẢN LÝ KHUYẾN MÃI";
            return RedirectToAction("CreateDetailSub");
        }

        public ActionResult CreateDetailRoot()
        {
            string isLogin = (string)Session["IsLogin"];
            string role = (string)Session["department"];
            if (isLogin != "1" || role != "2")
            {
                return RedirectToAction("Login", "Account", null);
            }
            ViewBag.PageLevelName = "QUẢN LÝ KHUYẾN MÃI";
            ViewBag.Offer = db.Offers.ToList();
            ViewBag.ProCategoryRoot = db.ProductCategoriesRoots.ToList();
            ViewBag.UserCategory = db.UserCategories.ToList();
            return View();
        }

        [HttpPost]
        public ActionResult CreateDetailRoot(int? idoffer, int? idprocateroot, int? idusercate, int? discount)
        {
            string isLogin = (string)Session["IsLogin"];
            string role = (string)Session["department"];
            if (isLogin != "1" || role != "2")
            {
                return RedirectToAction("Login", "Account", null);
            }
            var result = from P in db.Products
                         where
                           P.CategoryRID == idprocateroot
                         select new
                         {
                             P.ID_Products
                         };
            if (discount == null)
            {
                discount = 0;
            }
            foreach (var i in result)
            {
                OfferDetail offerdetail = new OfferDetail
                {
                    OfferID = idoffer.Value,
                    ProductID = i.ID_Products,
                    UserCategoryID = idusercate.Value,
                    Discount = discount.Value,
                    DateAdded = DateTime.Now,
                    DateUpdated = DateTime.Now
                };
                db.OfferDetails.Add(offerdetail);
            }
            db.SaveChanges();
            ViewBag.PageLevelName = "QUẢN LÝ KHUYẾN MÃI";
            return RedirectToAction("CreateDetailRoot");
        }

        // GET: Offers/Edit/5
        public async Task<ActionResult> Edit(int? id)
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
            Offer offer = await db.Offers.FindAsync(id);
            if (offer == null)
            {
                return HttpNotFound();
            }
            ViewBag.Status = new SelectList(db.OfferStatuses, "ID_OfferStatuses", "Name", offer.Status);
            ViewBag.PageLevelName = "QUẢN LÝ KHUYẾN MÃI";
            return View(offer);
        }

        // POST: Offers/Edit/5
        // To protect from overposting attacks, please enable the specific properties you want to bind to, for 
        // more details see http://go.microsoft.com/fwlink/?LinkId=317598.
        [HttpPost]
        [ValidateAntiForgeryToken]
        public async Task<ActionResult> Edit([Bind(Include = "ID_Offers,Name,StartDate,EndDate,Status,DateAdded,DateUpdated")] Offer offer)
        {
            string isLogin = (string)Session["IsLogin"];
            string role = (string)Session["department"];
            if (isLogin != "1" || role != "2")
            {
                return RedirectToAction("Login", "Account", null);
            }
            if (ModelState.IsValid)
            {
                db.Entry(offer).State = EntityState.Modified;
                await db.SaveChangesAsync();
                return RedirectToAction("Index");
            }
            ViewBag.Status = new SelectList(db.OfferStatuses, "ID_OfferStatuses", "Name", offer.Status);
            ViewBag.PageLevelName = "QUẢN LÝ KHUYẾN MÃI";
            return View(offer);
        }

        // GET: Offers/Delete/5
        public async Task<ActionResult> Delete(int? id)
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
            Offer offer = await db.Offers.FindAsync(id);
            if (offer == null)
            {
                return HttpNotFound();
            }
            return View(offer);
        }

        // POST: Offers/Delete/5
        [HttpPost, ActionName("Delete")]
        [ValidateAntiForgeryToken]
        public async Task<ActionResult> DeleteConfirmed(int id)
        {
            string isLogin = (string)Session["IsLogin"];
            string role = (string)Session["department"];
            if (isLogin != "1" || role != "2")
            {
                return RedirectToAction("Login", "Account", null);
            }
            Offer offer = await db.Offers.FindAsync(id);
            db.Offers.Remove(offer);
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
