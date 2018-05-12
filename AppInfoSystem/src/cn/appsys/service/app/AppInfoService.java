package cn.appsys.service.app;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.appsys.pojo.AppCategory;
import cn.appsys.pojo.AppInfo;
import cn.appsys.pojo.DataDictionary;

public interface AppInfoService {
	
	/**
	 * 带条件查询App信息列表
	 * 
	 * @param appinfo
	 * @return
	 */
	public List<AppInfo> getAppInfoList(String softwareName, Integer status,
			Integer flatformId, Integer categoryLevel1, Integer categoryLevel2,
			Integer categoryLevel3, Integer currentPageNo, Integer pageSize);

	/**
	 * 带条件查询App信息数量
	 * 
	 * @param appinfo
	 * @return
	 */
	public int getAppInfoCount(String softwareName, Integer status,
			Integer flatformId, Integer categoryLevel1, Integer categoryLevel2,
			Integer categoryLevel3);
	
	/**
	 * 根据类型查询数据_词典 
	 * @return
	 */
	public List<DataDictionary> getDatadictionarylist(String typeCode);
	
	/**
	 * 查询分类列表
	 * @return
	 */
	public List<AppCategory> getAppCategoryList(Integer pid);
	
	/**
	 * 通过APKName查询记录数
	 * @param APKName
	 * @return
	 */
	public boolean getApkexistByAPKName(@Param("APKName")String APKName);
	
	/**
	 * 新增APP信息
	 * @param appInfo
	 * @return
	 * @throws Exception
	 */
	public boolean addAppInfo(AppInfo appInfo);
	
	/**
	 * 通过id查询APP信息
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public AppInfo getAppInfoById(Integer id);
	
	/**
	 * 通过id修改Path
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public boolean updatePathById(Integer id);
	
	/**
	 * 更新APP信息
	 * @param appInfo
	 * @return
	 * @throws Exception
	 */
	public boolean updateAppInfo(AppInfo appInfo);
	
	/**
	 * 修改APP最新版本信息
	 * @param versionId
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public boolean updateAppInfoOfVersionIdById(Integer versionId,Integer id);
	
	/**
	 * 根据ID删除APP信息 
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public boolean deleteAppInfoById(Integer id);
	
	
	/**
	 * 根据ID修改APP状态
	 * @param status
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public boolean updateAppInfoOfStatusById(Integer status,Integer id);
}
