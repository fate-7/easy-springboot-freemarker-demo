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
                    <form role="form" method="post" action="/message/save">
                        <div class="form-group">
                            <label>command</label>
                            <input name="command" type="text" class="form-control" value="${(message.command)!''}"/>
                        </div>
                        <div class="form-group">
                            <label>description</label>
                            <input name="description" type="text" class="form-control" value="${(message.description)!''}"/>
                        </div>
                        <div class="form-group">
                            <label>content</label>
                            <input name="content" type="text" class="form-control" value="${(message.content)!''}"/>
                        </div>


                        <input hidden type="text" name="id" value="${(message.id)!''}">
                        <button type="submit" class="btn btn-default">提交</button>
                    </form>
                </div>
            </div>
        </div>
    </div>

</div>
</body>
</html>