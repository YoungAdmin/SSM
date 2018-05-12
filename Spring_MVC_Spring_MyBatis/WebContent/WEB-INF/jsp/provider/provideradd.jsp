<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="fm"%>
<%@include file="/WEB-INF/jsp/common/head.jsp"%>

<div class="right">
        <div class="location">
            <strong>你现在所在的位置是:</strong>
            <span>供应商管理页面 >> 供应商添加页面</span>
        </div>
        <div class="providerAdd">
        	<fm:form method="POST" enctype="multipart/form-data" modelAttribute="provider" action="${pageContext.request.contextPath }/provider/addsave.html">
        	 	<div>
                    <label for="proCode">供应商编码：</label>
                    <fm:input path="proCode" value=""/>
					<font color="red"><fm:errors path="proCode"/></font>
                </div>
        		 <div>
                    <label for="proName">供应商名称：</label>
                    <fm:input path="proName" value=""/>
					<font color="red"><fm:errors path="proName"/></font>
                </div>
                <div>
                    <label for="proContact">联系人：</label>
                    <fm:input path="proContact" value=""/>
					<font color="red"><fm:errors path="proContact"/></font>
                </div>
                <div>
                    <label for="proPhone">联系电话：</label>
                  	<fm:input path="proPhone" value=""/>
					<font color="red"><fm:errors path="proPhone"/></font>
                </div>
                <div>
                    <label for="proAddress">联系地址：</label>
                   	<fm:input path="proAddress" value=""/>
                </div>
                <div>
                    <label for="proFax">传真：</label>
                  	<fm:input path="proFax"  value=""/>
                </div>
                <div>
                    <label for="proDesc">描述：</label>
                    <fm:input path="proDesc" value=""/>
                </div>
                <div>
                	<input type="hidden" id="errorinfo" value="${uploadFileError }">
                	<label for="attachs">营业执照：</label>
                	<input type="file" name="attachs" id="a_idPicPath">
                	<font color="red"></font>
                </div>
                <div>
                	<input type="hidden" id="errorinfo_wp" value="${uploadFileError }">
                	<label for="a_workPicPath">机构代码：</label>
                	<input type="file" name="attachs" id="a_workPicPath">
                	<font color="red"></font>
                </div>
                <div class="providerAddBtn">
                    <input type="submit" name="add" id="add" value="保存">
					<input type="button" id="back" name="back" value="返回" >
                </div>
        	</fm:form>
     </div>
</div>
</section>
<%@include file="/WEB-INF/jsp/common/foot.jsp" %>
<script type="text/javascript" src="${pageContext.request.contextPath }/statics/js/provideradd.js"></script>
