<%@ page contentType="text/html;charset=UTF-8" language="java" %><html><head>    <%@ include file="../common/common.jsp"%></head><body><p style="font-size-adjust: inherit">用户管理</p><form class="form-horizontal" role="form">    <div class="container-fluid">        <div class="row">            <div class="col-md-1">                <label class="control-label" style="font-size: larger">编码:</label>            </div>            <div class="col-md-3" style="text-align:left">                <input style="width:70%" type="text" class="form-control" placeholder="请输入编码"/>            </div>            <div class="col-md-1">                <label class="control-label" style="font-size: larger">姓名:</label>            </div>            <div class="col-md-3" style="text-align:left">                <input style="width:80%" type="text" class="form-control" placeholder="请输入姓名"/>            </div>        </div>        <br/>        <div class="row">            <div class="col-md-2">                <button type="button" class="btn btn-primary btn-sm">查询</button>                &nbsp                <button type="button" class="btn btn-success btn-sm">重置</button>                &nbsp                <button type="button" class="btn btn-info btn-sm" onclick="add()">新增</button>            </div>        </div>    </div>    </div></form><table class="table table-hover">    <tr>        <td>序号</td>        <td>姓名</td>        <td>编码</td>        <td>电话</td>        <td>创建时间</td>        <td>创建人</td>    </tr>    <c:forEach items="${userList}" var="user" varStatus="status">        <tr>            <td>                ${status.count}            </td>            <td>                ${user.name}            </td>            <td>                ${user.code}            </td>            <td>                ${user.phone}            </td>            <td>                <fmt:formatDate value="${user.createTime}" pattern="yyyy-MM-dd HH:mm:ss"></fmt:formatDate>            </td>            <td>                ${user.createName}            </td>        </tr>    </c:forEach></table></body><script>    function add() {        window.location.href = "/sys/user/add.do";    }</script></html>