package cn.smbms.service.user;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import cn.smbms.dao.user.UserMapper;
import cn.smbms.pojo.User;

@Service
public class UserServiceImpl implements UserService {

	@Resource
	private UserMapper userMapper;

	@Override
	public User login(String userCode, String userPassword){
		try {
			return userMapper.getLoginUser(userCode);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public boolean add(User user){
		try {
			if (userMapper.add(user) == 1)
				return true;
			else
				return false;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public List<User> getUserList(String queryUserName, int queryUserRole,
			int currentPageNo, int pageSize){
		try {
			return userMapper.getUserList(queryUserName, queryUserRole, (currentPageNo-1)*pageSize, pageSize);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public int getUserCount(String queryUserName, int queryUserRole){
		try {
			return userMapper.getUserCount(queryUserName, queryUserRole);
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public User selectUserCodeExist(String userCode) {
		try {
			return userMapper.getLoginUser(userCode);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public boolean deleteUserById(Integer delId) {
		try {
			if (userMapper.deleteUserById(delId) == 1)
				return true;
			else
				return false;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public User getUserById(String id) {
		try {
			return userMapper.getUserById(id);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public boolean modify(User user) {
		try {
			if (userMapper.modify(user) == 1)
				return true;
			else
				return false;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean updatePwd(int id, String pwd) {
		try {
			if (userMapper.updatePwd(id,pwd) == 1)
				return true;
			else
				return false;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}
