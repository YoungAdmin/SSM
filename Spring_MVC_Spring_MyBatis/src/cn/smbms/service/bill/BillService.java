package cn.smbms.service.bill;

import org.apache.ibatis.annotations.Param;

public interface BillService {
	
	/**
	 * 根据供应商id查询订单数量
	 * @param pid
	 * @return
	 * @throws Exception
	 */
	public int getBillCountByPid(@Param("id")String pid);
	
	/**
	 * 根据供应商id删除订单
	 * @param pid
	 * @return
	 * @throws Exception
	 */
	public boolean deleteBillByPid(@Param("id")String pid);
}
