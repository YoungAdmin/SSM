package cn.smbms.service.provider;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import cn.smbms.pojo.Provider;

public interface ProviderService {
	/**
	 * 通过条件查询供应商表
	 * @param connection
	 * @param proCode
	 * @param proName
	 * @param currentPageNo
	 * @param pageSize
	 * @return
	 * @
	 */
	public List<Provider> getProviderList(String proCode,String proName,int currentPageNo, int pageSize);
	/**
	 * 通过条件查询-供应商表记录数
	 * @param connection
	 * @param userName
	 * @param userRole
	 * @return
	 * @
	 */
	public int getProviderCount(String proName,String proCode);
	
	/**
	 * 添加供应商信息
	 * @param provider
	 * @return
	 */
	public boolean addProvider(Provider provider);
	
	/**
	 * 根据id获取供应商信息
	 * @param connection
	 * @param id
	 * @return
	 */
	public Provider getProviderById(String id)  ;
	
	/**
	 * 修改供应商
	 * @param connection
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public boolean updateProvider(Provider provider);
	
	/**
	 * 根据id删除供应商
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public boolean deleteProviderById(@Param("id")String id);
}
