<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<h4>Sign Up</h4>
<form method="post" action="Controller?action=SignUp">
    <p>
        <label for="firstName">Fristname </label>
        <input type="text" id="firstName" name="firstName">
    </p>
    <p>
        <label for="lastName">Lastname </label>
        <input type="text" id="lastName" name="lastName">
    </p>
    <p>
        <label for="signUpEmail">Email/UserId </label>
        <input type="email" id="signUpEmail" name="signUpEmail">
    </p>
    <p>
        <label>Gender </label>
        <input type="radio" name="gender" value="male"> Male<br>
        <input type="radio" name="gender" value="female"> Female<br>
    </p>
    <p>
        <label for="age">Age </label>
        <input type="number" id="age" name="age" min="0">
    </p>
    <p>
        <label for="signUpPassword">Password</label>
        <input type="password" id="signUpPassword" name="signUpPassword" value="t">
    </p>
    <p>
        <label for="repeatPassword">Repeat password</label>
        <input type="password" id="repeatPassword" name="repeatPassword" value="t">
    </p>
    <p>
        <input type="submit" id="signUpButton" value="Sign Up">
    </p>
</form>