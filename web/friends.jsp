<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<jsp:include page="head.jsp">
    <jsp:param name="title" value="Chat App" />
</jsp:include>
<jsp:include page="header.jsp">
    <jsp:param name="title" value="Friends List" />
</jsp:include>
<body>
<main>
    <div class="blockDiv">
        <div class="leftBlock">
            <p>Dear ${user.getRole()} - ${user.getFirstName()},</p>
            <p>Welcome to your friends list!</p>
        </div>
        <div class="rightBlock">
            <p> You are currently:</p>
            <div id="myCurrentStatus"></div>
        </div>
    </div>
    <div class="blockDiv">
        <div class="leftBlock">
            <table id="friendsOverview">
                <thead>
                    <th>Friend</th>
                    <th>Status</th>
                </thead>
                <tbody>
                </tbody>
            </table>
        </div>
        <div class="rightBlock">
            <div>
                <h3>Change Status</h3>
                <p>
                    <label for="newStatus">New Status</label>
                    <input type="text" id="newStatus" name="Custom Status" value="New Status">
                </p>
                <p>
                    <input type="submit" id="changeStatusButton" value="Change">
                </p>
            </div>
            <div>
                <h3>Add or remove a Friend</h3>
                <p>
                    <label for="friend">UserId / Email</label>
                    <input type="text" id="friend" name="friendUserId" value="firstname@ucll.be">
                </p>
                <p>
                    <input type="submit" id="addNewFriendButton" value="Add">
                    <input type="submit" id="removeFriendButton" value="Remove" style="margin-left: 5px">
                </p>
            </div>
        </div>
    </div>
    <br>
    <div class="blockDiv">
        <h2>Chat</h2>
        <button id="openChat">Open Chat</button>
        <button hidden id="closeChat">Close Chat</button>
        <div hidden id="chat" style="width:100%;min-height:100px;display:none;background-color:lightcyan;padding:10px;margin-top:10px">
            <p id="chatStart">
                <label for="contactPerson">Start to chat with:</label>
                <input type="text" id="contactPerson" name="contactPersonUserId" value="firstname@ucll.be">
            </p>
            <p id="chatStartButton">
                <input type="submit" id="startChatWith" value="Start Chatting">
            </p>
            <div id="messages" style="border: 1px solid gray;padding:10px;margin:20px 20px 20px 0"></div>
        </div>
    </div>
    <br>
    <br>
    <br>
</main>
<script type="text/javascript" src="js/friends.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script type="text/javascript" src="js/chat.js"></script>
<jsp:include page="footer.jsp">
    <jsp:param name="title" value="Home"/>
</jsp:include>
</body>

</html>
