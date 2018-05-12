package cn.smbms.pojo;

import java.util.Date;
import java.util.List;

import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * 供应商信息
 * @author qq943
 *
 */
public class Provider {
	private Integer id;					//编号
	@NotEmpty(message="供应商编码不能为空")
	private String proCode;				//供应商编号
	@NotEmpty(message="供应商名称不能为空")
	private String proName;				//供应商名称
	private String proDesc;				//供应商详细描述
	@NotEmpty(message="联系人不能为空")
	private String proContact;			//供应商联系人
	@Pattern(regexp="^1[3|4|5|8][0-9]\\d{6,8}$",message="请输入正确格式的手机号")
	private String proPhone;			//联系电话
	private String proAddress;			//地址
	private String proFax;				//传真
	private Integer createdBy;			//创建者
	private Date creationDate;			//创建时间
	private Date modifyDate;			//更新时间
	private Integer modifyBy;			//更新者
	private String companyLicPicPath;	//营业执照
	private String orgCodePicPath;		//代码证
	private List<Bill> billList;		//商品集合
	
	public Provider() {
		super();
	}
	public Provider(Integer id, String proCode, String proName, String proDesc,
			String proContact, String proPhone, String proAddress,
			String proFax, Integer createdBy, Date creationDate,
			Date modifyDate, Integer modifyBy,String companyLicPicPath,String orgCodePicPath) {
		super();
		this.id = id;
		this.proCode = proCode;
		this.proName = proName;
		this.proDesc = proDesc;
		this.proContact = proContact;
		this.proPhone = proPhone;
		this.proAddress = proAddress;
		this.proFax = proFax;
		this.createdBy = createdBy;
		this.creationDate = creationDate;
		this.modifyDate = modifyDate;
		this.modifyBy = modifyBy;
		this.companyLicPicPath = companyLicPicPath;
		this.orgCodePicPath = orgCodePicPath;
	}
	
	
	public String getCompanyLicPicPath() {
		return companyLicPicPath;
	}
	public void setCompanyLicPicPath(String companyLicPicPath) {
		this.companyLicPicPath = companyLicPicPath;
	}
	public String getOrgCodePicPath() {
		return orgCodePicPath;
	}
	public void setOrgCodePicPath(String orgCodePicPath) {
		this.orgCodePicPath = orgCodePicPath;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getProCode() {
		return proCode;
	}
	public void setProCode(String proCode) {
		this.proCode = proCode;
	}
	public String getProName() {
		return proName;
	}
	public void setProName(String proName) {
		this.proName = proName;
	}
	public String getProDesc() {
		return proDesc;
	}
	public void setProDesc(String proDesc) {
		this.proDesc = proDesc;
	}
	public String getProContact() {
		return proContact;
	}
	public void setProContact(String proContact) {
		this.proContact = proContact;
	}
	public String getProPhone() {
		return proPhone;
	}
	public void setProPhone(String proPhone) {
		this.proPhone = proPhone;
	}
	public String getProAddress() {
		return proAddress;
	}
	public void setProAddress(String proAddress) {
		this.proAddress = proAddress;
	}
	public String getProFax() {
		return proFax;
	}
	public void setProFax(String proFax) {
		this.proFax = proFax;
	}
	public Integer getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(Integer createdBy) {
		this.createdBy = createdBy;
	}
	public Date getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
	public Date getModifyDate() {
		return modifyDate;
	}
	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}
	public Integer getModifyBy() {
		return modifyBy;
	}
	public void setModifyBy(Integer modifyBy) {
		this.modifyBy = modifyBy;
	}
	public List<Bill> getBillList() {
		return billList;
	}
	public void setBillList(List<Bill> billList) {
		this.billList = billList;
	}
	
}
