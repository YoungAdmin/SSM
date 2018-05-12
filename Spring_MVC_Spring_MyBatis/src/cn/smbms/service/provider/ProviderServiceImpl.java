package cn.smbms.service.provider;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import cn.smbms.dao.provider.ProviderMapper;
import cn.smbms.pojo.Provider;

@Service
public class ProviderServiceImpl implements ProviderService {

	@Resource
	ProviderMapper providerMapper;
	
	@Override
	public List<Provider> getProviderList(String proCode, String proName,
			int currentPageNo, int pageSize) {
		try {
			return providerMapper.getProviderList(proCode, proName, (currentPageNo-1)*pageSize, pageSize);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public int getProviderCount(String proName, String proCode) {
		try {
			return providerMapper.getProviderCount(proCode, proName);
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public boolean addProvider(Provider provider) {
		try {
			if(providerMapper.addProvider(provider) == 1)
				return true;
			else
				return false;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public Provider getProviderById(String id) {
		try {
			return providerMapper.getProviderById(id);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public boolean updateProvider(Provider provider) {
		try {
			if(providerMapper.updateProvider(provider) == 1)
				return true;
			else
				return false;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean deleteProviderById(String id) {
		try {
			if(providerMapper.deleteProviderById(id) == 1)
				return true;
			else
				return false;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}
