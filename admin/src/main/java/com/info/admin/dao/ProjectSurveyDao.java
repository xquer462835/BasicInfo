package com.info.admin.dao;

import com.info.admin.entity.ProjectSurvey;
import com.info.admin.entity.ProjectSurveyTree;
import org.apache.ibatis.annotations.Param;

import java.util.List;

 /**
 * @author ysh
 * @date 2018-11-14 23:45:41
 * @describe 工程概况 Dao
 */
public interface ProjectSurveyDao {
	/**
	 *添加ProjectSurvey对象
	 *@param  entity 对象
	 *@author  ysh
	 *@date  2018-11-14 23:45:41 
	 *@updater or other
	 *@return int
	 */
	int insert(ProjectSurvey entity);

	/**
	 *修改ProjectSurvey对象
	 *@param  entity 对象
	 *@author  ysh
	 *@date  2018-11-14 23:45:41 
	 *@updater or other
	 *@return int
	 */
	int update(ProjectSurvey entity);

	/**
	 *查询ProjectSurvey对象
	 *@param  entity 对象
	 *@author  ysh
	 *@date  2018-11-14 23:45:41 
	 *@updater or other
	 *@return List<ProjectSurvey>
	 */
	List<ProjectSurvey> query(@Param("entity") ProjectSurvey entity);

	/**
	 *删除ProjectSurvey对象
	 *@param  entity 对象
	 *@author  ysh
	 *@date  2018-11-14 23:45:41 
	 *@updater or other
	 *@return int
	 */
	int delete(@Param("entity") ProjectSurvey entity);

    /**
     * 分页查询ProjectSurvey对象
     * @param entity  对象
     * @param offset	页数
     * @param pageSize	大小
     * @author  ysh
     * @date  2018-11-14 23:45:41 
     * @updater or other
     * @return   List<ProjectSurvey> 
     */
    List<ProjectSurvey> pageQuery(@Param("entity") ProjectSurvey entity, @Param("offset") int offset, @Param("pageSize") int pageSize);

    /**
     * 查询ProjectSurvey总记录数
     * @param entity  对象
     * @author  ysh
     * @date  2018-11-14 23:45:41 
     * @updater or other
     * @return   int
     */
    int getPageCount(@Param("entity") ProjectSurvey entity);

	/**
	 * 根据 id获取 工程概况 
	 *@author   ysh
	 *@param projectId 主键id
	 *@date  2018-11-14 23:45:41
	 *@updater  or other
	 *@return   ProjectSurvey
	 */
	public ProjectSurvey getProjectSurveyById(String projectId);


	 /**
	  * 梁场信息List
	  * @author
	  * @param
	  * @date  2018-11-14 23:45:42
	  * @updater  or other
	  * @return   OrgInfo
	  */
	 public List<ProjectSurveyTree>  getProjectSurveyTree(@Param("entity")ProjectSurveyTree entity);

	 /**
	  * 所有梁场信息List
	  * @author
	  * @param
	  * @date  2018-11-14 23:45:42
	  * @updater  or other
	  * @return   OrgInfo
	  */
	 List<ProjectSurvey> getAll();
}
