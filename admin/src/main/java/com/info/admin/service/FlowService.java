package com.info.admin.service;

import com.info.admin.entity.Flow;
import com.info.admin.utils.PageUtil;

import java.util.List;

/**
 * @author ysh
 * @date 2018-11-13 16:23:57 
 * @describe 流程 Service
 */
public interface FlowService {
    /**
     *添加Flow对象
     *@param  entity 对象
     *@author  ysh
     *@date  2018-11-13 16:23:57 
     *@updater or other
     *@return int
     */
    int insert(Flow entity);

    /**
     *修改Flow对象
     *@param  entity 对象
     *@author  ysh
     *@date  2018-11-13 16:23:57 
     *@updater or other
     *@return int
     */
    int update(Flow entity);

    /**
     *查询Flow对象
     *@param  entity 对象
     *@author  ysh
     *@date  2018-11-13 16:23:57 
     *@updater or other
     *@return List<Flow>
     */
    List<Flow> query(Flow entity);

    /**
     *删除Flow对象
     *@param  entity 对象
     *@author  ysh
     *@date  2018-11-13 16:23:57 
     *@updater or other
     *@return int
     */
    int delete(Flow entity);

    /**
     * 分页查询Flow对象
     * @param entity 对象
     * @param pageNum	页数
     * @param pageSize	大小
     * @author  ysh
     * @date  2018-11-13 16:23:57 
     * @updater or other
     * @return   PageUtil
     */
    PageUtil pageQuery(Flow entity, int pageNum, int pageSize);
    
    /**
	 * 根据 id获取 流程
	 * @author   ysh
	 * @param flowId 主键id
	 * @date  2018-11-13 16:23:57
	 * @updater  or other
	 * @return   Flow
	 */ 
	public Flow getFlowById(String flowId);
	
}

	