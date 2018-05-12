package cn.appsys.dao.app;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.appsys.pojo.AppCategory;
import cn.appsys.pojo.AppInfo;
import cn.appsys.pojo.DataDictionary;

public interface AppInfoMapper {

	/**
	 * 带条件查询App信息列表
	 * @param appinfo
	 * @return
	 */
	public List<AppInfo> getAppInfoList(@Param("softwareName")String softwareName,
			@Param("status")Integer status,
			@Param("flatformId")Integer flatformId,
			@Param("categoryLevel1")Integer categoryLevel1,
			@Param("categoryLevel2")Integer categoryLevel2,
			@Param("categoryLevel3")Integer categoryLevel3,
			@Param("from")Integer from,@Param("pageSize")Integer pageSize) throws Exception;
	
	/**
	 * 带条件查询App信息数量
	 * @param appinfo
	 * @return
	 */
	public int getAppInfoCount(@Param("softwareName")String softwareName,
			@Param("status")Integer status,
			@Param("flatformId")Integer flatformId,
			@Param("categoryLevel1")Integer categoryLevel1,
			@Param("categoryLevel2")Integer categoryLevel2,
			@Param("categoryLevel3")Integer categoryLevel3) throws Exception;
	
	/**
	 * 根据类型查询数据_词典 
	 * @return
	 */
	public List<DataDictionary> getDatadictionarylist(@Param("typeCode")String typeCode) throws Exception;
	
	/**
	 * 查询分类列表
	 * @return
	 */
	public List<AppCategory> getAppCategoryList(@Param("parentId")Integer parentId) throws Exception;
	
	/**
	 * 通过APKName查询记录数
	 * @param APKName
	 * @return
	 */
	public int getAppInfoCountByAPKName(@Param("APKName")String APKName) throws Exception;

	/**
	 * 新增APP信息
	 * @param appInfo
	 * @return
	 * @throws Exception
	 */
	public int addAppInfo(AppInfo appInfo) throws Exception;
	
	/**
	 * 通过id查询APP信息
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public AppInfo getAppInfoById(@Param("id")Integer id) throws Exception;
	
	/**
	 * 通过id修改Path
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public int updatePathById(@Param("id")Integer id) throws Exception;
	
	/**
	 * 更新APP信息
	 * @param appInfo
	 * @return
	 * @throws Exception
	 */
	public int updateAppInfo(AppInfo appInfo) throws Exception;
	

	/**
	 * 修改APP最新版本信息
	 * @param versionId
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public int updateAppInfoOfVersionIdById(@Param("versionId")Integer versionId,@Param("id")Integer id) throws Exception;
	
	/**
	 * 根据ID删除APP信息 
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public int deleteAppInfoById(@Param("id")Integer id) throws Exception;
	
	/**
	 * 根据ID修改APP状态
	 * @param status
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public int updateAppInfoOfStatusById(@Param("status")Integer status,@Param("id")Integer id) throws Exception;
}
