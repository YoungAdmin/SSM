package cn.appsys.dao.user;

import org.apache.ibatis.annotations.Param;
import cn.appsys.pojo.BackendUser;
import cn.appsys.pojo.DevUser;

public interface UserMapper {

	/**
	 * 通过DevUser查询用户信息
	 * @param userCode
	 * @return
	 * @throws Exception
	 */
	public DevUser getDevUserByUserCode(@Param("devCode")String devCode) throws Exception;
	
	/**
	 * 通过userCode查询用户信息
	 * @param userCode
	 * @return
	 * @throws Exception
	 */
	public BackendUser getBackendUserByUserCode(@Param("userCode")String userCode) throws Exception;
}
