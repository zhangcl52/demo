<%--  Created by IntelliJ IDEA.  User: zhangchaolong  Date: 17/4/15  Time: 上午11:13  To change this template use File | Settings | File Templates.--%><%@ page contentType="text/html;charset=UTF-8" language="java" %><%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %><%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %><%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %><%    String path = request.getContextPath();    request.setAttribute("path", path);%><script language="javascript">    var path = '<%=request.getContextPath()%>';</script><link rel="stylesheet" href="${path}/css/bootstrap.min.css"/><link rel="stylesheet" href="${path}/css/bootstrapValidator.min.css"/><script type="text/javascript" src="${path}/js/jquery-3.2.1.min.js"></script><script type="text/javascript" src="${path}/js/bootstrap.min.js"></script><script type="text/javascript" src="${path}/js/bootstrapValidator.min.js"></script><script type="text/javascript" src="${path}/js/laydate/laydate.js"></script><%--<link type="text/css" href="${path}/css/bootstrap-pagination.min.css" rel="stylesheet" />--%><%--<script type="text/javascript" charset="utf-8" src="${path}/js/bootstrap-pagination.min.js"></script>--%><!--support pagination--><script type="text/javascript" charset="utf8" src="${path}/datatables1.10.15/js/dataTables.bootstrap.js"></script><script type="text/javascript" charset="utf8" src="${path}/datatables1.10.15/css/dataTables.bootstrap.min.css"></script><script type="text/javascript" charset="utf8" src="${path}/datatables1.10.15/css/jquery.dataTables.min.css"></script><link rel="stylesheet" type="text/css" href="${path}/datatables1.10.15/css/jquery.dataTables.min.css"/><script type="text/javascript" charset="utf8" src="${path}/datatables1.10.15/js/jquery.dataTables.min.js"></script>