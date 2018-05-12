<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/jsp/common/head.jsp"%>
    <div class="right">
        <div class="location">
            <strong>你现在所在的位置是:</strong>
            <span>用户管理页面 >> 用户修改页面</span>
        </div>
        <div class="providerAdd">
        <form id="userForm"  enctype="multipart/form-data" name="userForm" method="post" action="${pageContext.request.contextPath }/user/usermodifysave.html">
			<input type="hidden" name="method" value="modifyexe">
			<input type="hidden" name="id" value="${user.id }"/>
			 <div>
                    <label for="userName">用户名称：</label>
                    <input type="text" name="userName" id="userName" value="${user.userName }"> 
					<font color="red"></font>
             </div>
			 <div>
                    <label >用户性别：</label>
                    <select name="gender" id="gender">
						<c:choose>
							<c:when test="${user.gender == 1 }">
								<option value="1" selected="selected">男</option>
					    		<option value="2">女</option>
							</c:when>
							<c:otherwise>
								<option value="1">男</option>
					    		<option value="2" selected="selected">女</option>
							</c:otherwise>
						</c:choose>
					 </select>
             </div>
			 <div>
                    <label for="data">出生日期：</label>
                    <input type="text" Class="Wdate" id="birthday" name="birthday" value="${user.birthday }"
					readonly="readonly" onclick="WdatePicker();">
                    <font color="red"></font>
              </div>
			
		       <div>
                    <label for="userphone">用户电话：</label>
                    <input type="text" name="phone" id="phone" value="${user.phone }"> 
                    <font color="red"></font>
               </div>
                <div>
                    <label for="userAddress">用户地址：</label>
                    <input type="text" name="address" id="address" value="${user.address }">
                </div>
				<div>
                    <label >用户角色：</label>
                    <!-- 列出所有的角色分类 -->
<%-- 					<input type="hidden" value="${user.userRole }" id="rid" /> --%>
<!-- 					<select name="userRole" id="userRole"></select> -->
						<select name="userRole" id="userRole">
							<c:choose>
								<c:when test="${user.userRole == 1 }">
									<option value="1" selected="selected">系统管理员</option>
									<option value="2">经理</option>
									<option value="3">普通用户</option>
								</c:when>
								<c:when test="${user.userRole == 2 }">
									<option value="1">系统管理员</option>
									<option value="2"  selected="selected">经理</option>
									<option value="3">普通用户</option>
								</c:when>
								<c:when test="${user.userRole == 3 }">
									<option value="1">系统管理员</option>
									<option value="2">经理</option>
									<option value="3" selected="selected">普通用户</option>
								</c:when>
							</c:choose>
						</select>
        			<font color="red"></font>
                </div>
               <div>
                	<input type="hidden" id="errorinfo" value="${uploadFileError }">
                	<label for="attachs">证件照：</label>
                	<c:if test="${!empty user.idPicPath}">
                		<img width="350px" height="250px" src="${pageContext.request.contextPath }/statics/uploadfiles/${user.idPicPath}">
                		<input value="${pageContext.request.contextPath }/statics/uploadfiles/${user.idPicPath}" type="file" hidden="true" name="attachs" id="a_idPicPath">
                		<input value="${pageContext.request.contextPath }/statics/uploadfiles/${user.idPicPath}" type="hidden" name="idPicPath">
                	</c:if>
                	<c:if test="${empty user.idPicPath}"><input type="file" name="attachs" id="a_idPicPath"></c:if>
                	<font color="red"></font>
                </div>
                <div>
                	<input type="hidden" id="errorinfo_wp" value="${uploadFileError }">
                	<label for="a_workPicPath">工作证照片：</label>
                	<c:if test="${!empty user.workPicPath}">
                		<img width="350px" height="250px" src="${pageContext.request.contextPath }/statics/uploadfiles/${user.workPicPath}">
                		<input value="${pageContext.request.contextPath }/statics/uploadfiles/${user.workPicPath}" type="hidden" name="idPicPath">
                	</c:if>
                	<c:if test="${empty user.workPicPath}"><input type="file" name="attachs" id="a_workPicPath"></c:if>
                	<font color="red"></font>
                </div>
			 <div class="providerAddBtn">
                    <input type="button" name="save" id="save" value="保存" />
                    <input type="button" id="back" name="back" value="返回"/>
                </div>
            </form>
        </div>
    </div>
</section>
<%@include file="/WEB-INF/jsp/common/foot.jsp" %>
<script type="text/javascript" src="${pageContext.request.contextPath }/statics/js/usermodify.js"></script>
