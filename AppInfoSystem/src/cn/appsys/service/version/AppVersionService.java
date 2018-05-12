package cn.appsys.service.version;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.appsys.pojo.AppVersion;

public interface AppVersionService {
	
	/**
	 * 新增版本信息
	 * @param appVersion
	 * @return
	 * @throws Exception
	 */
	public boolean addAppVersion(AppVersion appVersion);
	
	/**
	 * 根据APPid查询-APP版本信息 
	 * @param appVersion
	 * @return
	 * @throws Exception
	 */
	public List<AppVersion> getAppVersionListByAppId(Integer id);
	
	/**
	 * 查询最新版本的自增ID
	 * @return
	 * @throws Exception
	 */
	 public int getNewId();
	 
	 /**
	 * 根据id查询版本信息
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public AppVersion getAppVersionById(Integer id);
	

	/**
	 * 通过id修改Path
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public boolean updateAppVersionOfPathById(Integer id);
	

	/**
	 * 修改版本信息
	 * @param appVersion
	 * @return
	 * @throws Exception
	 */
	public boolean updateAppVersion(AppVersion appVersion);
	
	/**
	 * 根据APPID删除版本信息
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public boolean deleteAppVersionByAId(Integer aid);
}