package com.info.admin.dao;

import com.info.admin.entity.MaterialDetail;
import com.info.admin.entity.Repertory;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
import java.util.List;

 /**
 * @author ysh
 * @date 2018-11-14 23:45:41
 * @describe 仓库 Dao
 */
public interface RepertoryDao {
	/**
	 *添加Repertory对象
	 *@param  entity 对象
	 *@author  ysh
	 *@date  2018-11-14 23:45:41 
	 *@updater or other
	 *@return int
	 */
	int insert(Repertory entity);

	/**
	 *修改Repertory对象
	 *@param  entity 对象
	 *@author  ysh
	 *@date  2018-11-14 23:45:41 
	 *@updater or other
	 *@return int
	 */
	int update(Repertory entity);

	/**
	 *查询Repertory对象
	 *@param  entity 对象
	 *@author  ysh
	 *@date  2018-11-14 23:45:41 
	 *@updater or other
	 *@return List<Repertory>
	 */
	List<Repertory> query(@Param("entity") Repertory entity);

	/**
	 *删除Repertory对象
	 *@param  entity 对象
	 *@author  ysh
	 *@date  2018-11-14 23:45:41 
	 *@updater or other
	 *@return int
	 */
	int delete(@Param("entity") Repertory entity);

    /**
     * 分页查询Repertory对象
     * @param entity  对象
     * @param offset	页数
     * @param pageSize	大小
     * @author  ysh
     * @date  2018-11-14 23:45:41 
     * @updater or other
     * @return   List<Repertory> 
     */
    List<Repertory> pageQuery(@Param("entity") Repertory entity, @Param("offset") int offset, @Param("pageSize") int pageSize);

    /**
     * 查询Repertory总记录数
     * @param entity  对象
     * @author  ysh
     * @date  2018-11-14 23:45:41 
     * @updater or other
     * @return   int
     */
    int getPageCount(@Param("entity") Repertory entity);

	/**
	 * 根据 id获取 仓库 
	 *@author   ysh
	 *@param supplierId 主键id
	 *@date  2018-11-14 23:45:41
	 *@updater  or other
	 *@return   Repertory
	 */
	public Repertory getRepertoryById(String supplierId);
	 /**
	  *查询Repertory对象
	  *@param  entity 对象
	  *@author
	  *@date  2018-11-14 23:45:42
	  *@updater or other
	  *@return List<StaffInfo>
	  */
	 List<Repertory> queryRepertoryRepertoryTree(Repertory entity);

	 /**
	  * 查询Repertory记录数
	  * @author
	  * @date  2018-11-14 23:45:41
	  * @updater or other
	  * @return   int
	  */
	 Repertory getRepertoryPage(@Param("materialName") String materialName,@Param("projectId") String projectId);

	 /**
	  * 入库
	  * @author
	  * @date  2018-11-14 23:45:41
	  * @updater or other
	  * @return   int
	  */
	 int updateNum(@Param("num")BigDecimal num, @Param("repertoryId") String repertoryId);

	 /**
	  * 批量出库
	  * @author
	  * @date  2018-11-14 23:45:41
	  * @updater or other
	  * @return   int
	  */
	 public int outTestMaterial(@Param("materialDetailList")List<MaterialDetail> materialDetailList);
}
