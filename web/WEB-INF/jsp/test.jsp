<%--
  Created by IntelliJ IDEA.
  User: daidai
  Date: 2018/10/29
  Time: 20:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix ="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">

<head>

    <title>Title</title>

    <meta charset="UTF-8" />
    <title>Document</title>
    <style>
        .pagination {
            overflow: hidden;
            display: table;
            margin: 0 auto;
        }
        .pagination li {
            float: left;
            height: 30px;
            border-radius: 5px;
            margin: 3px;
            color: #666;
            list-style: none;
        }
        .pagination li:hover{
            background: #135677;
        }
        .pagination li:hover a{
            color: #fff;
        }
        .pagination li a {
            display: block;
            width: 50px;
            height: 30px;
            text-align: center;
            line-height: 30px;
            font-size: 12px;
            border-radius: 5px;
            text-decoration: none;
            font-size: 15px;
            color: #000;
        }
        .active{
            background: #ccc;
        }
        .active li a{
            color: #fff;
        }
        .search-card{
            color: #858585;
            margin: 20px 0 40px 25px;
            padding-left: 11px;
            font-weight: 700;
        }
        .search{
            font-size: 18px;
        }
        .search-input{
            outline: none;
            height: 20px;
        }
        .btn-card{
            height: 25px;
        }
        .consume{
            border: 1px solid #ccc;
            width: 100%;
        }
        .consume tr{
            height: 30px;
            width: 100%;
        }
        .consume-th th{
            border: 1px solid #ccc;
            color: #000;
        }
        .consume-td td{
            border: 1px solid #ccc;
            color: #ooo;
            text-align: center;
        }
        .page{
            margin-top: 5px;
        }
        .more{
            text-decoration: none;
            font-size: 20px;
            color: #444;
            margin: 0 25px;
        }
        .now{
            font-size: 20px;
        }
    </style>


    <title>Title</title>
    <!-- 新 Bootstrap 核心 CSS 文件 -->
    <link rel="stylesheet" href=/css/bootstrap.css>

    <!-- 可选的Bootstrap主题文件（一般不用引入） -->
    <link rel="stylesheet" href=/css/bootstrap-theme.css>

    <!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
    <script src=/js/jquery-1.11.3.min.js></script>

    <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
    <script src=/js/bootstrap.js></script>
</head>
<body>
<from class="search-card">
    <span class="search">查询月份:</span>
    <input type="date" class="search-input" id="mintime"><span class="search">至</span>
    <input type="date" class="search-input" id="maxtime">
    <button class="btn-card" onclick="btnCard()">查询</button>
</from>
<table border="0" cellpadding="0" cellspacing="0" class="consume">
    <thead class="consume-th">
    <tr>
        <th>序号</th>
        <th>消费类型</th>
        <th>时间</th>
        <th>地点</th>
        <th>金额</th>
    </tr>
    </thead>
    <tbody class="consume-td">
    <c:forEach items="${list}" var="item" varStatus="status">
        <tr>
            <td>${status.count}</td>
            <td>${item.JYLX}</td>
            <td>${item.JYSJ}</td>
            <td>${item.SHMC}</td>
            <td>${item.JYE}</td>
        </tr>
    </c:forEach>
  ！


    <tr>
        <td colspan="5">
            <nav>
                <ul class="pagination">
                    <li :class="{'disabled': current == 1}"><a href="javascript:;" @click="setCurrent(current - 1)">上一页</a></li>
                    <li :class="{'disabled': current == 1}"><a href="javascript:;" @click="setCurrent(1)">首页</a></li>
                    <li v-for="p in grouplist" :class="{'active': current == p.val}">
                        <a href="javascript:;" @click="setCurrent(p.val)"> {{ p.text }} </a>
                    </li>
                    <li :class="{'disabled': current == page}"><a href="javascript:;" @click="setCurrent(page)">尾页</a></li>
                    <li :class="{'disabled': current == page}"><a href="javascript:;" @click="setCurrent(current + 1)">下一页</a></li>
                </ul>
            </nav>
        </td>
    </tr>
    </tbody>
</table>

<div style="width: 380px; margin: 0 auto; margin-top: 50px;">
    <ul class="pagination" style="text-align: center; margin-top: 10px;">
        <!-- 上一页 -->
        <!-- 判断当前页是否是第一页 -->
        <c:if test="${pageBean.currentPage==1 }">
            <li class="disabled">
                <a href="javascript:void(0);" aria-label="Previous">
                    <span aria-hidden="true">&laquo;</span>
                </a>
            </li>
        </c:if>
        <c:if test="${pageBean.currentPage!=1 }">
            <li>
                <a href="${pageContext.request.contextPath }/select/selectRecord.action?currentPage=${pageBean.currentPage-1}" aria-label="Previous">
                    <span aria-hidden="true">&laquo;</span>
                </a>
            </li>
        </c:if>




        <c:forEach begin="1" end="${pageBean.totalPage }" var="page">
            <!-- 判断当前页 -->
            <c:if test="${pageBean.currentPage==page }">
                <li class="active"><a href="javascript:void(0);">${page}</a></li>
            </c:if>
            <c:if test="${pageBean.currentPage!=page }">
                <li><a href="${pageContext.request.contextPath }/select/selectRecord.action?currentPage=${page}">${page}</a></li>
            </c:if>

        </c:forEach>
v刹薄荷脑臭逼女魃墓
        <!-- 判断当前页是否是最后一页 -->
        <c:if test="${pageBean.currentPage==pageBean.totalPage }">
            <li class="disabled">
                <a href="javascript:void(0);" aria-label="Next">
                    <span aria-hidden="true">&raquo;</span>
                </a>
            </li>
        </c:if>
        <c:if test="${pageBean.currentPage!=pageBean.totalPage }">
            <li>
                <a href="${pageContext.request.contextPath }/select/selectRecord.action?currentPage=${pageBean.currentPage+1}" aria-label="Next">
                    <span aria-hidden="true">&raquo;</span>
                </a>
            </li>
        </c:if>

    </ul>
</div>
</body>
<script>
   function btnCard() {
       var mintime = document.getElementById('mintime').value;
       var maxtime = document.getElementById('maxtime').value;
       location.href="${pageContext.request.contextPath }/select/selectRecoredBytime.action?mintime="+mintime+"&maxtime="+maxtime;

   }
</script>
</html>

