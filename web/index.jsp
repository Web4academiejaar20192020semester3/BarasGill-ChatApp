<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<jsp:include page="head.jsp">
	<jsp:param name="title" value="Home" />
</jsp:include>
<body>
	<jsp:include page="header.jsp">
		<jsp:param name="title" value="Home" />
	</jsp:include>
	<main>
<c:if test="${errors.size()>0 }">
	<div class="danger">
		<ul>
			<c:forEach var="error" items="${errors }">
				<li>${error }</li>
			</c:forEach>
		</ul>
	</div>
</c:if>
	<div class="blockDiv">
		<div id="signIn">
			<jsp:include page="signIn.jsp">
				<jsp:param name="title" value="Home"/>
			</jsp:include>
		</div>
		<div id="signUp">
			<jsp:include page="signUp.jsp">
				<jsp:param name="title" value="Home"/>
			</jsp:include>
		</div>
	</div>
		<br>
		<br>
		<br>
		<h2>React to Blogs</h2>
		<div id="topics">
			<h3>Blog 1</h3>
			<p>Was it an interesting projectweek?</p>
			<input type="text" id="name1" name="name" placeholder="Name">
			<input type="text" id="commentText1" name="comment" placeholder="Comment">
			<input type="number" id="rating1" name="rating" placeholder="Rate this topic">
			<input type="submit" id="send1" value="Send" onclick="send(1)">
			<h4>Comment Section</h4>
			<div id="Comments1"></div>

			<h3>Blog 2</h3>
			<p>What are you planning to do today?</p>
			<input type="text" id="name2" name="name" placeholder="Name">
			<input type="text" id="commentText2" name="comment" placeholder="Comment">
			<input type="number" id="rating2" name="rating" placeholder="Rate this topic">
			<input type="submit" id="send2" value="Send" onclick="send(2)">
			<h4>Comment Section</h4>
			<div id="Comments2"></div>

			<h3>Blog 3</h3>
			<p>To which music are you listening currently?</p>
			<input type="text" id="name3" name="name" placeholder="Name">
			<input type="text" id="commentText3" name="comment" placeholder="Comment">
			<input type="number" id="rating3" name="rating" placeholder="Rate this topic">
			<input type="submit" id="send3" value="Send" onclick="send(3)">
			<h4>Comment Section</h4>
			<div id="Comments3"></div>

			<h3>Blog 4</h3>
			<p>Which questions about web 4 could be asked on the examination?</p>
			<input type="text" id="name4" name="name" placeholder="Name">
			<input type="text" id="commentText4" name="comment" placeholder="Comment">
			<input type="number" id="rating4" name="rating" placeholder="Rate this topic">
			<input type="submit" id="send4" value="Send" onclick="send(4)">
			<h4>Comment Section</h4>
			<div id="Comments4"></div>

			<h3>Blog 5</h3>
			<p>Where would you like to live later on in your life?</p>
			<input type="text" id="name5" name="name" placeholder="Name">
			<input type="text" id="commentText5" name="comment" placeholder="Comment">
			<input type="number" id="rating5" name="rating" placeholder="Rate this topic">
			<input type="submit" id="send5" value="Send" onclick="send(5)">
			<h4>Comment Section</h4>
			<div id="Comments5"></div>
		</div>
		<br>
		<br>
		<br>
</main>
<script type="text/javascript" src="js/blog.js"></script>
</body>
<jsp:include page="footer.jsp">
	<jsp:param name="title" value="Home" />
</jsp:include>
</html>