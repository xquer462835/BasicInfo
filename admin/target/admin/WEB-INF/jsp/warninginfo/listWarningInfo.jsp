<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt"  uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="pv" uri="/pageTaglib"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<title></title>
		<meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
		<!-- 引入公共部分css jsp文件 -->
		<%@include file="/WEB-INF/jsp/decorators/meta.jsp" %>
		<!-- 引入公共部分js jsp文件 -->
		<%@include file="/WEB-INF/jsp/decorators/listHeader.jsp" %>
		<style type="text/css">
			.layui-form-label{
				width:100px;
			}

			.layui-input-block{
				width:auto;
				height:auto;
				position:relative;
				left:800px;
			}
			table th{
				background:#ffffff;
			}
			table tr:nth-child(odd){
				background:#F0F0F0;
			}
			.col-sm-2 {
				width: 10%;
			}
		</style>
	</head>
	<body class="hold-transition skin-blue sidebar-mini">
	  <!-- 预警设置列表start -->
	  <div class="content-wrapper">
	    <!-- Content Header (Page header) --> 
	    <section class="content-header">
	      <h1>预警设置管理</h1>
	    </section>
	    <!-- Main content -->
	    <shiro:hasPermission name="warningInfo:query">
		    <section class="content">
		      <div class="row">
		        <div class="col-xs-12">
		          <div class="box">
		            <div class="box-header">
		              <h3 class="box-title">预警设置列表 :${sessionScope.login_session_admin.userName}</h3>
		            </div>
			        <div class="box box-info">
			           <!-- form start -->
			           <form  id="form_submit" class="form-horizontal" action="/admin/warningInfo/list" method="post">
			           	  <input type="hidden" name="pageNum" id="pageNum" value="${paginator.currentPage}">
	                      <input type="hidden" name="pageSize" id="pageSize" value="${paginator.pageRecord}">		           	 
			              <div class="box-body">
			                 <div class="form-group">
								 <label for="title" class="col-sm-2 control-label">标题：</label>
								 <div class="col-xs-2">
									 <input type="text" class="form-control" id="title" name="title" value="${warningInfo.title}" placeholder="请输入标题">
								 </div>
								 <label for="content" class="col-sm-2 control-label">内容：</label>
								 <div class="col-xs-2">
									 <input type="text" class="form-control" id="content" name="content" value="${warningInfo.content}" placeholder="请输入内容"/>
								 </div>
			                 </div>
			                 <div class="box-footer">
			                 	<button onclick='refreshTheCurrentPage()' class="btn btn-info pull-left">查询</button>
			                 	<button type="reset" onclick='resetRefreshTheCurrentPage()' id="reset" class="btn btn-info ">重置</button>
			               	 </div>
			             </div>
			           </form>
			           <!-- form end -->
			        </div>
					<!-- 表格列表start -->
		            <div class="box">
			           <div class="box-body">
			             <div class="site-demo-button" >
						   <button data-method="setAddOrEdit" id="addUser" class="layui-btn layui-btn-small"><i class="layui-icon"></i><span>&nbsp;&nbsp;新增</span></button>
						 </div>
			             <table id="example1" class="table table-bordered table-striped">
			               <thead>
				              <tr>
								  <th field="sys_xh">序号</th>

								  <th field="title"  >标题</th>
								  <th field="content"  >内容</th>
								  <th field="releaseUserName"  >发布人</th>
								  <th field="receiveUserCn"  >接收人</th>
								  <th field="options"  method="methodOptions">对象属性</th>
								  <th field="true_val" isShow="false" style="display: none" >值</th>
								  <th field="checkCondition" method="checkConditionStatus" >条件</th>
								  <th field="warn_val"  >预警值</th>
								  <th field="seq"  >排序号</th>
				                <th field="sys_opt">操作</th>
				              </tr>
			               </thead>
			               <tbody id="show-data">
			               <c:forEach items="${paginator.object}" var="r" varStatus="st"> 
				   			 <tr>
								 <td>${(st.index + 1)  + ((paginator.currentPage - 1) * paginator.pageRecord )} </td>
								 <td>${r.title}</td>
								 <td>${r.content}</td>
								 <td>${r.releaseUserName}</td>
								 <td>${r.receiveUserCn}</td>
								 <td>
									 <c:if test="${r.options == 1}">流程</c:if>
									 <c:if test="${r.options == 2}">材料</c:if>
								 </td>
								 <td style="display: none">${r.true_val}</td>
								 <td>
									 <c:if test="${r.checkCondition == 1}">大</c:if>
									 <c:if test="${r.checkCondition == 2}">小</c:if>
									 <c:if test="${r.checkCondition == 3}">等</c:if>
									 <c:if test="${r.checkCondition == 4}">不大</c:if>
									 <c:if test="${r.checkCondition == 5}">不小</c:if>
									 <c:if test="${r.checkCondition == 6}">不等于</c:if>
										 </td>
								 <td>${r.warn_val}</td>
								 <td>${r.seq}</td>
								 <td>
									 <div class="site-demo-button" >
										 <button id="updateWarningInfo" data-method="setAddOrEdit" value="${r.warningId}" class="layui-btn layui-btn-normal layui-btn-small"><i class="layui-icon"></i><span>&nbsp;&nbsp;修改</span></button>
										 <button id="delReleaseInfo" data-method="delIfon" value="${r.warningId}" class="layui-btn layui-btn-warm layui-btn-small"><i class="layui-icon"></i><span>&nbsp;&nbsp;删除</span></button>
									 </div>
								 </td>
				             </tr>
						   </c:forEach>
		                  </tbody>
			             </table>
			           </div>
			        </div>
		            <!-- 表格列表end -->
		            <div class="box-footer clearfix">
		              <ul id="show-page" class="pagination pagination-sm no-margin pull-left">
		              	 <pv:showPaging pageVo="${paginator}" />
		              </ul>
		            </div>
		          </div>
		        </div>
		      </div>
		    </section>
	    </shiro:hasPermission>
	  </div>
	
	<script type="text/javascript">

		//查询数据Url
		var pageQueryUrl = "<%=request.getContextPath()%>/admin/warningInfo/pageQuery";
		//查询条件表单Id
	    var _queryConditionForrId = "form_submit";
		//显示数据表格id
	    var showFieldId = "example1";
	    //数据展示id
	    var showFieldData = "show-data";
	    //主键
	    var primarykey = "warningId";
	    //分页显示标签id
	    var showPageNumber = "show-page";
	    //列表操作按钮
	    var tableBtn = new Array();
	    tableBtn = addBtn(tableBtn,"setAddOrEdit","修改","","","","","","layui-btn-normal");
        tableBtn = addBtn(tableBtn,"delData","删除","","","","","","layui-btn-warm");
		//tableBtn = addBtn(tableBtn,"enabled","禁用","","","status","true","1","layui-btn-danger");
		//tableBtn = addBtn(tableBtn,"openset","启用","","","status","true","-1","layui-btn-danger");
	</script>


	<script type="text/javascript">

		var methodStatus = function (val , obj) {
			var retVal = "";
			if(val == 1){
				retVal = "启用";
			}else if(val == -1){
				retVal = "禁用";
			}
			return retVal;
		};
		var checkConditionStatus = function (checkCondition) {
            if(checkCondition=='1'){
                return"大";
            }else if(checkCondition=='2'){
				return"小";
            }else if(checkCondition=='3'){
				return"等";
            }else  if(checkCondition=='4'){
				return"不大";
            }else if(checkCondition=='5'){
				return"不小";
            }else if(checkCondition=='6') {
                return "不等于";
            }
		};

        var methodOptions = function (val) {
            var retVal = "";
            if(val == 1){
                retVal = "流程";
            }else if(val == 2){
                retVal = "材料";
            }
            return retVal;
        };

	</script>
	<script>
		//新增数据弹窗
		layui.use('layer', function(){ //独立版的layer无需执行这一句
			var $ = layui.jquery, layer = layui.layer; //独立版的layer无需执行这一句
			//触发事件
			var active = {
				setAddOrEdit: function(data){
					//获取userId
					var id = data.val();
					setAddOrEdit(id);
				},
                delIfon: function(data){
                    //获取@primarykey
                    var id = data.val();
                    delData(id);
                },
				//启用和禁用数据弹窗
				offset: function(othis){
					var type = othis.data('type');
					var status=othis.text();
					if(status.indexOf("禁用")!=-1){
						//禁用的url
						requestUrl="<%=request.getContextPath()%>/admin/warningInfo/disabled";
						text = "确定要禁用此条数据吗？";
					}else{
						//启用的url
						requestUrl="<%=request.getContextPath()%>/admin/warningInfo/enabled";
						text = "确定要启用此条数据吗？";
					}
					var id = othis.val();
					userOffSet(type,requestUrl, id,text);
				}
			};
			$('.site-demo-button .layui-btn').on('click', function(){
				var othis = $(this), method = othis.data('method');
				active[method] ? active[method].call(this, othis) : '';
			});
		});

		
		//新增、编辑打开
		var setAddOrEdit = function(warningId){
		     //多窗口模式，层叠置顶
		     layer.open({
		         type: 2, 
		         title: '新增/修改 预警设置',
		         area: ['70%', '86%'],
		         shade: 0.5,
		         anim: 3,//0-6的动画形式，-1不开启
		         content: '<%=request.getContextPath()%>/admin/warningInfo/addOrEdit?warningId='+warningId,
		         zIndex: layer.zIndex, //重点1
		         success: function(layero, index){
		        	 //layer.setAddOrEdit(layero);
		        	 var body = layer.getChildFrame('body', index);
		             var iframeWin = window[layero.find('iframe')[0]['name']]; 
		             body.find('input[name="warningId"]').val(warningId);
		             //弹窗表单的取消操作时关闭弹窗
		             var canclebtn=body.find('button[name="cancleSubmit"]').click(function cancleSubmit(){
		            	 layer.closeAll();
		             });
		         }
		     });
		};
		
		//禁用
		var enabled = function (id) {
			//禁用的url
			requestUrl="<%=request.getContextPath()%>/admin/warningInfo/disabled";
			text = "确定要禁用此条数据吗？";
			userOffSet(1,requestUrl, id,text);
		};
		//启用
		var openset = function (id) {
			//启用的url
			requestUrl="<%=request.getContextPath()%>/admin/warningInfo/enabled";
			text = "确定要启用此条数据吗？";
			userOffSet(0,requestUrl, id,text);
		};
        //删除
        var delData = function(id){
            //删除的url
            requestUrl= "<%=request.getContextPath()%>/admin/warningInfo/delete";
            text = "确定要删除此条数据吗？";
            userOffSet(2,requestUrl, id,text);
        };

		var userOffSet = function (type ,requestUrl,id,text) {
			layer.open({
				type: 1,
				offset: type,
				id: 'LAY_demo'+type, //防止重复弹出
				content: '<div style="padding: 20px 100px;">'+ text +'</div>',
				btn: ['确定', '取消'],
				btnAlign: 'c', //按钮居中
				shade: 0.5 ,//不显示遮罩
				yes: function(){
					layer.closeAll();
					$.ajax({
						type: "POST",
						url: requestUrl,
						data: {"warningId":id},
						dataType: "json",
						cache:false,
						success: function(data){
							var code = data.code;
							var msg = data.message;
							if(code == "200"){
								layer.msg(msg, {icon: 1,time: 2000});//2秒关闭
								//刷新页面
								refreshTheCurrentPage();
							}
						},
						error:function(){
							layer.msg("操作失败", {icon: 1,time: 2000});//1.5秒关闭
						}
					});
				},
				btn2: function(){
					layer.closeAll();
				}
			});
		}
	</script>
</body>
</html>
					
