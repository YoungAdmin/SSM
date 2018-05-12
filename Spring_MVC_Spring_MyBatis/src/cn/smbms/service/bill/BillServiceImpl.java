package cn.smbms.service.bill;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.smbms.dao.bill.BillMapper;

@Service
public class BillServiceImpl implements BillService{

	@Resource
	private BillMapper billMapper;
	
	@Override
	public int getBillCountByPid(String pid) {
		try {
			return billMapper.getBillCountByPid(pid);
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public boolean deleteBillByPid(String pid) {
		try {
			if(billMapper.deleteBillByPid(pid) > 0)
				return true;
			else{
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

}
