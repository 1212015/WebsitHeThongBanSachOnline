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
    public class OrdersController : Controller
    {
        private OnlineSaleEntities db = new OnlineSaleEntities();

        // GET: Orders
        public async Task<ActionResult> Index()
        {
            string isLogin = (string)Session["IsLogin"];
            string role = (string)Session["department"];
            if (isLogin != "1")
            {
                return RedirectToAction("Login", "Account", null);
            }
            var orders = db.Orders.Include(o => o.Discount).Include(o => o.Employee).Include(o => o.OrderStatus).Include(o => o.User).Include(o => o.User).Include(o => o.OrderDetails).Include(o => o.Discount).Include(o => o.Employee).Include(o => o.Payments);
            ViewBag.PageLevelName = "QUẢN LÝ ĐƠN ĐẶT HÀNG";
            return View(await orders.ToListAsync());
        }

        // GET: Orders/Details/5
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
            var result = from PM in db.PaymentMethods
                         from P in db.Payments
                         from Pr in db.Products
                         from O in db.Orders
                         from OD in db.OrderDetails
                         from D in db.Discounts
                         where O.ID_Orders == id && P.Order.ID_Orders==id && OD.OrderID==id && PM.ID_PaymentMethods==P.PaymentMethodID && D.ID_Discounts== O.DiscountID && Pr.ID_Products==OD.ProductID
                         select new
                         {
                             ID_Payments = P.ID_Payments,
                             OrderID = P.OrderID,
                             PaymentMethodID = P.PaymentMethodID,
                             Status = P.Status,
                             DateAdded = P.DateAdded,
                             DateUpdated = P.DateUpdated,
                             ID_OrderDetails = OD.ID_OrderDetails,
                             Column1 = OD.OrderID,
                             ProductID = OD.ProductID,
                             Quantity = OD.Quantity,
                             Price = OD.Price,
                             Column2 = OD.DateAdded,
                             Column3 = OD.DateUpdated,
                             ID_PaymentMethods = (int)P.PaymentMethod.ID_PaymentMethods,
                             Name = P.PaymentMethod.Name,
                             Column4 = (DateTime)P.PaymentMethod.DateAdded,
                             Column5 = (DateTime)P.PaymentMethod.DateUpdated,
                             ID_Orders = (int)P.Order.ID_Orders,
                             UserID = (int)P.Order.UserID,
                             EmployeeID = (int)P.Order.EmployeeID,
                             ShipName = P.Order.ShipName,
                             ShipAddress = P.Order.ShipAddress,
                             ShipPhone = P.Order.ShipPhone,
                             ShipDate = (DateTime)P.Order.ShipDate,
                             DiscountID = (int)P.Order.DiscountID,
                             Column6 = (int)P.Order.Status,
                             Column7 = (DateTime)P.Order.DateAdded,
                             Column8 = (DateTime)P.Order.DateUpdated,
                             Discount = D.Discount1,
                             ProductName= Pr.Name,
                             Column9= Pr.Company,
                             Column10= Pr.ShortDetail,
                             Column11= Pr.Size,
                             Culumn12= Pr.Year,
                             Culumn13 = Pr.Detail
                         };
            List<Orders> list = new List<Orders>();
            foreach (var i in result)
            {
                Orders temp = new Orders();
                temp.OrderID = i.OrderID;
                temp.ProductID = i.ProductID;
                temp.Price = i.Price;
                temp.Quantity = i.Quantity;
                temp.ShipName = i.ShipName;
                temp.ShipAddress = i.ShipAddress;
                temp.ShipPhone = i.ShipPhone;
                temp.ShipDate = i.ShipDate;
                temp.UserID = i.UserID;
                temp.DiscountID = i.DiscountID;
                temp.Status = i.Status;
                temp.Name = i.Name;
                temp.DateAdded = i.DateAdded;
                temp.DateUpdated= i.DateUpdated;
                temp.Discount = i.Discount;
                temp.ProductName = i.ProductName;
                temp.ShortDetail = i.Column10;
                temp.Detail = i.Culumn13;
                temp.Company = i.Column9;
                temp.Size = i.Column11;
                temp.Size = i.Culumn12;
                list.Add(temp);
            }
            ViewBag.order = list;

            ViewBag.PageLevelName = "QUẢN LÝ ĐƠN ĐẶT HÀNG";
            return View();
        }

        // GET: Orders/Create
        public ActionResult Create()
        {
            string isLogin = (string)Session["IsLogin"];
            string role = (string)Session["department"];
            if (isLogin != "1" || role != "1")
            {
                return RedirectToAction("Login", "Account", null);
            }
            ViewBag.DiscountID = new SelectList(db.Discounts, "ID_Discounts", "ID_Discounts");
            ViewBag.EmployeeID = new SelectList(db.Employees, "ID_Employees", "ID_Employees");
            ViewBag.Status = new SelectList(db.OrderStatuses, "ID_OrderStatuses", "Name");
            ViewBag.UserID = new SelectList(db.Users, "ID_Users", "ID_Users");

            ViewBag.PageLevelName = "QUẢN LÝ ĐƠN ĐẶT HÀNG";
            return View();
        }

        // POST: Orders/Create
        // To protect from overposting attacks, please enable the specific properties you want to bind to, for 
        // more details see http://go.microsoft.com/fwlink/?LinkId=317598.
        [HttpPost]
        [ValidateAntiForgeryToken]
        public async Task<ActionResult> Create([Bind(Include = "ID_Orders,UserID,EmployeeID,ShipName,ShipAddress,ShipPhone,ShipDate,DiscountID,Status,DateAdded,DateUpdated")] Order order)
        {
            string isLogin = (string)Session["IsLogin"];
            string role = (string)Session["department"];
            if (isLogin != "1" || role != "1")
            {
                return RedirectToAction("Login", "Account", null);
            }
            if (ModelState.IsValid)
            {
                db.Orders.Add(order);
                await db.SaveChangesAsync();
                return RedirectToAction("CreateDetail");
            }

            ViewBag.DiscountID = new SelectList(db.Discounts, "ID_Discounts", "ID_Discounts", order.DiscountID);
            ViewBag.EmployeeID = new SelectList(db.Employees, "ID_Employees", "ID_Employees", order.EmployeeID);
            ViewBag.Status = new SelectList(db.OrderStatuses, "ID_OrderStatuses", "Name", order.Status);
            ViewBag.UserID = new SelectList(db.Users, "ID_Users", "ID_Users", order.UserID);
       
            ViewBag.PageLevelName = "QUẢN LÝ ĐƠN ĐẶT HÀNG";
            return View(order);

        }

        // GET: Orders/CreateDetail
        public ActionResult CreateDetail()
        {
            string isLogin = (string)Session["IsLogin"];
            string role = (string)Session["department"];
            if (isLogin != "1" || role != "1")
            {
                return RedirectToAction("Login", "Account", null);
            }
            ViewBag.OrderID = new SelectList(db.Orders, "ID_Orders", "ID_Orders");
            ViewBag.ProductID = new SelectList(db.Products, "ID_Products", "ID_Products");

            ViewBag.PageLevelName = "QUẢN LÝ ĐƠN ĐẶT HÀNG";
            return View();
        }

        // POST: Orders/CreateDetail
        // To protect from overposting attacks, please enable the specific properties you want to bind to, for 
        // more details see http://go.microsoft.com/fwlink/?LinkId=317598.
        [HttpPost]
        [ValidateAntiForgeryToken]
        public async Task<ActionResult> CreateDetail([Bind(Include = "ID_OrderDetails,OrderID,ProductID,Quantity,Price,DateAdded,DateUpdated")] OrderDetail orderdetail)
        {
            string isLogin = (string)Session["IsLogin"];
            string role = (string)Session["department"];
            if (isLogin != "1" || role != "1")
            {
                return RedirectToAction("Login", "Account", null);
            }
            if (ModelState.IsValid)
            {
                db.OrderDetails.Add(orderdetail);
                await db.SaveChangesAsync();
                return RedirectToAction("Index");
            }

            ViewBag.OrderID = new SelectList(db.Orders, "ID_Orders", "ID_Orders", orderdetail.OrderID);
            ViewBag.ProductID = new SelectList(db.Products, "ID_Products", "ID_Products",orderdetail.ProductID);

            ViewBag.PageLevelName = "QUẢN LÝ ĐƠN ĐẶT HÀNG";
            return View(orderdetail);

        }

        private ActionResult redirecttoaction(string p)
        {
            throw new NotImplementedException();
        }

        // GET: Orders/Edit/5
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
            Order order = await db.Orders.FindAsync(id);
            if (order == null)
            {
                return HttpNotFound();
            }
            ViewBag.DiscountID = new SelectList(db.Discounts, "ID_Discounts", "ID_Discounts", order.DiscountID);
            ViewBag.EmployeeID = new SelectList(db.Employees, "ID_Employees", "ID_Employees", order.EmployeeID);
            ViewBag.Status = new SelectList(db.OrderStatuses, "ID_OrderStatuses", "Name", order.Status);
            ViewBag.UserID = new SelectList(db.Users, "ID_Users", "ID_Users", order.UserID);
            ViewBag.PageLevelName = "QUẢN LÝ ĐƠN ĐẶT HÀNG";
            return View(order);
        }

        // POST: Orders/Edit/5
        // To protect from overposting attacks, please enable the specific properties you want to bind to, for 
        // more details see http://go.microsoft.com/fwlink/?LinkId=317598.
        [HttpPost]
        [ValidateAntiForgeryToken]
        public async Task<ActionResult> Edit([Bind(Include = "ID_Orders,UserID,EmployeeID,ShipName,ShipAddress,ShipPhone,ShipDate,DiscountID,Status,DateAdded,DateUpdated")] Order order)
        {
            string isLogin = (string)Session["IsLogin"];
            string role = (string)Session["department"];
            if (isLogin != "1" || role != "1")
            {
                return RedirectToAction("Login", "Account", null);
            }
            if (ModelState.IsValid)
            {
                db.Entry(order).State = EntityState.Modified;
                await db.SaveChangesAsync();
                return RedirectToAction("Index");
            }
            ViewBag.DiscountID = new SelectList(db.Discounts, "ID_Discounts", "ID_Discounts", order.DiscountID);
            ViewBag.EmployeeID = new SelectList(db.Employees, "ID_Employees", "EmployeeID", order.EmployeeID);
            ViewBag.Status = new SelectList(db.OrderStatuses, "ID_OrderStatuses", "Name", order.Status);
            ViewBag.UserID = new SelectList(db.Users, "ID_Users", "ID_Users", order.UserID);
            ViewBag.PageLevelName = "QUẢN LÝ ĐƠN ĐẶT HÀNG";
            return View(order);
        }

       

        // GET: Orders/Delete/5
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
            Order order = await db.Orders.FindAsync(id);
            if (order == null)
            {
                return HttpNotFound();
            }
            db.Orders.Remove(order);
            await db.SaveChangesAsync();
            return RedirectToAction("Index");
        }

        // GET: Orders/DeleteDetail/5
        public async Task<ActionResult> DeleteDetail(int? id)
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
            OrderDetail orderdetail = await db.OrderDetails.FindAsync(id);
            if (orderdetail == null)
            {
                return HttpNotFound();
            }
            db.OrderDetails.Remove(orderdetail);
            await db.SaveChangesAsync();
            return RedirectToAction("Delete");
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
