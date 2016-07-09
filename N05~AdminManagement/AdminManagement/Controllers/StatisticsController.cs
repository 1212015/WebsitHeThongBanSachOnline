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
    public class StatisticsController : Controller
    {
        private OnlineSaleEntities db = new OnlineSaleEntities();

        // GET: Statistics
        public ActionResult Index(int? id, int? year1, int? year2)
        {
            string isLogin = (string)Session["IsLogin"];
            string role = (string)Session["department"];
            if (isLogin != "1")
            {
                return RedirectToAction("Login", "Account", null);
            }
            List<Statistics> list = new List<Statistics>();

            if (id == null)
            {
                id = 1;
                year1 = DateTime.Now.Year;
            }

            switch (id)
            {
                case 1:
                    if (year1 != null)
                    {
                        list = MonthStatistics(year1);
                        if (list.Count == 0)
                        {
                            ViewBag.msg = "Không tìm thấy dữ liệu";
                        }
                    }
                    break;
                case 2:
                    if (year1 != null && year2 != null)
                    {
                        list = YearStatistics(year1, year2);
                        if (list.Count == 0)
                        {
                            ViewBag.msg = "Không tìm thấy dữ liệu";
                        }
                    }
                    break;
            }

            ViewBag.PageLevelName = "THỐNG KÊ DOANH THU BÁN HÀNG";
            ViewBag.id = id;
            ViewBag.year1 = year1;
            ViewBag.year2 = year2;
            ViewBag.statistics = list;

            return View();
        }

        public List<Statistics> MonthStatistics(int? year)
        {
            var result = from OD in db.OrderDetails
                         where
                           OD.Order.Status == 1 &&
                           SqlFunctions.DatePart("year", OD.Order.DateAdded) == year
                         group new { OD.Order, OD } by new
                         {
                             Column1 = (int?)SqlFunctions.DatePart("month", OD.Order.DateAdded)
                         } into g
                         select new
                         {
                             Month = g.Key.Column1,
                             Total = (int?)g.Sum(p => p.OD.Quantity * p.OD.Price)
                         };

            List<Statistics> list = new List<Statistics>();

            foreach (var i in result)
            {
                Statistics temp = new Statistics();
                temp.key = i.Month.Value;
                temp.value = i.Total.Value;
                list.Add(temp);
            }

            return list;
        }

        public List<Statistics> YearStatistics(int? year1, int? year2)
        {
            if (year1 > year2)
            {
                int? temp = year1;
                year1 = year2;
                year2 = temp;
            }

            var result = from OD in db.OrderDetails
                         where
                           OD.Order.Status == 1 &&
                           SqlFunctions.DatePart("year", OD.Order.DateAdded) >= year1 && SqlFunctions.DatePart("year", OD.Order.DateAdded) <= year2
                         group new { OD.Order, OD } by new
                         {
                             Column1 = (int?)SqlFunctions.DatePart("year", OD.Order.DateAdded)
                         } into g
                         select new
                         {
                             Year = g.Key.Column1,
                             Total = (int?)g.Sum(p => p.OD.Quantity * p.OD.Price)
                         };

            List<Statistics> list = new List<Statistics>();

            foreach (var i in result)
            {
                Statistics temp = new Statistics();
                temp.key = i.Year.Value;
                temp.value = i.Total.Value;
                list.Add(temp);
            }

            return list;
        }

        public ActionResult CheckStatistics(int? id, int? month, int? year)
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
                                       SqlFunctions.DatePart("month", OD.Order.DateAdded) == month &&
                                       SqlFunctions.DatePart("year", OD.Order.DateAdded) == year
                                     select new
                                     {
                                         OD.OrderID,
                                         OD.ID_OrderDetails,
                                         OD.Price,
                                         OD.Quantity
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
                                       SqlFunctions.DatePart("year", OD.Order.DateAdded) == year
                                     select new
                                     {
                                         OD.OrderID,
                                         OD.ID_OrderDetails,
                                         OD.Price,
                                         OD.Quantity
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

            ViewBag.PageLevelName = "KIỂM KÊ THỐNG KÊ";
            ViewBag.checkorder = list;

            return View();
        }
    }
}
