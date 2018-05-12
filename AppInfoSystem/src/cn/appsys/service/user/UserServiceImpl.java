package cn.appsys.service.user;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.appsys.dao.user.UserMapper;
import cn.appsys.pojo.BackendUser;
import cn.appsys.pojo.DevUser;

@Service
public class UserServiceImpl implements UserService {

	@Resource
	private UserMapper userMapper;

	@Override
	public DevUser getDevUserByUserCode(String devCode) {
		try {
			return userMapper.getDevUserByUserCode(devCode);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	@Resource
	private UserMapper backendUserMapper;

	@Override
	public BackendUser getBackendUserByUserCode(String userCode) {
		try {
			return userMapper.getBackendUserByUserCode(userCode);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
