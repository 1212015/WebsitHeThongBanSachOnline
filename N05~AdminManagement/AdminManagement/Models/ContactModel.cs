using System.ComponentModel.DataAnnotations;
namespace MvcSendMail.Models
{
    /// <summary>
    /// Contact Model
    /// </summary>
    public class ContactModel
    {
        
        [Required(ErrorMessage = "Tên không được trống")]
        public string UserName { get; set; }

        
        
        public string Email { get; set; }


        
        [Required(ErrorMessage = "Email không được trống")]
        [DataType(DataType.EmailAddress, ErrorMessage = "Email không đúng")]
        public string EmailTo { get; set; }

        
        [Required(ErrorMessage = "Chủ đề không được trống")]
        public string Subject { get; set; }

        
        [DataType(DataType.MultilineText)]
        public string Message { get; set; }
    }

    public class ContactModel_PhanHoi
    {
        
        [Required(ErrorMessage = "Tên không được trống")]
        public string UserName { get; set; }

        
        
        public string Email { get; set; }


        public string EmailTo { get; set; }

        
        [Required(ErrorMessage = "Chủ đề không được trống")]
        public string Subject { get; set; }

        
        [DataType(DataType.MultilineText)]
        public string Message { get; set; }
    }
}