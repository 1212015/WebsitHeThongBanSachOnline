using Microsoft.Owin;
using Owin;

[assembly: OwinStartupAttribute(typeof(AdminManagement.Startup))]
namespace AdminManagement
{
    public partial class Startup
    {
        public void Configuration(IAppBuilder app)
        {
            ConfigureAuth(app);
        }
    }
}
