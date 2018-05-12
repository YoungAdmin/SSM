package cn.appsys.service.version;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.appsys.dao.version.AppVersionMapper;
import cn.appsys.pojo.AppVersion;

@Service
public class AppVersionServiceImpl implements AppVersionService {
	
	@Resource
	AppVersionMapper appVersionMapper;

	@Override
	public boolean addAppVersion(AppVersion appVersion) {
		try {
			if(appVersionMapper.addAppVersion(appVersion) == 1)
				return true;
			else
				return false;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public List<AppVersion> getAppVersionListByAppId(Integer id) {
		try {
			return appVersionMapper.getAppVersionListByAppId(id);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public int getNewId() {
		try {
			return appVersionMapper.getNewId();
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
	}

	@Override
	public AppVersion getAppVersionById(Integer id) {
		try {
			return appVersionMapper.getAppVersionById(id);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public boolean updateAppVersionOfPathById(Integer id) {
		try {
			 if(appVersionMapper.updateAppVersionOfPathById(id) > 0)
				 return true;
			 else
				 return false;
			 
		} catch (Exception e) {
			e.printStackTrace();
			 return false;
		}
	}

	@Override
	public boolean updateAppVersion(AppVersion appVersion) {
		try {
			 if(appVersionMapper.updateAppVersion(appVersion) > 0)
				 return true;
			 else
				 return false;
		} catch (Exception e) {
			e.printStackTrace();
			 return false;
		}
	}

	@Override
	public boolean deleteAppVersionByAId(Integer aid) {
		try {
			 if(appVersionMapper.deleteAppVersionByAId(aid) > 0)
				 return true;
			 else
				 return false;
		} catch (Exception e) {
			e.printStackTrace();
			 return false;
		}
	}
}
