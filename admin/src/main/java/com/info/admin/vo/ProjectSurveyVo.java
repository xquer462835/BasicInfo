package com.info.admin.vo;

import java.io.Serializable;
import java.util.Date;

/**
 * 工程概况实体类
 * @author administrator  2018-11-14 23:45:42
 */
public class ProjectSurveyVo implements Serializable {
	private static final long serialVersionUID = 1L;
	 /*****主键*****/ 
	 private String projectId;
	 /*****创建时间*****/ 
	 private Date createTime;
	 /*****创建人编号*****/ 
	 private Long createUser;
	 /*****删除标记*****/ 
	 private Long deleteFlag;
	 /*****修改时间*****/ 
	 private Date updateTime;
	 /*****排序号*****/ 
	 private Long seq;
	 /*****梁场名称*****/ 
	 private String lcName;
	 /*****梁场地址*****/ 
	 private String lcAddr;
	 /*****线路里程*****/ 
	 private String lineMileage;
	 /*****梁场规模*****/ 
	 private String lcScale;
	 /*****承担任务*****/ 
	 private String bearTask;
	 /*****供应里程*****/ 
	 private String supplyMileage;
	 /*****生产能力*****/ 
	 private String throughput;
	 /*****建设单位*****/ 
	 private String constructionUnit;
	 /*****承建单位*****/ 
	 private String bearUnit;
	 /*****监理单位*****/ 
	 private String controlUnit;
	 /*****设计单位*****/ 
	 private String designUnit;
	 /*****总体目标*****/ 
	 private String overallGoal;
	 /*****工期目标*****/ 
	 private String timeGoal;
	 /*****安全目标*****/ 
	 private String securityGoal;
	 /*****质量目标*****/ 
	 private String qualityGoal;
	 /*****环境保护目标*****/ 
	 private String epoGoal;
	 /*****职业健康目标*****/ 
	 private String ophGoal;


	 public String getProjectId() {
		 return projectId;
	 }

	 public void setProjectId(String projectId) {
		 this.projectId = projectId;
	 }

	 public Date getCreateTime() {
		 return createTime;
	 }

	 public void setCreateTime(Date createTime) {
		 this.createTime = createTime;
	 }

	 public Long getCreateUser() {
		 return createUser;
	 }

	 public void setCreateUser(Long createUser) {
		 this.createUser = createUser;
	 }

	 public Long getDeleteFlag() {
		 return deleteFlag;
	 }

	 public void setDeleteFlag(Long deleteFlag) {
		 this.deleteFlag = deleteFlag;
	 }

	 public Date getUpdateTime() {
		 return updateTime;
	 }

	 public void setUpdateTime(Date updateTime) {
		 this.updateTime = updateTime;
	 }

	 public Long getSeq() {
		 return seq;
	 }

	 public void setSeq(Long seq) {
		 this.seq = seq;
	 }

	 public String getLcName() {
		 return lcName;
	 }

	 public void setLcName(String lcName) {
		 this.lcName = lcName;
	 }

	 public String getLcAddr() {
		 return lcAddr;
	 }

	 public void setLcAddr(String lcAddr) {
		 this.lcAddr = lcAddr;
	 }

	 public String getLineMileage() {
		 return lineMileage;
	 }

	 public void setLineMileage(String lineMileage) {
		 this.lineMileage = lineMileage;
	 }

	 public String getLcScale() {
		 return lcScale;
	 }

	 public void setLcScale(String lcScale) {
		 this.lcScale = lcScale;
	 }

	 public String getBearTask() {
		 return bearTask;
	 }

	 public void setBearTask(String bearTask) {
		 this.bearTask = bearTask;
	 }

	 public String getSupplyMileage() {
		 return supplyMileage;
	 }

	 public void setSupplyMileage(String supplyMileage) {
		 this.supplyMileage = supplyMileage;
	 }

	 public String getThroughput() {
		 return throughput;
	 }

	 public void setThroughput(String throughput) {
		 this.throughput = throughput;
	 }

	 public String getConstructionUnit() {
		 return constructionUnit;
	 }

	 public void setConstructionUnit(String constructionUnit) {
		 this.constructionUnit = constructionUnit;
	 }

	 public String getBearUnit() {
		 return bearUnit;
	 }

	 public void setBearUnit(String bearUnit) {
		 this.bearUnit = bearUnit;
	 }

	 public String getControlUnit() {
		 return controlUnit;
	 }

	 public void setControlUnit(String controlUnit) {
		 this.controlUnit = controlUnit;
	 }

	 public String getDesignUnit() {
		 return designUnit;
	 }

	 public void setDesignUnit(String designUnit) {
		 this.designUnit = designUnit;
	 }

	 public String getOverallGoal() {
		 return overallGoal;
	 }

	 public void setOverallGoal(String overallGoal) {
		 this.overallGoal = overallGoal;
	 }

	 public String getTimeGoal() {
		 return timeGoal;
	 }

	 public void setTimeGoal(String timeGoal) {
		 this.timeGoal = timeGoal;
	 }

	 public String getSecurityGoal() {
		 return securityGoal;
	 }

	 public void setSecurityGoal(String securityGoal) {
		 this.securityGoal = securityGoal;
	 }

	 public String getQualityGoal() {
		 return qualityGoal;
	 }

	 public void setQualityGoal(String qualityGoal) {
		 this.qualityGoal = qualityGoal;
	 }

	 public String getEpoGoal() {
		 return epoGoal;
	 }

	 public void setEpoGoal(String epoGoal) {
		 this.epoGoal = epoGoal;
	 }

	 public String getOphGoal() {
		 return ophGoal;
	 }

	 public void setOphGoal(String ophGoal) {
		 this.ophGoal = ophGoal;
	 }

	public ProjectSurveyVo() {
		super();
	}
}
