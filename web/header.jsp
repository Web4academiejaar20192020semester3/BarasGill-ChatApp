<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<header role="banner">
<img alt="Books" src="images/books.jpg">
<h1><span>Chat App</span></h1>
<%--<nav>
<ul>
<c:choose>
<c:when test="${param.title=='Home'}">
<li  id="actual"><a href="Controller">Home</a></li>
</c:when>
<c:otherwise>
<li><a href="Controller">Home</a></li>
</c:otherwise>
</c:choose>


</ul>
</nav>--%>
<h2>
    ${param.title}
    <c:if test="${param.title=='Friends List'}">
        <form method="post" action="Controller?action=LogOut" style="float: right; margin-top: -3em">
            <p>
                <input type="submit" id="logoutbutton" value="Log Out">
            </p>
        </form>
    </c:if>
</h2>

</header>