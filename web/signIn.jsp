<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<h4>Sign In</h4>
<form method="post" action="Controller?action=LogIn">
    <p>
        <label for="email">Your email </label>
        <input type="text" id="email" name="email" value="jan@ucll.be">
    </p>
    <p>
        <label for="password">Your password</label>
        <input type="password" id="password" name="password" value="t">
    </p>
    <p>
        <input type="submit" id="loginbutton" value="Log in">
    </p>
</form>