<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>办公自动化管理系统</title>
		<link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet" type="text/css" />
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.11.1.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.validate.min.js"></script>
		<script>
			function require()
			{
				document.forms[0].submit();
			}
			function calctime(){
				var start = document.getElementById("startTime").value;
				var end = document.getElementById("endTime").value;
				var days = (new Date(end).getTime()-new Date(start).getTime())/86400000+1;
				document.getElementById("days").value=days;
			}
			function logout(){
				if(confirm("确认退出吗")){
					location.href="${pageContext.request.contextPath}/user/logout.do";
				}
			}
			$(function(){
				$("#myForm").validate({
					rules:{
						"approveID":{min:0},
						"startTime":{required:true},
						"endTime":{required:true},
						"days":{required:true}
					},
					messages:{
						"approveID":{min:"收件人不能为空"},
						"startTime":{required:"起始时间不能为空"},
						"endTime":{required:"结束时间不能为空"},
						"days":{required:"请假天数不能为空"}
					}
				});
			});
		</script>
		<style type="text/css">
			span {
				color: red;
				}
				textarea {
				overflow:scroll;
				overflow-x:hidden;
			}
		</style>
	</head>
	
	<body>
		<div class="top">
			<div class="global-width">
				<img src="${pageContext.request.contextPath}/Images/logo.gif" class="logo" />
			</div>
		</div>
		<div class="status">
			<div class="global-width">
				<c:if test="${sessionUser.isadmin==0}">管理员</c:if>${sessionUser.username} 你好！欢迎访问办公管理系统！&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="#" onclick="logout()">注销</a>
			</div>
		</div>
		<form id="myForm" name="myForm" action="${pageContext.request.contextPath}/rest/wantrest.do" method="post">
		<input type="hidden" name="applyID" value="${sessionUser.id }"/>
		<input type="hidden" name="state" value="0"/>
		<input type="hidden" name="isadmin" value="${sessionUser.isadmin }" id="isadmin"/>
		<div class="main">
			<div class="global-width">
		
				
 
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>办公自动化管理系统</title>
		<link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet" type="text/css" />
	</head>
  
  <body>
  
    <div class="nav" id="nav">
					<div class="t"></div>
					<dl>
							<dt onclick="this.parentNode.className=this.parentNode.className=='open'?'':'open';">信息管理 
						</dt>
						<dd>
							<a href="${pageContext.request.contextPath }/user/index.do" target="_self">个人信息</a>
						</dd>
					</dl>
					<dl>
						<dt
							onclick="this.parentNode.className=this.parentNode.className=='open'?'':'open';">
							邮件管理
						</dt>
						<dd>
							<a href="${pageContext.request.contextPath }/user/getAllExcept.do" target="_self">写邮件</a>
						</dd>
						<dd>
							<a href="${pageContext.request.contextPath }/mail/getAll.do" target="_self">收邮件</a>
						</dd>
						<dd>
							<a href="${pageContext.request.contextPath }/mail/toSendedEmail.do" target="_self">已发邮件</a>
						</dd>
						<dd>
							<a href="${pageContext.request.contextPath }/mail/getAllDelete.do" target="_self">垃圾邮件</a>
						</dd>
					</dl>
					<dl>
						<dt
							onclick="this.parentNode.className=this.parentNode.className=='open'?'':'open';">
							考勤管理
						</dt>
						<dd>
							<a href="${pageContext.request.contextPath }/rest/toIndex.do" target="_self">休假</a>
						</dd>
					</dl>
					<dl >
						<dt
							onclick="this.parentNode.className=this.parentNode.className=='open'?'':'open';">
							权限管理
						</dt>
						<dd>
							<a href="${pageContext.request.contextPath }/user/toAccount.do" target="_self">个人账户</a>
						</dd>
						<c:if test="${sessionUser.isadmin==0}">
							<dd>
							<a href="${pageContext.request.contextPath }/user/toAllAccount.do" target="_self">查看所有账户</a>
							</dd>
						</c:if>
					</dl>
				</div>
  </body>
</html>
					<div class="action">
						<div class="t">
							申请休假
						</div>
						<div class="pages">
							<table width="90%" border="0" cellspacing="0" cellpadding="0">
								<tr >
									<td align="right" width="30%">姓名：</td><td  align="left"><input type="text" name="nickname" value="${sessionUser.nickname }"  id="nickname" readonly="readonly" style="color:#80808B;background:#D4D4D4"/></td>
								</tr>
								<tr >
									<td align="right" width="30%">开始时间：</td><td  align="left"><input type="date" name="startTime" id="startTime"/><span>*</span></td>
								</tr>
								<tr >
									<td align="right" width="30%">结束时间：</td><td  align="left"><input type="date" name="endTime" id="endTime" onchange="calctime()"/><span>*</span></td>
								</tr>
								<tr >
									<td align="right" width="30%">请假天数：</td><td  align="left"><input type="text" name="days"  id="days" readonly="readonly" style="color:#80808B;background:#D4D4D4"/><span>*</span></td>
								</tr>
								<tr >
									<td align="right" width="30%">请假原因：</td><td  align="left"><textarea rows="5" cols="50" name="reason"></textarea></td>
								</tr>
								<tr>
									<td align="right" width="30%">审批人:</td><td align="left">
									<select name="approveID">
										<option value="-1">--请选择--</option>
										<c:forEach items="${allAdmin }" var="admin">
											<option value="${admin.id }">${admin.nickname }</option>
										</c:forEach>
									</select>
									</td>
								</tr>
								<tr >
									<td align="center" colspan="2"><br/><input type="submit"  id="save" value="提交申请"  /></td>
								</tr>
								</table>
						</div>
					</div>
			</div>
		</div>
		</form>
		<div class="copyright">
			Copyright &nbsp; &copy; &nbsp; 
		</div>
	</body>
</html>
</body>
</html>