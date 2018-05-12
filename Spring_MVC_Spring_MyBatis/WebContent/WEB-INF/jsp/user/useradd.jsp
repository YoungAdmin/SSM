<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="fm" %>
<%@include file="/WEB-INF/jsp/common/head.jsp"%>

<div class="right">
	<div class="location">
	    <strong>你现在所在的位置是:</strong>
	    <span>用户管理页面 >> 用户添加页面</span>
	</div>
	<div class="providerAdd">
	 <fm:form method="post" modelAttribute="user" action="${pageContext.request.contextPath }/user/add.html">
	 
		<fm:errors path="userCode"/><br/>
		用户编码：<fm:input path="userCode"/><br/>
		
		<fm:errors path="userName"/><br/>
	 	用户名称：<fm:input path="userName"/><br/>
	 	
	 	<fm:errors path="userPassword"/><br/>
	 	用户密码：<fm:password path="userPassword"/><br/>
	 	
	 	性别：
	 	<fm:radiobutton path="gender" value="1" checked="checked"/>男
	 	<fm:radiobutton path="gender" value="2"/>女
	 	<br/>
	 	
	 	<fm:errors path="birthday"/><br/>
	 	用户生日：<fm:input path="birthday" Class="Wdate" readonly="readonly" onclick="WdatePicker();"/><br/>
	 	
	 	用户地址：<fm:input path="address"/><br/>
	 	
	 	联系电话：<fm:input path="phone"/><br/>
	 	
	 	用户角色：
	 	<fm:radiobutton path="userRole" value="1"/>系统管理员
	 	<fm:radiobutton path="userRole" value="2"/>经理
	 	<fm:radiobutton path="userRole" value="3" checked="checked"/>普通用户
	 	<br/>
	 	<input type="submit" value="保存"/>
	 </fm:form>
	</div>
</div>
</section>
<%@include file="/WEB-INF/jsp/common/foot.jsp" %>
<script type="text/javascript" src="${pageContext.request.contextPath }/statics/js/useradd.js"></script>
