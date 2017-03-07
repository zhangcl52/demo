<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>hunter管理平台</title>
    <link rel="stylesheet" href="/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="/css/css.css"/>
    <script type="text/javascript" src="/js/jquery1.9.0.min.js"></script>
    <script type="text/javascript" src="/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="/js/sdmenu.js"></script>
    <script type="text/javascript" src="/js/laydate/laydate.js"></script>

</head>

<body>
<!--顶部开始-->
<div class="header">
    <%--<div class="logo"><img src="/img/logo.png"/></div>--%>
        <div class="logo"><img src=""/></div>
    <div class="header-right">
        <i class="icon-question-sign icon-white"></i> <a href="#">帮助</a> <i class="icon-off icon-white"></i> <a
            id="modal-973558" href="#modal-container-973558" role="button" data-toggle="modal">注销</a> <i
            class="icon-user icon-white"></i> <a href="#">开票员的工作平台</a> <i class="icon-envelope icon-white"></i> <a
            href="#">发送短信</a>
        <div id="modal-container-973558" class="modal hide fade" role="dialog" aria-labelledby="myModalLabel"
             aria-hidden="true" style="width:300px; margin-left:-150px; top:30%">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                <h3 id="myModalLabel">
                    注销系统
                </h3>
            </div>
            <div class="modal-body">
                <p>
                    您确定要注销退出系统吗？
                </p>
            </div>
            <div class="modal-footer">
                <button class="btn" data-dismiss="modal" aria-hidden="true">关闭</button>
                <a class="btn btn-primary" style="line-height:20px;" href="登录.html">确定退出</a>
            </div>
        </div>
    </div>
</div>
<!-- 顶部结束 -->
<!--中部开始(包括左侧导航和右侧内容)-->
<div id="middle">
    <%--左侧导航--%>
    <div class="left">
        <script type="text/javascript">
            var myMenu;
            window.onload = function () {
                myMenu = new SDMenu("my_menu");
                myMenu.init();
            };
        </script>

        <div id="my_menu" class="sdmenu">
            <div>
                <span>业务处理</span>
                <a href="查询页面.html">电脑开票</a>
                <a href="#" dateUrl="/sys/user/list.do" id="menu_1_1" onclick="getPage('menu_1_1')">用户管理</a>
                <a href="开票界面.html">票单复核</a>
                <a href="客户投诉.html">货物配载</a>
                <a href="线路管理.html">发车清单</a>
                <a href="#">到货确认</a>
            </div>
            <div class="collapsed">
                <span>资金结算</span>
                <a href="/demoTest/test.do">提货登记</a>
                <a href="#">收款核销</a>
            </div>

        </div>
    </div>
    <div class="Switch"></div>
    <script type="text/javascript">
        $(document).ready(function (e) {
            $(".Switch").click(function () {
                $(".left").toggle();

            });
        });
    </script>
    <%--右侧内容--%>
    <div class="right" id="mainFrame">
        <div class="right_cont">
            <iframe src="/sys/loginController/getHomePage.do" marginheight="0" marginwidth="0" frameborder="0"
                    scrolling="no" width="100%" height="100%"
                    id="iframepage" name="iframepage" onLoad="iFrameHeight()">

            </iframe>


        </div>
    </div>
</div>
<!--中部结束(包括左侧导航和右侧内容)-->

<!-- 底部 -->
<div id="footer">版权所有：晶科客流 &copy; 2015&nbsp;&nbsp;&nbsp;&nbsp;<a href="http://www.mycodes.net/" target="_blank">源码之家</a>
</div>


<script>
    !function () {
        laydate.skin('molv');
        laydate({elem: '#Calendar'});
    }();
    function iFrameHeight() {
        var ifm = document.getElementById("iframepage");
        var subWeb = document.frames ? document.frames["iframepage"].document :
                ifm.contentDocument;
        if (ifm != null && subWeb != null) {
            ifm.height = subWeb.body.scrollHeight;
        }
    }
    function getPage(menuId){
        var _menu = $("#"+menuId);
        var pageUrl=_menu.attr("dateUrl");
        var ifm=$("#iframepage");
        ifm.attr("src",pageUrl);
//        alert(ifm.attr("attr"));
    }
</script>
</body>
</html>
