<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>List</title>
    <link href="https://cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div id="wrapper" class="toggled">


    <#--主要内容content-->
    <div id="page-content-wrapper">
        <div class="container-fluid">
            <div class="row clearfix">
                <div class="col-md-12 column">
                    <br>
                    <nav class="navbar navbar-default" role="navigation">

                        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                            <form class="navbar-form navbar-left" method="post" action="/message/list" >
                                <div class="form-group">
                                    <input name="command" type="text" class="form-control" />
                                    <input name="description" type="text" class="form-control" />
                                </div>
                                <button type="submit" class="btn btn-default">Submit</button>

                            </form>
                            <ul class="nav navbar-nav navbar-right">
                                <li>
                                    <a href="javascript:deleteBatch()">删除选中项</a>
                                </li>
                                <li>
                                    <a href="./index">新增</a>
                                </li>
                            </ul>
                        </div>
                    </nav>
                </div>

                <form method="post" id="mainForm" >
                    <div class="col-md-12 column">
                        <table class="table table-bordered table-condensed">
                            <thead>
                            <tr>
                                <th><input type="checkbox" id="all"/></th>
                                <th>序号</th>
                                <th>指令名称</th>
                                <th>描述</th>
                                <th>内容</th>
                                <th>操作</th>
                            </tr>
                            </thead>
                            <tbody>
                            <#list pageInfo.list as message>
                                <tr>
                                    <td><input type="checkbox"  name="id" value="${message.id}"/></td>
                                    <td>${(message.id)!''}</td>
                                    <td>${(message.command)!''}</td>
                                    <td>${(message.description)!''}</td>
                                    <td>${(message.content)!''}</td>
                                    <td>
                                        <a href="/message/index?id=#{message.id}">修改</a>
                                        <a href="/message/delete?id=#{message.id}">删除</a>
                                    </td>
                                </tr>
                            </#list>
                            </tbody>
                        </table>
                    </div>
                </form>

                <#--页数显示-->
                <div class="message">
                    &nbsp;&nbsp;&nbsp;&nbsp;共<i class="blue">${pageInfo.total}</i>条记录，当前显示第&nbsp;<i
                            class="blue">${pageInfo.pageNum}/${pageInfo.pages}</i>&nbsp;页
                </div>

                <#--分页-->
                <div class="col-md-12 column">
                    <ul class="pagination pull-right">

                        <#if pageInfo.isFirstPage==false>
                            <li><a href="./list">首页</a></li>
                            <li><a href="./list?pageNum=${pageInfo.prePage}">上一页</a></li>
                        </#if>
                        <#list pageInfo.navigatepageNums as element>
                            <#if element==pageInfo.pageNum>
                                <li class="disabled"><a href="./list?pageNum=${element}">${element}</a></li>
                            </#if>
                            <#if element!=pageInfo.pageNum>
                                <li><a href="./list?pageNum=${element}">${element}</a></li>
                            </#if>
                        </#list>

                        <#if pageInfo.isLastPage==false>
                            <li><a href="./list?pageNum=${pageInfo.nextPage}">下一页</a></li>
                            <li><a href="./list?pageNum=${pageInfo.pages}">最后一页</a></li>
                        </#if>

                    </ul>
                </div>
            </div>
        </div>
    </div>

</div>
<script src="https://cdn.bootcss.com/jquery/1.8.0/jquery.min.js"></script>
<script>
    function deleteBatch() {

        var url = window.location.href;
        checked_ids = document.getElementsByName("id");
        ids = [];
        for (k in checked_ids) {
            if (checked_ids[k].checked) {
                ids.push(checked_ids[k].value)
            }
        }

        $.ajax({
            url: "/message/deleteBatch",
            type: "post",
            data: JSON.stringify(ids),
            contentType:'application/json;charset=utf-8',
            success: function(){
                window.location.href = url;
            }
        })
    }
</script>
</body>
</html>