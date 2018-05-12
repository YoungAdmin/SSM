<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/jsp/common/head.jsp"%>

  <div class="right">
      <div class="location">
          <strong>你现在所在的位置是:</strong>
          <span>供应商管理页面 >> 供应商修改页</span>
      </div>
      <div class="providerAdd">
          <form id="providerForm" enctype="multipart/form-data" name="providerForm" method="post" action="${pageContext.request.contextPath }/provider/providermodifysave.html">
              <!--div的class 为error是验证错误，ok是验证成功-->
              <div class="">
              	  <input type="hidden" name="id" value="${provider.id}">
                  <label for="proCode">供应商编码：</label>
                  <input type="text" name="proCode" id="proCode" value="${provider.proCode }" readonly="readonly"> 
              </div>
              <div>
                  <label for="proName">供应商名称：</label>
                 <input type="text" name="proName" id="proName" value="${provider.proName }"> 
			<font color="red"></font>
              </div>
              
              <div>
                  <label for="proContact">联系人：</label>
                  <input type="text" name="proContact" id="proContact" value="${provider.proContact }"> 
			<font color="red"></font>
              </div>
              
              <div>
                  <label for="proPhone">联系电话：</label>
                  <input type="text" name="proPhone" id="proPhone" value="${provider.proPhone }"> 
			<font color="red"></font>
              </div>
              
              <div>
                  <label for="proAddress">联系地址：</label>
                  <input type="text" name="proAddress" id="proAddress" value="${provider.proAddress }"> 
              </div>
              
              <div>
                  <label for="proFax">传真：</label>
                  <input type="text" name="proFax" id="proFax" value="${provider.proFax }">
              </div>
              
              <div>
                  <label for="proDesc">描述：</label>
                  <input type="text" name="proDesc" id="proDesc" value="${provider.proDesc }"> 
              </div>
              <div>
                	<input type="hidden" id="errorinfo" value="${uploadFileError }">
                	<label for="attachs">营业执照：</label>
                	<c:if test="${!empty provider.companyLicPicPath}">
                		<img width="350px" height="250px" src="${pageContext.request.contextPath }/statics/uploadfiles/${provider.companyLicPicPath}">
                		<input value="${pageContext.request.contextPath }/statics/uploadfiles/${provider.companyLicPicPath}" type="file" hidden="true" name="attachs" id="a_idPicPath">
                		<input value="${pageContext.request.contextPath }/statics/uploadfiles/${provider.companyLicPicPath}" type="hidden"  name="companyLicPicPath">
                	</c:if>
                	<c:if test="${empty provider.companyLicPicPath}"><input type="file" name="attachs" id="a_idPicPath"></c:if>
                	<font color="red"></font>
                </div>
                <div>
                	<input type="hidden" id="errorinfo_wp" value="${uploadFileError }">
                	<label for="a_workPicPath">机构代码：</label>
                	<c:if test="${!empty provider.orgCodePicPath}">
                		<img width="350px" height="250px" src="${pageContext.request.contextPath }/statics/uploadfiles/${provider.orgCodePicPath}">
                		<input value="${pageContext.request.contextPath }/statics/uploadfiles/${provider.orgCodePicPath}" type="hidden"  name="orgCodePicPath">
                	</c:if>
                	<c:if test="${empty provider.orgCodePicPath}"><input type="file" name="attachs" id="a_workPicPath"></c:if>
                	<font color="red"></font>
                </div>
              <div class="providerAddBtn">
                  <input type="button" name="save" id="save" value="保存">
				  <input type="button" id="back" name="back" value="返回" >
              </div>
          </form>
      </div>
  </div>
</section>
<%@include file="/WEB-INF/jsp/common/foot.jsp" %>
<script type="text/javascript" src="${pageContext.request.contextPath }/statics/js/providermodify.js"></script>