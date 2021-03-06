package com.info.admin.controller.proportionsdetailetail;

import com.info.admin.controller.base.BaseController;
import com.info.admin.entity.ProportionsDetailetail;
import com.info.admin.entity.ProportionsMaterial;
import com.info.admin.result.JsonResult;
import com.info.admin.result.JsonResultCode;
import com.info.admin.service.ProportionsDetailetailService;
import com.info.admin.utils.PageUtil;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author administrator  
 * @date 2018-11-14 23:45:42 
 * @describe 配合比详情 Controller
 */
@Controller
@RequestMapping("/admin/proportionsDetailetail")
public class ProportionsDetailetailController extends BaseController{	
	
    private static final Logger logger = LoggerFactory.getLogger(ProportionsDetailetailController.class);

    @Autowired
    private ProportionsDetailetailService service;
    
     /**
     *查询配合比详情列表
     *@author   ysh
     *@date  2018-07-12 10:50:32
     *@updater  or other
     *@return   String
     */
    @RequestMapping(value = "/list", method = { RequestMethod.GET, RequestMethod.POST })
    @RequiresPermissions("proportionsDetailetail:query")
    public String getProportionsDetailetailList(HttpServletRequest request, @ModelAttribute ProportionsDetailetail entity, Model model) {
        logger.info("[ProportionsDetailetailController][getProportionsDetailetailList] 查询配合比详情列表:");
        // 获取分页当前的页码
        int currentPageNum = this.getPageNum(request);
        // 获取分页的大小
        int currentPageSize = this.getPageSize(request);
        PageUtil paginator = service.pageQuery(entity, currentPageNum, currentPageSize);
        model.addAttribute("paginator", paginator);
        model.addAttribute("proportionsDetailetail", entity);
        return "proportionsdetailetail/listProportionsDetailetail";
    }

     /**
     *我的桌面查询配合比详情列表
     *@author   ysh
     *@date  2018-07-12 10:50:32
     *@updater  or other
     *@return   String
     */
    @RequestMapping(value = "/list/desktop", method = { RequestMethod.GET, RequestMethod.POST })
    @RequiresPermissions("proportionsDetailetail:query")
    public String getProportionsDetailetailListDesktop(HttpServletRequest request, @ModelAttribute ProportionsDetailetail entity, Model model) {
        logger.info("[ProportionsDetailetailController][getProportionsDetailetailListDesktop] 我的桌面查询配合比详情列表:");
        // 获取分页当前的页码
        int currentPageNum = this.getPageNum(request);
        // 获取分页的大小
        int currentPageSize = this.getPageSize(request);
        PageUtil paginator = service.pageQuery(entity, currentPageNum, currentPageSize);
        model.addAttribute("paginator", paginator);
        model.addAttribute("proportionsDetailetail", entity);
        return "proportionsdetailetail/listProportionsDetailetailDesktop";
    }

    /**
     *跳转到新增页面
     *@author
     *@date  2018-07-12 10:50:32
     *@updater  or other
     *@return   String
     */
    @RequestMapping(value="/addOrEdit",method={RequestMethod.GET,RequestMethod.POST})
    public String addOrEdit(HttpServletRequest request,String detailId,Model model){
        try{
            if(null != detailId && StringUtils.isNotBlank(detailId)){
                //根据id查询系统用户
                ProportionsDetailetail proportionsDetailetail = service.getProportionsDetailetailById(detailId);
                model.addAttribute("proportionsDetailetail", proportionsDetailetail);
            }
            List<ProportionsMaterial> proportionsMaterial = service.getProportionsMaterialById(detailId);
            model.addAttribute("detailId", detailId);
            model.addAttribute("proportionsMaterial", proportionsMaterial);
            return "proportionsdetailetail/addProportionsDetailetail";
        }catch(Exception e){
            logger.error("[ProportionsDetailetailController][addOrEdit]: detailId="+detailId, e);
            return "500";
        }
    }

    /**
     * 新增或者修改ProportionsDetailetail对象
     * @param    request  请求
     * @param    entity  对象
     * @author   ysh
     * @date   2018-11-14 23:45:42 
     * @updater  or other
     * @return   com.netcai.admin.result.JsonResult
     */
    @ResponseBody
    @RequestMapping(value = "insertAndUpdate", method = { RequestMethod.GET, RequestMethod.POST })
    public JsonResult insertAndUpdate(HttpServletRequest request,ProportionsDetailetail entity) {
        logger.info("[ProportionsDetailetailController][insertAndUpdate] 新增或者修改ProportionsDetailetail对象:");
        try {
            int result;
            if (null == entity) {
                return new JsonResult(JsonResultCode.FAILURE, "请输入数据", "");
            }

            // 通过id来判断是新增还是修改
            if (null != entity.getDetailId() && StringUtils.isNotBlank(entity.getDetailId())) {
                result = service.update(entity);
            } else {
                result = service.insert(entity);
            }
            if (result > 0) {
                return new JsonResult(JsonResultCode.SUCCESS, "操作成功", "");
            } else {
                return new JsonResult(JsonResultCode.FAILURE, "操作失败", "");
            }
        } catch (Exception e) {
            logger.error("[ProportionsDetailetailController][insertAndUpdate] exception", e);
            return new JsonResult(JsonResultCode.FAILURE, "系统异常，请稍后再试", "");
        }
    }

    /**
     * 查询ProportionsDetailetail对象
     * @param    entity  对象
     * @author   ysh
     * @date   2018-11-14 23:45:42 
     * @updater  or other
     * @return   com.netcai.admin.result.JsonResult
     */
    @ResponseBody
    @RequestMapping(value = "query", method = { RequestMethod.GET, RequestMethod.POST })
    public JsonResult query(ProportionsDetailetail entity) {
        logger.info("[ProportionsDetailetailController][query] 查询ProportionsDetailetail对象:");
        try {
            return new JsonResult(JsonResultCode.SUCCESS, "操作成功", service.query(entity));
        } catch (Exception e) {
            logger.error("[ProportionsDetailetailController][query] exception", e);
            return new JsonResult(JsonResultCode.FAILURE, "系统异常，请稍后再试", "");
        }
    }

    /**
     * 删除ProportionsDetailetail对象
     * @param    entity  对象
     * @author   ysh
     * @date   2018-11-14 23:45:42 
     * @updater  or other
     * @return   com.netcai.admin.result.JsonResult
     */
    @ResponseBody
    @RequestMapping(value = "delete", method = { RequestMethod.GET, RequestMethod.POST })
    public JsonResult delete(ProportionsDetailetail entity) {
        logger.info("[ProportionsDetailetailController][delete] 删除ProportionsDetailetail对象:");
        try {
            if (null == entity) {
                return new JsonResult(JsonResultCode.FAILURE, "请输入数据", "");
            }
            int result = service.delete(entity);
            if (result > 0) {
                return new JsonResult(JsonResultCode.SUCCESS, "操作成功", "");
            } else {
                return new JsonResult(JsonResultCode.FAILURE, "操作失败", "");
            }
        } catch (Exception e) {
            logger.error("[ProportionsDetailetailController][delete] exception", e);
            return new JsonResult(JsonResultCode.FAILURE, "系统异常，请稍后再试", "");
        }
    }

    /**
     * 分页查询ProportionsDetailetail对象
     * @param    entity  对象
     * @author   ysh
     * @date   2018-11-14 23:45:42 
     * @updater  or other
     * @return   com.netcai.admin.result.JsonResult
     */
    @ResponseBody
    @RequestMapping(value = "pageQuery", method = { RequestMethod.GET, RequestMethod.POST })
    public JsonResult pageQuery(HttpServletRequest request,ProportionsDetailetail entity) {
        logger.info("[ProportionsDetailetailController][pageQuery] 查询ProportionsDetailetail对象:");
        try {
            // 获取分页当前的页码
            int pageNum = this.getPageNum(request);
            // 获取分页的大小
            int pageSize = this.getPageSize(request);

            PageUtil paginator = service.pageQuery(entity , pageNum, pageSize);
            return new JsonResult(JsonResultCode.SUCCESS, "操作成功", paginator);
        } catch (Exception e) {
            logger.error("[ProportionsDetailetailController][pageQuery] exception", e);
            return new JsonResult(JsonResultCode.FAILURE, "系统异常，请稍后再试", "");
        }
    }

    /**
     * 新增或者修改ProportionsDetailetail对象
     * @param    request  请求
     * @param    entity  对象
     * @author   ysh
     * @date   2018-11-14 23:45:42
     * @updater  or other
     * @return   com.netcai.admin.result.JsonResult
     */
    @ResponseBody
    @RequestMapping(value = "updateProportionsMaterial", method = { RequestMethod.GET, RequestMethod.POST })
    public JsonResult updateProportionsMaterial(HttpServletRequest request,ProportionsMaterial entity) {
        logger.info("[ProportionsDetailetailController][updateProportionsMaterial] 新增或者修改ProportionsDetailetail对象:");
        try {
            int result;
            if (null == entity) {
                return new JsonResult(JsonResultCode.FAILURE, "请输入数据", "");
            }

            // 通过id来判断是新增还是修改
            if (null != entity.getProportionsMaterialId() && StringUtils.isNotBlank(entity.getProportionsMaterialId())) {
                result = service.updateProportionsMaterial(entity);
            }else {
                return new JsonResult(JsonResultCode.FAILURE, "操作失败", "");
                    }
            if (result > 0) {
                return new JsonResult(JsonResultCode.SUCCESS, "操作成功", "");
            } else {
                return new JsonResult(JsonResultCode.FAILURE, "操作失败", "");
            }
        } catch (Exception e) {
            logger.error("[updateProportionsMaterial][insertAndUpdate] exception", e);
            return new JsonResult(JsonResultCode.FAILURE, "系统异常，请稍后再试", "");
        }
    }
}	
