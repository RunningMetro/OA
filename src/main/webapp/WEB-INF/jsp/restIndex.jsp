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
			function details(id){
				location.href="${pageContext.request.contextPath}/rest/todetailsRest.do?id="+id;
			}
			function require(){
				location.href="${pageContext.request.contextPath}/user/getAllAdmin.do"
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
							申请休假列表
						</div>
						<div class="pages">
							<table width="90%" border="0" cellspacing="0" cellpadding="0">
								<c:if test="${sessionUser.isadmin==0 }">
								<tr bgcolor="gray">
									<td width="14.28%" align="center">申请人</td>
									<td width="14.28%" align="center">开始时间</td>
									<td width="14.28%" align="center">结束时间</td>
									<td width="14.28%" align="center">天数</td>
									<td width="14.28%" align="center">审批状态</td>
									<td width="14.28%" align="center">原因</td>
									<td width="14.28%" align="center">操作</td>
								</tr>
								<c:forEach items="${allRest}" var="rest">
									<tr >
										<td align="center">${rest.applyName}</td>
										<td align="center">${rest.startTime }</td>
										<td align="center">${rest.endTime }</td>
										<td align="center">${rest.days }</td>
										<c:if test="${rest.state==0}">
											<td align="center" >未审核</td>
										</c:if>
										<c:if test="${rest.state==1}">
											<td align="center">审核通过</td>
										</c:if>
										<c:if test="${rest.state==2}">
											<td align="center">审核拒绝</td>
										</c:if>
										<td align="center">${rest.reason }</td>
										<c:if test="${rest.state==0}">
										<td align="center" ><a href="javascript:void(0)" onclick="details(${rest.id})">[审核]</a></td>		
										</c:if>
									</tr>
								</c:forEach>
								</c:if>
								<c:if test="${sessionUser.isadmin==1 }">
								<tr bgcolor="gray">
									<td width="16.67%" align="center">申请人</td>
									<td width="16.67%" align="center">开始时间</td>
									<td width="16.67%" align="center">结束时间</td>
									<td width="16.67%" align="center">天数</td>
									<td width="16.67%" align="center">审批状态</td>
									<td width="16.67%" align="center">原因</td>
									
								</tr>
								<c:forEach items="${findRest}" var="rest">
									<tr onclick="details(${rest.id})">
										<td align="center" >${sessionUser.nickname}</td>
										<td align="center" >${rest.startTime }</td>
										<td align="center" >${rest.endTime }</td>
										<td align="center" >${rest.days }</td>
										<c:if test="${rest.state==0}">
											<td align="center">未审核</td>
										</c:if>
										<c:if test="${rest.state==1}">
											<td align="center">审核通过</td>
										</c:if>
										<c:if test="${rest.state==2}">
											<td align="center">审核拒绝</td>
										</c:if>
										<td align="center" onclick="details()">${rest.reason }</td>
									</tr>
								</c:forEach>
								</c:if>
								<c:if test="${sessionUser.isadmin==1 }">
									<tr>
										<td width="16.67%" align="center"><button type="button" onclick="require()">申请休假</button></td>
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