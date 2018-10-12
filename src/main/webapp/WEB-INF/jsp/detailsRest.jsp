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
		<script>
			function returnIndex()
			{
				location="${pageContext.request.contextPath }/rest/toIndex.do";
			}
			function downloads(id){
				location="${pageContext.request.contextPath}/mail/download.do?id="+id;
			}
			function logout(){
				
				if(confirm("确认退出吗")){
					location.href="${pageContext.request.contextPath}/user/logout.do";
				}
			}
			function requiresuccess(id){
				location="${pageContext.request.contextPath }/rest/requiresuccess.do?id="+id;
			}
			function requirefail(id){
				location="${pageContext.request.contextPath }/rest/requirefail.do?id="+id;
			}
		</script>
		<style type="text/css">
			 input[type="text"]{background:#D4D4D4;color: #80808B}
			 input[type="date"]{background:#D4D4D4;color: #80808B}
			 textarea{background:#D4D4D4;color: #80808B}
			 select{background:#D4D4D4;color: #80808B}
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
		<form id="myForm" name="myForm" action="${pageContext.request.contextPath}/mail/upload.do" method="post" enctype="multipart/form-data">
		<input type="hidden" name="fromID" value="${sessionUser.id }"/>
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
							休假申请详情
						</div>
						<div class="pages">
							<table width="90%" border="0" cellspacing="0" cellpadding="0">
									<tr >
									<td align="right" width="30%">姓名：</td><td  align="left"><input type="text" name="name" value="${applyUser.nickname }" readonly="readonly"/></td>
								</tr>
								<tr >
									<td align="right" width="30%">开始时间：</td><td  align="left"><input type="date" name="startTime" value="${rest.startTime }" readonly="readonly"/></td>
								</tr>
								<tr >
									<td align="right" width="30%">结束时间：</td><td  align="left"><input type="date" name="endTime" value="${rest.endTime }" readonly="readonly"/></td>
								</tr>
								<tr >
									<td align="right" width="30%">请假天数：</td><td  align="left"><input type="text" name="days"  value="${rest.days }" readonly="readonly"/></td>
								</tr>
								<tr >
									<td align="right" width="30%">请假原因：</td><td  align="left"><textarea rows="5" cols="50" name="reason" readonly="readonly">${rest.reason }</textarea></td>
								</tr>
								<tr>
									<td align="right" width="30%">审批人:</td><td align="left">
									<select name="approveID" disabled="disabled">
										<option value="${approveUser.id }">${approveUser.nickname }</option>
									</select>
									</td>
									<c:if test="${sessionUser.isadmin==1 }">
								<tr>
									<td align="center" colspan="2"><br/><input type="button"  value="返回" onclick="returnIndex()" /></td>
								</tr>
									</c:if>
									<c:if test="${sessionUser.isadmin==0 }">
								<tr>
									<td align="right"><input type="button"  value="审核通过" onclick="requiresuccess(${rest.id })" /></td>
									<td align="left"><input type="button"  value="审核拒绝" onclick="requirefail(${rest.id })" /></td>
								</tr>
									</c:if>
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