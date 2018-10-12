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
			function logout(){
				if(confirm("确认退出吗")){
					location.href="${pageContext.request.contextPath}/user/logout.do";
				}
			}
			
		</script>
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
							已发邮件
						</div>
						<div class="pages">
							<table width="90%" border="0" cellspacing="0" cellpadding="0">
								<tr bgcolor="gray">
									<td width="25%" align="center">邮件标题</td>
									<td width="25%" align="center">内容</td>
									<td width="25%" align="center">对方是否已读</td>
									<td width="25%" align="center">时间</td>
								</tr>
								<c:forEach items="${pi.list}" var="mail">
									<tr>
										<td align="center" onclick="details(${mail.id})">${mail.titile }</td>
										<td align="center" onclick="details(${mail.id})">${mail.content }</td>
										<c:if test="${mail.isread==1}">
										<td align="center" onclick="details(${mail.id})">未读</td>
										</c:if>
										<c:if test="${mail.isread==0}">
										<td align="center" onclick="details(${mail.id})">已读</td>
										</c:if>
										<td align="center" onclick="details(${mail.id})">${mail.createTime }</td>
									</tr>
										</c:forEach>
									<tr>
										<td colspan="4" align="center">
											<a href="${pageContext.request.contextPath }/mail/toSendedEmail.do?currPage=1&pageSize=${pi.pageSize}">首页</a>
											<c:if test="${pi.pageNum==1}">
											上一页
											</c:if>
											<c:if test="${pi.pageNum!=1}">
											<a href="${pageContext.request.contextPath }/mail/toSendedEmail.do?currPage=${pi.prePage}&pageSize=${pi.pageSize}">上一页</a>
											</c:if>
											<c:forEach begin="1" end="${pi.pages}" var="i">
												<a href="${pageContext.request.contextPath }/mail/toSendedEmail.do?currPage=${i}&pageSize=${pi.pageSize}">[${i }]</a>
											</c:forEach>
											<c:if test="${pi.pageNum==pi.pages}">
											下一页
											</c:if>
											<c:if test="${pi.pageNum!=pi.pages}">
											<a href="${pageContext.request.contextPath }/mail/toSendedEmail.do?currPage=${pi.nextPage}&pageSize=${pi.pageSize}">下一页</a>
											</c:if>
											<a href="${pageContext.request.contextPath }/mail/toSendedEmail.do?currPage=${pi.pages}&pageSize=${pi.pageSize}">尾页</a>
										</td>
									</tr>
									<tr>
										<td colspan="4" align="center">
											共${pi.total }条记录&nbsp;&nbsp; 每页显示条数:<a href="${pageContext.request.contextPath }/mail/toSendedEmail.do?pageSize=3&currPage=${pi.pageNum}">3条</a>
											<a href="${pageContext.request.contextPath }/mail/toSendedEmail.do?pageSize=5&currPage=${pi.pageNum}">5条</a>
											<a href="${pageContext.request.contextPath }/mail/toSendedEmail.do?pageSize=8&currPage=${pi.pageNum}">8条</a>
										</td>
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