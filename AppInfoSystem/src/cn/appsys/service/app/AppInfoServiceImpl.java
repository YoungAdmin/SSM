package cn.appsys.service.app;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.appsys.dao.app.AppInfoMapper;
import cn.appsys.pojo.AppCategory;
import cn.appsys.pojo.AppInfo;
import cn.appsys.pojo.DataDictionary;

@Service
public class AppInfoServiceImpl implements AppInfoService{

	@Resource
	AppInfoMapper appInfoMapper;
	
	@Override
	public List<AppInfo> getAppInfoList(String softwareName, Integer status,
			Integer flatformId, Integer categoryLevel1, Integer categoryLevel2,
			Integer categoryLevel3, Integer currentPageNo, Integer pageSize) {
		try {
			return appInfoMapper.getAppInfoList(softwareName, status, flatformId,
					categoryLevel1, categoryLevel2, categoryLevel3,
					(currentPageNo - 1) * pageSize, pageSize);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public int getAppInfoCount(String softwareName, Integer status,
			Integer flatformId, Integer categoryLevel1, Integer categoryLevel2,
			Integer categoryLevel3) {
		try {
			return appInfoMapper.getAppInfoCount(softwareName, status, flatformId, categoryLevel1, categoryLevel2, categoryLevel3);
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public List<AppCategory> getAppCategoryList(Integer pid) {
		try {
			return appInfoMapper.getAppCategoryList(pid);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<DataDictionary> getDatadictionarylist(String typeCode) {
		try {
			return appInfoMapper.getDatadictionarylist(typeCode);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public boolean getApkexistByAPKName(String APKName) {
		try {
			 if(appInfoMapper.getAppInfoCountByAPKName(APKName) > 0)
				 return true;
			 else
				 return false;
			 
		} catch (Exception e) {
			e.printStackTrace();
			 return false;
		}
	}

	@Override
	public boolean addAppInfo(AppInfo appInfo) {
		try {
			 if(appInfoMapper.addAppInfo(appInfo) > 0)
				 return true;
			 else
				 return false;
			 
		} catch (Exception e) {
			e.printStackTrace();
			 return false;
		}
	}

	@Override
	public AppInfo getAppInfoById(Integer id) {
		try {
			return appInfoMapper.getAppInfoById(id);
		} catch (Exception e) {
			e.printStackTrace();
			 return null;
		}
	}

	@Override
	public boolean updatePathById(Integer id) {
		try {
			 if(appInfoMapper.updatePathById(id) > 0)
				 return true;
			 else
				 return false;
		} catch (Exception e) {
			e.printStackTrace();
			 return false;
		}
	}

	@Override
	public boolean updateAppInfo(AppInfo appInfo) {
		try {
			 if(appInfoMapper.updateAppInfo(appInfo) > 0)
				 return true;
			 else
				 return false;
		} catch (Exception e) {
			e.printStackTrace();
			 return false;
		}
	}

	@Override
	public boolean updateAppInfoOfVersionIdById(Integer versionId, Integer id) {
		try {
			 if(appInfoMapper.updateAppInfoOfVersionIdById(versionId,id) > 0)
				 return true;
			 else
				 return false;
		} catch (Exception e) {
			e.printStackTrace();
			 return false;
		}
	}

	@Override
	public boolean deleteAppInfoById(Integer id) {
		try {
			 if(appInfoMapper.deleteAppInfoById(id) > 0)
				 return true;
			 else
				 return false;
		} catch (Exception e) {
			e.printStackTrace();
			 return false;
		}
	}

	@Override
	public boolean updateAppInfoOfStatusById(Integer status, Integer id) {
		try {
			 if(appInfoMapper.updateAppInfoOfStatusById(status,id) > 0)
				 return true;
			 else
				 return false;
		} catch (Exception e) {
			e.printStackTrace();
			 return false;
		}
	}
}
