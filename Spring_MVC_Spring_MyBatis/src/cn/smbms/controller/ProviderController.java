package cn.smbms.controller;

import java.io.File;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang.math.RandomUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import cn.smbms.pojo.Provider;
import cn.smbms.pojo.User;
import cn.smbms.service.bill.BillService;
import cn.smbms.service.provider.ProviderService;
import cn.smbms.tools.Constants;
import cn.smbms.tools.PageSupport;

@Controller
@RequestMapping("/provider")
public class ProviderController {
	private Logger logger = Logger.getLogger(ProviderController.class);
	
	@Resource
	private ProviderService providerService;
	@Resource
	private BillService billService;
	
	@RequestMapping(value="/providerlist.html")
	public String getProviderList(Model model,
			@RequestParam(value="queryProCode",required=false) String queryProCode,
			@RequestParam(value="queryProName",required=false) String queryProName,
			@RequestParam(value="pageIndex",required=false) String pageIndex) throws Exception{
		logger.info("getProviderList ---- > queryProCode: " + queryProCode);
		logger.info("getProviderList ---- > queryProName: " + queryProName);
		logger.info("getProviderList ---- > pageIndex: " + pageIndex);
		
		List<Provider> providerList = null;
		//设置页面容量
    	int pageSize = Constants.pageSize;
    	//当前页码
    	int currentPageNo = 1;
    	
		if(queryProCode == null){
			queryProCode = "";
		}
		if(queryProName == null){
			queryProName = "";
		}
		
		if(pageIndex != null){
    		try{
    			currentPageNo = Integer.valueOf(pageIndex);
    		}catch(NumberFormatException e){
    			return "redirect:/provider/syserror.html";
    		}
    	}	
		
		//总数量（表）	
    	int totalCount = providerService.getProviderCount(queryProName, queryProCode);
    	System.out.println("=======================>to"+totalCount);
    	//总页数
    	PageSupport pages=new PageSupport();
    	pages.setCurrentPageNo(currentPageNo);
    	pages.setPageSize(pageSize);
    	pages.setTotalCount(totalCount);
    	int totalPageCount = pages.getTotalPageCount();
    	//控制首页和尾页
    	if(currentPageNo < 1){
    		currentPageNo = 1;
    	}else if(currentPageNo > totalPageCount){
    		currentPageNo = totalPageCount;
    	}
    	providerList = providerService.getProviderList(queryProCode, queryProName, currentPageNo, pageSize);
    	model.addAttribute("providerList", providerList);
    	model.addAttribute("queryProCode", queryProCode);
		model.addAttribute("queryProName", queryProName);
		model.addAttribute("totalPageCount", totalPageCount);
		model.addAttribute("totalCount", totalCount);
		model.addAttribute("currentPageNo", currentPageNo);
		return "providerlist";
	}
	

	@RequestMapping(value="/syserror.html")
	public String sysError(){
		return "syserror";
	}
	
	@RequestMapping(value="/provideradd.html",method=RequestMethod.GET)
	public String addProvider(Provider provider,Model model){
		model.addAttribute("provider",provider);
		return "provideradd";
	}
	
	@RequestMapping(value="/addsave.html",method=RequestMethod.POST)
	public String addProvider(Provider provider , HttpSession session, HttpServletRequest request,
				@RequestParam(value = "attachs", required = false) MultipartFile[] attachs){
		System.out.println("============================================================");	
		String idPicPath = null;
		String workPicPath = null;
		String errorInfo = null;
		boolean flag = true;
		String path = request.getSession().getServletContext().getRealPath("statics" + File.separator + "uploadfiles");
		logger.info("uploadFile path ============= >" + path);
		if(attachs != null){
			for (int i = 0;i < attachs.length;i++) {
				MultipartFile attach = attachs[i];
				if (!attach.isEmpty()){
					if(i == 0){
						errorInfo = "uploadFileError";
					}else if(i == 1){
						errorInfo = "uploadWpError";
					}
					String oldFileName = attach.getOriginalFilename();	// 原文件名
					logger.info("uploadFile oldFileName ============= >" + oldFileName);
					String prefix = FilenameUtils.getExtension(oldFileName);	// 原文件后缀
					logger.debug("uploadFile prefix ================ >" + prefix);
					int filesize = 500000;
					logger.debug("uploadFile size ============== >" + attach.getSize());
					if (attach.getSize() > filesize) {
						request.setAttribute("uploadFileError", "* 上传大小不得超过500KB");
						flag = false;
					} else if (prefix.equalsIgnoreCase("jpg") || prefix.equalsIgnoreCase("png") || 
							prefix.equalsIgnoreCase("jpeg") || prefix.equalsIgnoreCase("pneg")){
						String fileName = System.currentTimeMillis() +RandomUtils.nextInt(1000000) + "_Personal.jpg";
						logger.debug("new fileName ==========" + attach.getName());
						File targetFile = new File(path, fileName);
						if (!targetFile.exists()){
							targetFile.mkdirs();
						}
						// 保存
						try{
							attach.transferTo(targetFile);
						} catch (Exception e){
							e.printStackTrace();
							request.setAttribute("uploadFileError", "* 上传失败！");
							flag = false;
						}
						if(i == 0){
							idPicPath = fileName;
						}else if(i == 1){
							workPicPath = fileName;
						}
						logger.debug("idPicPath:" + idPicPath);
						logger.debug("workPicPath:" + workPicPath);
					}else{
						request.setAttribute("uploadFileError", "* 上传图片格式不正确");
						flag = false;
					}
				}
			}
		}
		if(flag){
			provider.setCreatedBy(((User)session.getAttribute(Constants.USER_SESSION)).getId());
			provider.setCreationDate(new Date());
			provider.setCompanyLicPicPath(idPicPath);
			provider.setOrgCodePicPath(workPicPath);
			if (providerService.addProvider(provider)){
				return "redirect:/provider/providerlist.html";
			}
		}
		return "provideradd";
	}
	@RequestMapping(value="/add.html",method=RequestMethod.GET)
	public String add(Provider provider,Model model){
		model.addAttribute("provider",provider);
		return "provideradd";
	}
	
	@RequestMapping(value="/add.html",method=RequestMethod.POST)
	public String addsave(@Valid Provider provider,BindingResult bindingResult,HttpSession session){
		if(bindingResult.hasErrors()){
			return "provideradd";
		}
		provider.setCreatedBy(((User)session.getAttribute(Constants.USER_SESSION)).getId());
		provider.setCreationDate(new Date());
		if(providerService.addProvider(provider)){
			return "redirect:/provider/providerlist.html";
		}
		return "provideradd";
	}
	@RequestMapping(value="/providermodify.html",method=RequestMethod.GET)
	public String providermodify(@RequestParam String proid,Model model){
		logger.debug("providermodify proid==============" + proid);
		Provider provider = providerService.getProviderById(proid);
		model.addAttribute(provider);
		return "providermodify";
	}
	
	@RequestMapping(value="/providermodifysave.html",method=RequestMethod.POST)
	public String providermodifysave(Provider provider,HttpSession session, HttpServletRequest request,
			@RequestParam(value = "attachs", required = false) MultipartFile[] attachs){
		logger.debug("providermodifysave proid==============" + provider.getId());
		String idPicPath = null;
		String workPicPath = null;
		String errorInfo = null;
		boolean flag = true;
		String path = request.getSession().getServletContext().getRealPath("statics" + File.separator + "uploadfiles");
		logger.info("uploadFile path ============= >" + path);
		if(attachs != null){
			for (int i = 0;i < attachs.length;i++) {
				MultipartFile attach = attachs[i];
				if (!attach.isEmpty()){
					if(i == 0){
						if(provider.getCompanyLicPicPath() != null){
							continue;
						}
						errorInfo = "uploadFileError";
					}else if(i == 1){
						if(provider.getOrgCodePicPath() != null){
							continue;
						}
						errorInfo = "uploadWpError";
					}
					String oldFileName = attach.getOriginalFilename();	// 原文件名
					logger.info("uploadFile oldFileName ============= >" + oldFileName);
					String prefix = FilenameUtils.getExtension(oldFileName);	// 原文件后缀
					logger.debug("uploadFile prefix ================ >" + prefix);
					int filesize = 500000;
					logger.debug("uploadFile size ============== >" + attach.getSize());
					if (attach.getSize() > filesize) {
						request.setAttribute("uploadFileError", "* 上传大小不得超过500KB");
						flag = false;
					} else if (prefix.equalsIgnoreCase("jpg") || prefix.equalsIgnoreCase("png") || 
							prefix.equalsIgnoreCase("jpeg") || prefix.equalsIgnoreCase("pneg")){
						String fileName = System.currentTimeMillis() +RandomUtils.nextInt(1000000) + "_Personal.jpg";
						logger.debug("new fileName ==========" + attach.getName());
						File targetFile = new File(path, fileName);
						if (!targetFile.exists()){
							targetFile.mkdirs();
						}
						// 保存
						try{
							attach.transferTo(targetFile);
						} catch (Exception e){
							e.printStackTrace();
							request.setAttribute("uploadFileError", "* 上传失败！");
							flag = false;
						}
						if(i == 0){
							idPicPath = fileName;
						}else if(i == 1){
							workPicPath = fileName;
						}
						logger.debug("idPicPath:" + idPicPath);
						logger.debug("workPicPath:" + workPicPath);
					}else{
						request.setAttribute("uploadFileError", "* 上传图片格式不正确");
						flag = false;
					}
				}
			}
		}
		if(flag){
			provider.setCompanyLicPicPath(idPicPath);
			provider.setOrgCodePicPath(workPicPath);
			provider.setModifyBy(((User)session.getAttribute(Constants.USER_SESSION)).getId());
			provider.setModifyDate(new Date());
			if(providerService.updateProvider(provider)){
				return "redirect:/provider/providerlist.html";
			}
		}
		return "providermodify";
	}
	
	@RequestMapping(value="/view/{id}",method=RequestMethod.GET)
	public String view(@PathVariable String id,Model model){
		logger.debug("view id================" + id);
		Provider provider = providerService.getProviderById(id);
		model.addAttribute(provider);
		return "providerview";
	}
	
	@RequestMapping(value="/deleteProviderById")
	@ResponseBody
	public Object deleteProviderById(@RequestParam String proid, HttpServletRequest request){
		logger.debug("deleteProviderById proid:" + proid);
		HashMap<String, String> resultMap = new HashMap<String, String>();
		int billResult = billService.getBillCountByPid(proid);
		if(billResult > 0){
			resultMap.put("delResult", billResult + "");
			return resultMap;
		}
		Provider provider = providerService.getProviderById(proid);
		if(provider == null){
			resultMap.put("delResult", "notexist");
		}else{
			String fileName = null;
			if(provider.getCompanyLicPicPath()!= null && !"".equals(provider.getCompanyLicPicPath())){
				String path = request.getSession().getServletContext().getRealPath("statics" + File.separator + "uploadfiles");
				fileName = path + File.separator + provider.getCompanyLicPicPath();
				File file = new File(fileName);
		        // 如果文件路径所对应的文件存在，并且是一个文件，则直接删除
		        if (file.exists() && file.isFile()) {
		            if (file.delete()) {
		            	logger.debug("删除单个文件" + fileName + "成功！");
		            } else {
		            	logger.debug("删除单个文件" + fileName + "失败！");
		            }
		        } else {
		        	logger.debug("删除单个文件失败：" + fileName + "不存在！");
		        }
			}
			if(provider.getOrgCodePicPath() != null && !"".equals(provider.getOrgCodePicPath())){
				String path = request.getSession().getServletContext().getRealPath("statics" + File.separator + "uploadfiles");
				fileName = path + File.separator + provider.getOrgCodePicPath();
				File file = new File(fileName);
		        // 如果文件路径所对应的文件存在，并且是一个文件，则直接删除
		        if (file.exists() && file.isFile()) {
		            if (file.delete()) {
		            	logger.debug("删除单个文件" + fileName + "成功！");
		            } else {
		            	logger.debug("删除单个文件" + fileName + "失败！");
		            }
		        } else {
		        	logger.debug("删除单个文件失败：" + fileName + "不存在！");
		        }
			}
			if(providerService.deleteProviderById(proid)){
				resultMap.put("delResult", "true");
			}
		}
		return resultMap;
	}
}
