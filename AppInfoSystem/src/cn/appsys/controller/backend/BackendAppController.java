package cn.appsys.controller.backend;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.appsys.pojo.AppInfo;
import cn.appsys.pojo.AppVersion;
import cn.appsys.service.app.AppInfoService;
import cn.appsys.service.version.AppVersionService;
import cn.appsys.tools.Constants;
import cn.appsys.tools.PageSupport;

@Controller
@RequestMapping(value="/backend/sys/app")
public class BackendAppController {

	@Resource
	private AppInfoService appInfoService;
	
	@Resource
	private AppVersionService appVersionService;

	// 点击APP审核查询APP列表
	@RequestMapping(value = "/list")
	public String GetAppInfolist(
			@RequestParam(value = "querySoftwareName", required = false) String querySoftwareName,
			@RequestParam(value = "queryFlatformId", required = false) Integer queryFlatformId,
			@RequestParam(value = "queryCategoryLevel1", required = false) Integer queryCategoryLevel1,
			@RequestParam(value = "queryCategoryLevel2", required = false) Integer queryCategoryLevel2,
			@RequestParam(value = "queryCategoryLevel3", required = false) Integer queryCategoryLevel3,
			@RequestParam(value = "pageIndex", required = false) Integer pageIndex,
			Model model) {
		// 设置页面容量
		int pageSize = Constants.pageSize;
		// 当前页码
		int currentPageNo = 1;
		if (pageIndex != null) {
			currentPageNo = Integer.valueOf(pageIndex);
		}
		// 总数量（表）
		int totalCount = appInfoService.getAppInfoCount(querySoftwareName,
				1, queryFlatformId, queryCategoryLevel1,
				queryCategoryLevel2, queryCategoryLevel3);
		// 总页数
		PageSupport pages = new PageSupport();
		pages.setCurrentPageNo(currentPageNo);
		pages.setPageSize(pageSize);
		pages.setTotalCount(totalCount);
		int totalPageCount = pages.getTotalPageCount();

		// 控制首页和尾页
		if (currentPageNo < 1) {
			currentPageNo = 1;
		} else if (currentPageNo > totalPageCount) {
			currentPageNo = totalPageCount;
		}
		List<AppInfo> appInfoList = appInfoService.getAppInfoList(
				querySoftwareName, 1, queryFlatformId,
				queryCategoryLevel1, queryCategoryLevel2, queryCategoryLevel3,
				currentPageNo, pageSize);
		model.addAttribute("appInfoList", appInfoList);
		model.addAttribute("querySoftwareName", querySoftwareName);
		model.addAttribute("queryFlatformId", queryFlatformId);
		model.addAttribute("queryCategoryLevel1", queryCategoryLevel1);
		model.addAttribute("queryCategoryLevel2", queryCategoryLevel2);
		model.addAttribute("queryCategoryLevel3", queryCategoryLevel3);
		model.addAttribute("statusList",appInfoService.getDatadictionarylist("APP_STATUS"));
		model.addAttribute("flatFormList",appInfoService.getDatadictionarylist("APP_FLATFORM"));
		model.addAttribute("categoryLevel1List",appInfoService.getAppCategoryList(null));
		if (queryCategoryLevel1 != null)
			model.addAttribute("categoryLevel2List",appInfoService.getAppCategoryList(queryCategoryLevel1));
		if (queryCategoryLevel2 != null)
			model.addAttribute("categoryLevel3List",appInfoService.getAppCategoryList(queryCategoryLevel2));
		model.addAttribute("pages", pages);
		return "backend/applist";
	}
	
	// 二三级分类异步加载
	@RequestMapping(value = "/categorylevellist.json")
	@ResponseBody
	public Object getCategorylevellist(
			@RequestParam(value = "pid", required = false) Integer pid) {
		return appInfoService.getAppCategoryList(pid);
	}
	
	// 审核APP
	@RequestMapping(value = "/check")
	public String check(@RequestParam(value = "aid", required = false) Integer aid,
			@RequestParam(value = "vid", required = false) Integer vid,
			Model model) {
		AppInfo appInfo = appInfoService.getAppInfoById(aid);
		AppVersion appVersion = appVersionService.getAppVersionById(vid);
		model.addAttribute("appInfo",appInfo);
		model.addAttribute("appVersion",appVersion);
		return "backend/appcheck";
	}
	
	// 保存审核
	@RequestMapping(value = "/checksave")
	public String checksave(@RequestParam(value = "id", required = false) Integer id,
			@RequestParam(value = "status", required = false) Integer status){
		if(appInfoService.updateAppInfoOfStatusById(status, id)){
			return "redirect:/backend/sys/app/list";
		}else{
			return "redirect:/backend/sys/app/check";
		}
	}
}
