using System;
using System.Collections.Generic;
using System.Data;
using System.Data.Entity;
using System.Linq;
using System.Threading.Tasks;
using System.Net;
using System.Web;
using System.Web.Mvc;
using System.Web.UI;
using System.Web.UI.WebControls;
using System.IO;
using AdminManagement.Models;
using System.Drawing;
using System.Data.OleDb;
using System.Data.SqlClient;
using Microsoft.Office.Tools;

namespace AdminManagement.Controllers
{
    public class ProductsController : Controller
    {
        private OnlineSaleEntities db = new OnlineSaleEntities();

        // GET: Products
        public async Task<ActionResult> Index()
        {
            string isLogin = (string)Session["IsLogin"];
            string role = (string)Session["department"];
            if (isLogin != "1")
            {
                return RedirectToAction("Login", "Account", null);
            }
            var products = db.Products.Include(p => p.ProductCategoriesRoot).Include(p => p.ProductCategoriesSub).Include(p => p.ProductStatus);
            ViewBag.PageLevelName = "QUẢN LÝ SẢN PHẨM";
            return View(await products.ToListAsync());
        }

        // GET: Products/Details/5
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
            Product product = await db.Products.FindAsync(id);
            if (product == null)
            {
                return HttpNotFound();
            }
            ViewBag.PageLevelName = "QUẢN LÝ SẢN PHẨM";
            return View(product);
        }

        // GET: Products/Create
        public ActionResult Create(int? id, string error = "")
        {
            string isLogin = (string)Session["IsLogin"];
            string role = (string)Session["department"];
            if (isLogin != "1" || role != "1")
            {
                return RedirectToAction("Login", "Account", null);
            }
            if (id == null)
            {
                id = 1;
            }
            ViewBag.CategoryRID = new SelectList(db.ProductCategoriesRoots, "ID_ProductCategoriesRoot", "Name");
            ViewBag.CategorySID = new SelectList(db.ProductCategoriesSubs, "ID_ProductCategoriesSub", "Name");
            ViewBag.Status = new SelectList(db.ProductStatuses, "ID_ProductStatuses", "Name");
            ViewBag.id = id;
            ViewBag.error = error;
            ViewBag.PageLevelName = "QUẢN LÝ SẢN PHẨM";
            return View();
        }

        // POST: Products/Create
        // To protect from overposting attacks, please enable the specific properties you want to bind to, for 
        // more details see http://go.microsoft.com/fwlink/?LinkId=317598.
        [HttpPost]
        [ValidateAntiForgeryToken]
        public async Task<ActionResult> Create([Bind(Include = "ID_Products,Name,Price,CategoryRID,CategorySID,Image,Status,Detail,ShortDetail,BarCode,Title,Author,Artist,Year,Company,Publisher,Size,Pages,Location,Quantity,Count,DateAdded,DateUpdated")] Product product, HttpPostedFileBase file, int? id)
        {
            string isLogin = (string)Session["IsLogin"];
            string role = (string)Session["department"];
            if (isLogin != "1" || role != "1")
            {
                return RedirectToAction("Login", "Account", null);
            }
            if (ModelState.IsValid)
            {
                if (file != null && file.ContentLength > 0)
                {
                    String FileExtn = System.IO.Path.GetExtension(file.FileName).ToLower();

                    if (!(FileExtn == ".jpg" || FileExtn == ".png"))
                    {
                        string error = "Chỉ chấp nhận hình ảnh định dạng *.jpg và *.png";
                        ViewBag.CategoryRID = new SelectList(db.ProductCategoriesRoots, "ID_ProductCategoriesRoot", "Name", product.CategoryRID);
                        ViewBag.CategorySID = new SelectList(db.ProductCategoriesSubs, "ID_ProductCategoriesSub", "Name", product.CategorySID);
                        ViewBag.Status = new SelectList(db.ProductStatuses, "ID_ProductStatuses", "Name", product.Status);
                        ViewBag.id = id;
                        ViewBag.error = error;
                        ViewBag.PageLevelName = "QUẢN LÝ SẢN PHẨM";
                        return View(product);
                    }
                    else
                    {
                        using (System.Drawing.Image Img = System.Drawing.Image.FromStream(file.InputStream))
                        {
                            String imgPath = String.Format("Content/product/img/{0}", file.FileName);
                            if (System.IO.File.Exists(String.Format("{0}{1}", Server.MapPath("~"), imgPath)))
                            {
                                System.IO.File.Delete(String.Format("{0}{1}", Server.MapPath("~"), imgPath));
                            }
                            Img.Save(String.Format("{0}{1}", Server.MapPath("~"), imgPath), Img.RawFormat);
                            product.Image = file.FileName;
                        }
                    }
                }
                
                var result = from P in db.ProductCategoriesSubs
                             where
                               P.ID_ProductCategoriesSub == product.CategorySID
                             select new
                             {
                                 P.RID
                             };
                product.CategoryRID = result.First().RID;
                product.DateAdded = DateTime.Now;
                product.DateUpdated = DateTime.Now;
                db.Products.Add(product);
                await db.SaveChangesAsync();
                return RedirectToAction("Create");
            }
            ViewBag.CategoryRID = new SelectList(db.ProductCategoriesRoots, "ID_ProductCategoriesRoot", "Name", product.CategoryRID);
            ViewBag.CategorySID = new SelectList(db.ProductCategoriesSubs, "ID_ProductCategoriesSub", "Name", product.CategorySID);
            ViewBag.Status = new SelectList(db.ProductStatuses, "ID_ProductStatuses", "Name", product.Status);
            ViewBag.PageLevelName = "QUẢN LÝ SẢN PHẨM";
            return View(product);
        }

        // GET: Products/Edit/5
        public async Task<ActionResult> Edit(int? id, string error = "")
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
            Product product = await db.Products.FindAsync(id);
            if (product == null)
            {
                return HttpNotFound();
            }
            ViewBag.CategoryRID = new SelectList(db.ProductCategoriesRoots, "ID_ProductCategoriesRoot", "Name", product.CategoryRID);
            ViewBag.CategorySID = new SelectList(db.ProductCategoriesSubs, "ID_ProductCategoriesSub", "Name", product.CategorySID);
            ViewBag.Status = new SelectList(db.ProductStatuses, "ID_ProductStatuses", "Name", product.Status);
            ViewBag.error = error;
            ViewBag.PageLevelName = "QUẢN LÝ SẢN PHẨM";
            return View(product);
        }

        // POST: Products/Edit/5
        // To protect from overposting attacks, please enable the specific properties you want to bind to, for 
        // more details see http://go.microsoft.com/fwlink/?LinkId=317598.
        [HttpPost]
        [ValidateAntiForgeryToken]
        public async Task<ActionResult> Edit([Bind(Include = "ID_Products,Name,Price,CategoryRID,CategorySID,Image,Status,Detail,ShortDetail,BarCode,Title,Author,Artist,Year,Company,Publisher,Size,Pages,Location,Quantity,Count,DateAdded,DateUpdated")] Product product, HttpPostedFileBase file)
        {
            string isLogin = (string)Session["IsLogin"];
            string role = (string)Session["department"];
            if (isLogin != "1" || role != "1")
            {
                return RedirectToAction("Login", "Account", null);
            }
            if (ModelState.IsValid)
            {
                if (file != null && file.ContentLength > 0)
                {
                    String FileExtn = System.IO.Path.GetExtension(file.FileName).ToLower();

                    if (!(FileExtn == ".jpg" || FileExtn == ".png"))
                    {
                        string error = "Chỉ chấp nhận hình ảnh định dạng *.jpg và *.png";
                        return RedirectToAction("Edit", new { id = product.ID_Products, error = error });
                    }
                    else
                    {
                        using (System.Drawing.Image Img = System.Drawing.Image.FromStream(file.InputStream))
                        {
                            String imgPath = String.Format("Content/product/img/{0}", file.FileName);
                            if (System.IO.File.Exists(String.Format("{0}{1}", Server.MapPath("~"), imgPath)))
                            {
                                System.IO.File.Delete(String.Format("{0}{1}", Server.MapPath("~"), imgPath));
                            }
                            Img.Save(String.Format("{0}{1}", Server.MapPath("~"), imgPath), Img.RawFormat);
                            product.Image = file.FileName;
                        }
                    }
                }

                var result = from P in db.ProductCategoriesSubs
                             where
                               P.ID_ProductCategoriesSub == product.CategorySID
                             select new
                             {
                                 P.RID
                             };
                product.CategoryRID = result.First().RID;
                product.DateUpdated = DateTime.Now;
                db.Entry(product).State = EntityState.Modified;
                await db.SaveChangesAsync();
                return RedirectToAction("Index");
            }
            ViewBag.CategoryRID = new SelectList(db.ProductCategoriesRoots, "ID_ProductCategoriesRoot", "Name", product.CategoryRID);
            ViewBag.CategorySID = new SelectList(db.ProductCategoriesSubs, "ID_ProductCategoriesSub", "Name", product.CategorySID);
            ViewBag.Status = new SelectList(db.ProductStatuses, "ID_ProductStatuses", "Name", product.Status);
            ViewBag.PageLevelName = "QUẢN LÝ SẢN PHẨM";
            return View(product);
        }

        // GET: Products/Delete/5
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
            Product product = await db.Products.FindAsync(id);
            if (product == null)
            {
                return HttpNotFound();
            }
            db.Products.Remove(product);
            await db.SaveChangesAsync();
            return RedirectToAction("Index");
        }

        public ActionResult ImportProduct(int? id)
        {
            string isLogin = (string)Session["IsLogin"];
            string role = (string)Session["department"];
            if (isLogin != "1" || role != "1")
            {
                return RedirectToAction("Login", "Account", null);
            }
            if (Request.Files["fileExcel"].ContentLength > 0)
            {
                String FileExtn = System.IO.Path.GetExtension(Request.Files["fileExcel"].FileName).ToLower();

                if (!(FileExtn == ".xls" || FileExtn == ".xlsx"))
                {
                    string error = "Chỉ chấp nhận tập tin định dạng *.xls và *.xlsx";
                    return RedirectToAction("Create", new { id = id, error = error });
                }
                else
                {
                    string extension = System.IO.Path.GetExtension(Request.Files["fileExcel"].FileName);
                    string path1 = string.Format("{0}/{1}", Server.MapPath("~/Content/uploaded"), Request.Files["fileExcel"].FileName);
                    if (System.IO.File.Exists(path1))
                    {
                        System.IO.File.Delete(path1);
                    }
                    Request.Files["fileExcel"].SaveAs(path1);

                    string excelConnectionString = @"Provider=Microsoft.ACE.OLEDB.12.0;Data Source=" + path1 + ";Extended Properties=Excel 12.0;Persist Security Info=False";
                    OleDbConnection excelConnection = new OleDbConnection(excelConnectionString);
                    OleDbCommand cmd = new OleDbCommand("Select [Name],[Price],[CategoryRID],[CategorySID],[Image],[Status],[Detail],[ShortDetail],[BarCode],[Title],[Author],[Artist],[Year],[Company],[Publisher],[Size],[Pages],[Location],[Quantity],[Count] from [Sheet1$]", excelConnection);

                    excelConnection.Open();
                    OleDbDataReader dReader;
                    dReader = cmd.ExecuteReader();

                    while (dReader.Read())
                    {
                        Product iProducts = new Product
                        {
                            Name = dReader.GetValue(0).ToString(),
                            Price = int.Parse(dReader.GetValue(1).ToString()),
                            CategoryRID = int.Parse(dReader.GetValue(2).ToString()),
                            CategorySID = int.Parse(dReader.GetValue(3).ToString()),
                            Image = dReader.GetValue(4).ToString(),
                            Status = int.Parse(dReader.GetValue(5).ToString()),
                            Detail = dReader.GetValue(6).ToString(),
                            ShortDetail = dReader.GetValue(7).ToString(),
                            BarCode = dReader.GetValue(8).ToString(),
                            Title = dReader.GetValue(9).ToString(),
                            Author = dReader.GetValue(10).ToString(),
                            Artist = dReader.GetValue(11).ToString(),
                            Year = dReader.GetValue(12).ToString(),
                            Company = dReader.GetValue(13).ToString(),
                            Publisher = dReader.GetValue(14).ToString(),
                            Size = dReader.GetValue(15).ToString(),
                            Pages = dReader.GetValue(16).ToString(),
                            Location = dReader.GetValue(17).ToString(),
                            Quantity = int.Parse(dReader.GetValue(18).ToString()),
                            Count = int.Parse(dReader.GetValue(19).ToString()),
                            DateAdded = DateTime.Now,
                            DateUpdated = DateTime.Now
                        };
                        db.Products.Add(iProducts);
                        db.SaveChanges();
                    }

                    excelConnection.Close();
                }                
            }
            return RedirectToAction("Create");
        }

        public ActionResult ExportProduct()
        {
            string isLogin = (string)Session["IsLogin"];
            string role = (string)Session["department"];
            if (isLogin != "1")
            {
                return RedirectToAction("Login", "Account", null);
            }
            GridView gv = new GridView();
            gv.DataSource = db.Products.ToList();
            gv.DataBind();
            Response.ClearContent();
            Response.Buffer = true;
            Response.AddHeader("content-disposition", "attachment; filename = Products.xls");
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
