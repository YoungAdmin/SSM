package cn.appsys.dao.version;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.appsys.pojo.AppVersion;

public interface AppVersionMapper {

	/**
	 * 新增版本信息
	 * @param appVersion
	 * @return
	 * @throws Exception
	 */
	public int addAppVersion(AppVersion appVersion) throws Exception;
	
	/**
	 * 根据APPid查询-APP版本信息 
	 * @param appVersion
	 * @return
	 * @throws Exception
	 */
	public List<AppVersion> getAppVersionListByAppId(@Param("aid")Integer id) throws Exception;
	
	/**
	 * 查询最新版本的自增ID
	 * @return
	 * @throws Exception
	 */
	public int getNewId() throws Exception;
	
	/**
	 * 根据id查询版本信息
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public AppVersion getAppVersionById(@Param("id")Integer id) throws Exception;

	/**
	 * 通过id修改Path
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public int updateAppVersionOfPathById(@Param("id")Integer id) throws Exception;
	
	/**
	 * 修改版本信息
	 * @param appVersion
	 * @return
	 * @throws Exception
	 */
	public int updateAppVersion(AppVersion appVersion) throws Exception;
	
	/**
	 * 根据APPID删除版本信息
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public int deleteAppVersionByAId(@Param("aid")Integer aid) throws Exception;
}
