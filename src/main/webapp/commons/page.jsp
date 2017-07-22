<%--
  Created by IntelliJ IDEA.
  User: anlu
  Date: 2017/7/21
  Time: 16:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page pageEncoding="UTF-8" %>
<%@ include file="inc.jsp" %>
<style>
    .active {
        color: #00f;
    }
</style>
<script src="${ctx}/assets/js/jquery.min.js"></script>
<script>
    $(function () {
        var form = $('#form');
        $('#submit').click(function () {
            form.attr('action', form.attr('action') + $('#page').val());
            form.submit();
        });
        $('a.p').each(function () {
            if ($(this).text() == ${sessionScope.pagination.currentPage}) {
                $(this).addClass('active');
            } else {
                $(this).removeClass('active');
            }
        });
    });
</script>
<c:set var="p" value="${sessionScope.pagination}"/>
<c:choose>
    <c:when test="${p.totalRows eq 0}">
        <em>没有记录</em>
    </c:when>
    <c:otherwise>
        <c:choose>
            <c:when test="${p.currentPage eq 1}">
                首页
                上一页
            </c:when>
            <c:otherwise>
                <a href="${ctx}/${param.path}/1">首页</a>
                <a href="${ctx}/${param.path}/${p.currentPage - 1}">上一页</a>
            </c:otherwise>
        </c:choose>

        <c:if test="${p.currentPage < 7}">
            <c:if test="${p.totalPages <= 7}">
                <c:forEach var="page" begin="1" end="${p.totalPages}">
                    <a class="p" href="${ctx}/${param.path}/${page}">${page}</a>
                </c:forEach>
            </c:if>
            <c:if test="${p.totalPages > 7}">
                <c:forEach var="page" begin="1" end="7">
                    <a class="p" href="${ctx}/${param.path}/${page}">${page}</a>
                </c:forEach>
                ...
            </c:if>
        </c:if>
        <c:if test="${p.currentPage >= 7}">
            <a class="p" href="${ctx}/${param.path}/1">1</a>
            <a class="p" href="${ctx}/${param.path}/2">2</a>
            ...
            <a class="p"
               href="${ctx}/${param.path}/${p.currentPage-2}">${p.currentPage-2}</a>
            <a class="p"
               href="${ctx}/${param.path}/${p.currentPage-1}">${p.currentPage-1}</a>
            <a class="p"
               href="${ctx}/${param.path}/${p.currentPage}">${p.currentPage}</a>
            <c:if test="${p.totalPages - p.currentPage > 2}">
                <a class="p"
                   href="${ctx}/${param.path}/${p.currentPage+1}">${p.currentPage+1}</a>
                <a class="p"
                   href="${ctx}/${param.path}/${p.currentPage+2}">${p.currentPage+2}</a>
                ...
            </c:if>
            <c:if test="${p.totalPages - p.currentPage <= 2}">
                <c:forEach var="page" begin="${p.currentPage+1}"
                           end="${p.totalPages}">
                    <a class="p" href="${ctx}/${param.path}/${page}">${page}</a>
                </c:forEach>
            </c:if>
        </c:if>
        <c:choose>
            <c:when test="${p.currentPage eq p.totalPages}">
                下一页
                尾页
            </c:when>
            <c:otherwise>
                <a href="${ctx}/${param.path}/${p.currentPage + 1}">下一页</a>
                <a href="${ctx}/${param.path}/${p.totalPages}">尾页</a>
            </c:otherwise>
        </c:choose>
        共 ${p.totalPages} 页
        <form id="form" action="${ctx}/${param.path}/" method="post" style="display: inline-block">
            到第
            <select id="page">
                <c:forEach var="i" begin="1" end="${p.totalPages}">
                <option value="${i}">${i}
                    </c:forEach>
            </select>
            页
            <a id="submit" href="#">确定</a>
        </form>
    </c:otherwise>
</c:choose>
