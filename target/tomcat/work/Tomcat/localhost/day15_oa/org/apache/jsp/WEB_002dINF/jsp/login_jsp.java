/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2018-09-25 02:58:09 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class login_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("\t<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\r\n");
      out.write("\t<title>用户登录</title>\r\n");
      out.write(" \r\n");
      out.write("<style type=\"text/css\">\r\n");
      out.write("\t* {\r\n");
      out.write("\t\tmargin: 0;\r\n");
      out.write("\t\tpadding: 0;\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\tbody {\r\n");
      out.write("\t\tfont: 12px 宋体;\r\n");
      out.write("\t\tbackground: #4BB8EF url(");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/Images/bg.gif) repeat-x;\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\timg {\r\n");
      out.write("\t\tborder: 0;\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\t.login-top {\r\n");
      out.write("\t\twidth: 100%;\r\n");
      out.write("\t\theight: 186px;\r\n");
      out.write("\t\tmargin: 147px auto 0;\r\n");
      out.write("\t\tbackground: url(");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/Images/login_01.gif) no-repeat center 0;\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\t.login-area {\r\n");
      out.write("\t\twidth: 100%;\r\n");
      out.write("\t\theight: 140px;\r\n");
      out.write("\t\tmargin: 0 auto;\r\n");
      out.write("\t\tbackground: url(");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/Images/login_02.gif) no-repeat center 0;\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\t.login-area form {\r\n");
      out.write("\t\twidth: 290px;\r\n");
      out.write("\t\tmargin: 0 auto;\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\t.login-area label {\r\n");
      out.write("\t\tclear: left;\r\n");
      out.write("\t\tfloat: left;\r\n");
      out.write("\t\tmargin-top: 13px;\r\n");
      out.write("\t\twidth: 60px;\r\n");
      out.write("\t\tfont: 600 14px 宋体;\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\t.login-area  input {\r\n");
      out.write("\t\twidth: 122px;\r\n");
      out.write("\t\theight: 16px;\r\n");
      out.write("\t\tmargin-top: 11px;\r\n");
      out.write("\t\tborder: 1px #767F94 solid;\r\n");
      out.write("\t\tfont: 12px/ 16px 宋体;\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\tinput.login-sub {\r\n");
      out.write("\t\twidth: 204px;\r\n");
      out.write("\t\theight: 34px;\r\n");
      out.write("\t\tborder: 0;\r\n");
      out.write("\t\tbackground: url(");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/Images/login_sub.gif) no-repeat 90px 1px; *\r\n");
      out.write("\t\tmargin-top: 5px;\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\t.login-copyright {\r\n");
      out.write("\t\twidth: 100%;\r\n");
      out.write("\t\theight: 30px;\r\n");
      out.write("\t\tmargin: 18px auto 0;\r\n");
      out.write("\t\tbackground: url(");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/Images/copyright.gif) no-repeat center 0;\r\n");
      out.write("\t}\r\n");
      out.write("</style>\r\n");
      out.write("</head>\r\n");
      out.write(" \r\n");
      out.write("<body>\r\n");
      out.write("\t<div class=\"login-top\"></div>\r\n");
      out.write("\t<div class=\"login-area\">\r\n");
      out.write("\t\t<form id=\"myform\">\r\n");
      out.write("\t\t\t<label>\r\n");
      out.write("\t\t\t\t工&nbsp;&nbsp;号：\r\n");
      out.write("\t\t\t</label>\r\n");
      out.write("\t\t\t<input type=\"text\" name=\"username\" />\r\n");
      out.write("\t\t\t<label>\r\n");
      out.write("\t\t\t\t密&nbsp;&nbsp;码：\r\n");
      out.write("\t\t\t</label>\r\n");
      out.write("\t\t\t<input type=\"password\" name=\"password\" />\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t<input type=\"button\" class=\"login-sub\" value=\"\" />\r\n");
      out.write("\t\t\t<br/>\r\n");
      out.write("\t\t\t\t<b><font color=\"red\"></font></b>\r\n");
      out.write("\t\t</form>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<div class=\"login-copyright\"></div>\r\n");
      out.write("\t\r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/js/jquery-1.11.1.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("\r\n");
      out.write("\t$(function(){\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t$(\".login-sub\").click(function(){\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\tvar param = $(\"#myform\").serialize();\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t//alert(param);\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t$.ajax({\r\n");
      out.write("\t\t\t\turl:\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/user/login.do\",\r\n");
      out.write("\t\t\t\tdata:param,\r\n");
      out.write("\t\t\t\tdataType:\"text\",\r\n");
      out.write("\t\t\t\ttype:\"post\",\r\n");
      out.write("\t\t\t\tsuccess:function(rec){\r\n");
      out.write("\t\t\t\t\tif(rec==\"1\"){\r\n");
      out.write("\t\t\t\t\t\tlocation.href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/user/index.do\"\r\n");
      out.write("\t\t\t\t\t}else if(rec==\"2\"){\r\n");
      out.write("\t\t\t\t\t\tlocation.href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/user/indexAdmin.do\"\r\n");
      out.write("\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\telse{\r\n");
      out.write("\t\t\t\t\t\t$(\"font\").html(\"用户名或密码错误\")\r\n");
      out.write("\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t});\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t});\r\n");
      out.write("\t\t\r\n");
      out.write("\t})\r\n");
      out.write("</script>\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
