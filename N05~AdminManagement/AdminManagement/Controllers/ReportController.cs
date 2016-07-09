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
using System.Web.UI;
using System.Web.UI.WebControls;
using AdminManagement.Models;
using System.Data.Entity.SqlServer;

namespace AdminManagement.Controllers
{
    public class ReportController : Controller
    {
        private OnlineSaleEntities db = new OnlineSaleEntities();

        // GET: Report
        public ActionResult Index(int? id, int? day, int? week, int? month, int? quarter, int? year, int? day2, int? month2, int? year2)
        {
            string isLogin = (string)Session["IsLogin"];
            string role = (string)Session["department"];
            if (isLogin != "1")
            {
                return RedirectToAction("Login", "Account", null);
            }
            List<Report> list = new List<Report>();

            if (id == null)
            {
                id = 1;
                day = DateTime.Now.Day;
                month = DateTime.Now.Month;
                year = DateTime.Now.Year;
            }

            switch (id)
            {
                case 1:
                    if (day != null && month != null && year != null)
                    {
                        list = DateReport(day, month, year);
                        if (list.Count == 0)
                        {
                            ViewBag.msg = "Không tìm thấy dữ liệu";
                        }
                    }
                    break;
                case 2:
                    if (week != null && year != null)
                    {
                        list = WeekReport(week, year);
                        if (list.Count == 0)
                        {
                            ViewBag.msg = "Không tìm thấy dữ liệu";
                        }
                    }
                    break;
                case 3:
                    if (month != null && year != null)
                    {
                        list = MonthReport(month, year);
                        if (list.Count == 0)
                        {
                            ViewBag.msg = "Không tìm thấy dữ liệu";
                        }
                    }
                    break;
                case 4:
                    if (quarter != null && year != null)
                    {
                        list = QuarterReport(quarter, year);
                        if (list.Count == 0)
                        {
                            ViewBag.msg = "Không tìm thấy dữ liệu";
                        }
                    }
                    break;
                case 5:
                    if (year != null)
                    {
                        list = YearReport(year);
                        if (list.Count == 0)
                        {
                            ViewBag.msg = "Không tìm thấy dữ liệu";
                        }
                    }
                    break;
                case 6:
                    if (day != null && month != null && year != null && day2 != null && month2 != null && year2 != null)
                    {
                        list = CustomReport(day, month, year, day2, month2, year2);
                        if (list.Count == 0)
                        {
                            ViewBag.msg = "Không tìm thấy dữ liệu";
                        }
                    }
                    break;
            }

            ViewBag.PageLevelName = "BÁO CÁO DOANH THU BÁN HÀNG";
            ViewBag.id = id;
            ViewBag.day = day;
            ViewBag.week = week;
            ViewBag.month = month;
            ViewBag.quarter = quarter;
            ViewBag.year = year;
            ViewBag.day2 = day2;
            ViewBag.month2 = month2;
            ViewBag.year2 = year2;
            ViewBag.report = list;

            return View();
        }

        public List<Report> DateReport(int? day, int? month, int? year)
        {
            var result = from OD in db.OrderDetails
                         where
                           OD.Order.Status == 1 &&
                           SqlFunctions.DatePart("day", OD.Order.DateAdded) == day &&
                           SqlFunctions.DatePart("month", OD.Order.DateAdded) == month &&
                           SqlFunctions.DatePart("year", OD.Order.DateAdded) == year
                         group new { OD.Product, OD } by new
                         {
                             ID_Products = (int?)OD.Product.ID_Products,
                             OD.Product.Name
                         } into g
                         select new
                         {
                             ID_Products = (int?)g.Key.ID_Products,
                             g.Key.Name,
                             SLBan = (int?)g.Sum(p => p.OD.Quantity),
                             DoanhThu = (int?)g.Sum(p => p.OD.Quantity * p.OD.Price)
                         };

            List<Report> list = new List<Report>();

            foreach (var i in result)
            {
                Report temp = new Report();
                temp.MaSP = i.ID_Products.Value;
                temp.TenSP = i.Name;
                temp.SLBan = i.SLBan.Value;
                temp.DoanhThu = i.DoanhThu.Value;
                list.Add(temp);
            }

            return list;
        }

        public List<Report> WeekReport(int? week, int? year)
        {
            var result = from OD in db.OrderDetails
                         where
                           OD.Order.Status == 1 &&
                           SqlFunctions.DatePart("week", OD.Order.DateAdded) == week &&
                           SqlFunctions.DatePart("year", OD.Order.DateAdded) == year
                         group new { OD.Product, OD } by new
                         {
                             ID_Products = (int?)OD.Product.ID_Products,
                             OD.Product.Name
                         } into g
                         select new
                         {
                             ID_Products = (int?)g.Key.ID_Products,
                             g.Key.Name,
                             SLBan = (int?)g.Sum(p => p.OD.Quantity),
                             DoanhThu = (int?)g.Sum(p => p.OD.Quantity * p.OD.Price)
                         };

            List<Report> list = new List<Report>();

            foreach (var i in result)
            {
                Report temp = new Report();
                temp.MaSP = i.ID_Products.Value;
                temp.TenSP = i.Name;
                temp.SLBan = i.SLBan.Value;
                temp.DoanhThu = i.DoanhThu.Value;
                list.Add(temp);
            }

            return list;
        }

        public List<Report> MonthReport(int? month, int? year)
        {
            var result = from OD in db.OrderDetails
                         where
                           OD.Order.Status == 1 &&
                           SqlFunctions.DatePart("month", OD.Order.DateAdded) == month &&
                           SqlFunctions.DatePart("year", OD.Order.DateAdded) == year
                         group new { OD.Product, OD } by new
                         {
                             ID_Products = (int?)OD.Product.ID_Products,
                             OD.Product.Name
                         } into g
                         select new
                         {
                             ID_Products = (int?)g.Key.ID_Products,
                             g.Key.Name,
                             SLBan = (int?)g.Sum(p => p.OD.Quantity),
                             DoanhThu = (int?)g.Sum(p => p.OD.Quantity * p.OD.Price)
                         };

            List<Report> list = new List<Report>();

            foreach (var i in result)
            {
                Report temp = new Report();
                temp.MaSP = i.ID_Products.Value;
                temp.TenSP = i.Name;
                temp.SLBan = i.SLBan.Value;
                temp.DoanhThu = i.DoanhThu.Value;
                list.Add(temp);
            }

            return list;
        }

        public List<Report> QuarterReport(int? quarter, int? year)
        {
            var result = from OD in db.OrderDetails
                         where
                           OD.Order.Status == 1 &&
                           SqlFunctions.DatePart("quarter", OD.Order.DateAdded) == quarter &&
                           SqlFunctions.DatePart("year", OD.Order.DateAdded) == year
                         group new { OD.Product, OD } by new
                         {
                             ID_Products = (int?)OD.Product.ID_Products,
                             OD.Product.Name
                         } into g
                         select new
                         {
                             ID_Products = (int?)g.Key.ID_Products,
                             g.Key.Name,
                             SLBan = (int?)g.Sum(p => p.OD.Quantity),
                             DoanhThu = (int?)g.Sum(p => p.OD.Quantity * p.OD.Price)
                         };

            List<Report> list = new List<Report>();

            foreach (var i in result)
            {
                Report temp = new Report();
                temp.MaSP = i.ID_Products.Value;
                temp.TenSP = i.Name;
                temp.SLBan = i.SLBan.Value;
                temp.DoanhThu = i.DoanhThu.Value;
                list.Add(temp);
            }

            return list;
        }

        public List<Report> YearReport(int? year)
        {
            var result = from OD in db.OrderDetails
                         where
                           OD.Order.Status == 1 &&
                           SqlFunctions.DatePart("year", OD.Order.DateAdded) == year
                         group new { OD.Product, OD } by new
                         {
                             ID_Products = (int?)OD.Product.ID_Products,
                             OD.Product.Name
                         } into g
                         select new
                         {
                             ID_Products = (int?)g.Key.ID_Products,
                             g.Key.Name,
                             SLBan = (int?)g.Sum(p => p.OD.Quantity),
                             DoanhThu = (int?)g.Sum(p => p.OD.Quantity * p.OD.Price)
                         };

            List<Report> list = new List<Report>();

            foreach (var i in result)
            {
                Report temp = new Report();
                temp.MaSP = i.ID_Products.Value;
                temp.TenSP = i.Name;
                temp.SLBan = i.SLBan.Value;
                temp.DoanhThu = i.DoanhThu.Value;
                list.Add(temp);
            }

            return list;
        }

        public List<Report> CustomReport(int? day1, int? month1, int? year1, int? day2, int? month2, int? year2)
        {
            string d1 = day1 + "/" + month1 + "/" + year1;
            string d2 = day2 + "/" + month2 + "/" + year2;
            DateTime date1 = Convert.ToDateTime(d1);
            DateTime date2 = Convert.ToDateTime(d2);

            var result = from OD in db.OrderDetails
                         where
                           OD.Order.Status == 1 &&
                           OD.Order.DateAdded >= date1 && OD.Order.DateAdded <= date2
                         group new { OD.Product, OD } by new
                         {
                             ID_Products = (int?)OD.Product.ID_Products,
                             OD.Product.Name
                         } into g
                         select new
                         {
                             ID_Products = (int?)g.Key.ID_Products,
                             g.Key.Name,
                             SLBan = (int?)g.Sum(p => p.OD.Quantity),
                             DoanhThu = (int?)g.Sum(p => p.OD.Quantity * p.OD.Price)
                         };

            List<Report> list = new List<Report>();

            foreach (var i in result)
            {
                Report temp = new Report();
                temp.MaSP = i.ID_Products.Value;
                temp.TenSP = i.Name;
                temp.SLBan = i.SLBan.Value;
                temp.DoanhThu = i.DoanhThu.Value;
                list.Add(temp);
            }

            return list;
        }

        public ActionResult TopCustomers()
        {
            string isLogin = (string)Session["IsLogin"];
            string role = (string)Session["department"];
            if (isLogin != "1")
            {
                return RedirectToAction("Login", "Account", null);
            }
            var result = (from OD in db.OrderDetails
                          group new { OD.Order.User, OD.Order.User.UserCategory, OD } by new
                          {
                              ID_Users = (int?)OD.Order.User.ID_Users,
                              OD.Order.User.FirstName,
                              OD.Order.User.LastName,
                              OD.Order.User.UserCategory.Name
                          } into g
                          select new
                          {
                              ID_Users = (int?)g.Key.ID_Users,
                              g.Key.FirstName,
                              g.Key.LastName,
                              g.Key.Name,
                              Count = (int?)g.Sum(p => p.OD.Quantity),
                              Total = (int?)g.Sum(p => p.OD.Quantity * p.OD.Price)
                          }).Take(10);

            List<TopCustomer> topcus = new List<TopCustomer>();

            foreach (var i in result)
            {
                TopCustomer temp = new TopCustomer();
                temp.ID_USer = i.ID_Users.Value;
                temp.FirstName = i.FirstName;
                temp.LastName = i.LastName;
                temp.Category = i.Name;
                temp.Count = i.Count.Value;
                temp.Total = i.Total.Value;
                topcus.Add(temp);
            }

            ViewBag.PageLevelName = "TOP 10 KHÁCH HÀNG";
            ViewBag.topcus = topcus;

            return View();
        }

        public ActionResult CheckReport(int? id, int? idSP, int? day, int? week, int? month, int? quarter, int? year, int? day2, int? month2, int? year2)
        {
            string isLogin = (string)Session["IsLogin"];
            string role = (string)Session["department"];
            if (isLogin != "1")
            {
                return RedirectToAction("Login", "Account", null);
            }
            List<OrderDetail> list = new List<OrderDetail>();

            switch (id)
            {
                case 1:
                    {
                        var result = from OD in db.OrderDetails
                                     where
                                       OD.Order.Status == 1 &&
                                       OD.ProductID == idSP &&
                                       SqlFunctions.DatePart("year", OD.Order.DateAdded) == year &&
                                       SqlFunctions.DatePart("month", OD.Order.DateAdded) == month &&
                                       SqlFunctions.DatePart("day", OD.Order.DateAdded) == day
                                     select new
                                     {
                                         OD.OrderID,
                                         OD.ID_OrderDetails,
                                         OD.Quantity,
                                         OD.Price
                                     };

                        foreach (var i in result)
                        {
                            OrderDetail temp = new OrderDetail();
                            temp.OrderID = i.OrderID;
                            temp.ID_OrderDetails = i.ID_OrderDetails;
                            temp.Price = i.Price;
                            temp.Quantity = i.Quantity;
                            list.Add(temp);
                        }
                        break;
                    }
                case 2:
                    {
                        var result = from OD in db.OrderDetails
                                     where
                                       OD.Order.Status == 1 &&
                                       OD.ProductID == idSP &&
                                       SqlFunctions.DatePart("year", OD.Order.DateAdded) == year &&
                                       SqlFunctions.DatePart("week", OD.Order.DateAdded) == week
                                     select new
                                     {
                                         OD.OrderID,
                                         OD.ID_OrderDetails,
                                         OD.Quantity,
                                         OD.Price
                                     };

                        foreach (var i in result)
                        {
                            OrderDetail temp = new OrderDetail();
                            temp.OrderID = i.OrderID;
                            temp.ID_OrderDetails = i.ID_OrderDetails;
                            temp.Price = i.Price;
                            temp.Quantity = i.Quantity;
                            list.Add(temp);
                        }
                        break;
                    }
                case 3:
                    {
                        var result = from OD in db.OrderDetails
                                     where
                                       OD.Order.Status == 1 &&
                                       OD.ProductID == idSP &&
                                       SqlFunctions.DatePart("year", OD.Order.DateAdded) == year &&
                                       SqlFunctions.DatePart("month", OD.Order.DateAdded) == month
                                     select new
                                     {
                                         OD.OrderID,
                                         OD.ID_OrderDetails,
                                         OD.Quantity,
                                         OD.Price
                                     };

                        foreach (var i in result)
                        {
                            OrderDetail temp = new OrderDetail();
                            temp.OrderID = i.OrderID;
                            temp.ID_OrderDetails = i.ID_OrderDetails;
                            temp.Price = i.Price;
                            temp.Quantity = i.Quantity;
                            list.Add(temp);
                        }
                        break;
                    }
                case 4:
                    {
                        var result = from OD in db.OrderDetails
                                     where
                                       OD.Order.Status == 1 &&
                                       OD.ProductID == idSP &&
                                       SqlFunctions.DatePart("year", OD.Order.DateAdded) == year &&
                                       SqlFunctions.DatePart("quarter", OD.Order.DateAdded) == quarter
                                     select new
                                     {
                                         OD.OrderID,
                                         OD.ID_OrderDetails,
                                         OD.Quantity,
                                         OD.Price
                                     };

                        foreach (var i in result)
                        {
                            OrderDetail temp = new OrderDetail();
                            temp.OrderID = i.OrderID;
                            temp.ID_OrderDetails = i.ID_OrderDetails;
                            temp.Price = i.Price;
                            temp.Quantity = i.Quantity;
                            list.Add(temp);
                        }
                        break;
                    }
                case 5:
                    {
                        var result = from OD in db.OrderDetails
                                     where
                                       OD.Order.Status == 1 &&
                                       OD.ProductID == idSP &&
                                       SqlFunctions.DatePart("year", OD.Order.DateAdded) == year
                                     select new
                                     {
                                         OD.OrderID,
                                         OD.ID_OrderDetails,
                                         OD.Quantity,
                                         OD.Price
                                     };

                        foreach (var i in result)
                        {
                            OrderDetail temp = new OrderDetail();
                            temp.OrderID = i.OrderID;
                            temp.ID_OrderDetails = i.ID_OrderDetails;
                            temp.Price = i.Price;
                            temp.Quantity = i.Quantity;
                            list.Add(temp);
                        }
                        break;
                    }
                case 6:
                    {
                        string d1 = day + "/" + month + "/" + year;
                        string d2 = day2 + "/" + month2 + "/" + year2;
                        DateTime date1 = Convert.ToDateTime(d1);
                        DateTime date2 = Convert.ToDateTime(d2);

                        var result = from OD in db.OrderDetails
                                     where
                                       OD.Order.Status == 1 &&
                                       OD.ProductID == idSP &&
                                       OD.Order.DateAdded >= date1 && OD.Order.DateAdded <= date2
                                     select new
                                     {
                                         OD.OrderID,
                                         OD.ID_OrderDetails,
                                         OD.Quantity,
                                         OD.Price
                                     };

                        foreach (var i in result)
                        {
                            OrderDetail temp = new OrderDetail();
                            temp.OrderID = i.OrderID;
                            temp.ID_OrderDetails = i.ID_OrderDetails;
                            temp.Price = i.Price;
                            temp.Quantity = i.Quantity;
                            list.Add(temp);
                        }
                        break;
                    }
            }

            ViewBag.PageLevelName = "KIỂM KÊ BÁO CÁO";
            ViewBag.checkorder = list;

            return View();
        }

        public ActionResult ExportReport(int? id, int? day, int? week, int? month, int? quarter, int? year, int? day2, int? month2, int? year2)
        {
            string isLogin = (string)Session["IsLogin"];
            string role = (string)Session["department"];
            if (isLogin != "1" || role != "2")
            {
                return RedirectToAction("Login", "Account", null);
            }

            List<Report> list = new List<Report>();
            switch (id)
            {
                case 1:
                    if (day != null && month != null && year != null)
                    {
                        list = DateReport(day, month, year);
                    }
                    break;
                case 2:
                    if (week != null && year != null)
                    {
                        list = WeekReport(week, year);
                    }
                    break;
                case 3:
                    if (month != null && year != null)
                    {
                        list = MonthReport(month, year);
                    }
                    break;
                case 4:
                    if (quarter != null && year != null)
                    {
                        list = QuarterReport(quarter, year);
                    }
                    break;
                case 5:
                    if (year != null)
                    {
                        list = YearReport(year);
                    }
                    break;
                case 6:
                    if (day != null && month != null && year != null && day2 != null && month2 != null && year2 != null)
                    {
                        list = CustomReport(day, month, year, day2, month2, year2);
                    }
                    break;
            }

            GridView gv = new GridView();
            gv.DataSource = list;
            gv.DataBind();
            Response.ClearContent();
            Response.Buffer = true;
            Response.AddHeader("content-disposition", "attachment; filename = Report.xls");
            Response.ContentType = "application/ms-excel";
            Response.ContentEncoding = System.Text.Encoding.Unicode;
            Response.BinaryWrite(System.Text.Encoding.Unicode.GetPreamble());
            Response.Charset = "";
            StringWriter sw = new StringWriter();
            HtmlTextWriter htw = new HtmlTextWriter(sw);
            gv.RenderControl(htw);
            Response.Output.Write(sw.ToString());
            Response.Flush();
            Response.End();

            return RedirectToAction("Index");
        }
    }
}
