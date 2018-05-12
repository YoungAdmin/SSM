package cn.smbms.dao.provider;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.smbms.pojo.Provider;
public interface ProviderMapper {

	/**
	 * 通过条件查询-providerList
	 * @param proCode
	 * @param proName
	 * @param currentPageNo
	 * @param pageSize
	 * @return
	 * @throws Exception
	 */
	public List<Provider> getProviderList(@Param("proCode")String proCode,@Param("proName")String proName,@Param("from")int from, @Param("pageSize")int pageSize)throws Exception;
	/**
	 * 通过条件查询-供应商表记录数
	 * @param userName
	 * @param userRole
	 * @return
	 * @throws Exception
	 */
	public int getProviderCount(@Param("proCode")String proCode,@Param("proName")String proName)throws Exception;
	
	/**
	 * 添加供应商
	 * @param provider
	 * @return
	 */
	public int addProvider(Provider provider) throws Exception;
	
	/**
	 * 根据id获取供应商信息
	 * @param id
	 * @return
	 */
	public Provider getProviderById(@Param("id")String id) throws Exception;
	
	/**
	 * 修改供应商
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public int updateProvider(Provider provider) throws Exception;
	
	/**
	 * 根据id删除供应商
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public int deleteProviderById(@Param("id")String id) throws Exception;
}
