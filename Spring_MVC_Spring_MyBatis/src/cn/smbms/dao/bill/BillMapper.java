package cn.smbms.dao.bill;

import org.apache.ibatis.annotations.Param;

public interface BillMapper {

	/**
	 * 根据供应商id查询订单数量
	 * @param pid
	 * @return
	 * @throws Exception
	 */
	public int getBillCountByPid(@Param("id")String pid) throws Exception;
	
	/**
	 * 根据供应商id删除订单
	 * @param pid
	 * @return
	 * @throws Exception
	 */
	public int deleteBillByPid(@Param("id")String pid) throws Exception;
}
