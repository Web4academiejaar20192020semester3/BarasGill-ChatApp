var getAllFriendsRequest = new XMLHttpRequest();
var getStatusRequest = new XMLHttpRequest();

window.onload = function () {
    getFriends();
    getStatus();
};

function getFriends() {
    getAllFriendsRequest.open("GET", "Controller?action=GetFriendsList", true);
    getAllFriendsRequest.onreadystatechange = getFriendsData;
    getAllFriendsRequest.send(null);
}

function getFriendsData() {
    if (getAllFriendsRequest.status === 200) {
        if (getAllFriendsRequest.readyState === 4) {
            var serverResponse = JSON.parse(getAllFriendsRequest.responseText);
            var friendsOverview = document.getElementById("friendsOverview");
            var tbody = friendsOverview.lastElementChild;
            tbody.innerHTML="";


            //fill table with friends
            for (var i = 0; i < serverResponse.length; i++) {
                var tr = document.createElement("tr");
                var td1 = document.createElement("td");
                var td2 = document.createElement("td");
                td1.appendChild(document.createTextNode(serverResponse[i].nickName));
                tr.appendChild(td1);
                td2.appendChild(document.createTextNode(serverResponse[i].status));
                tr.appendChild(td2);
                tbody.appendChild(tr);
            }

            setTimeout("getFriends()", 10000);
        }
    }
}

var newFriendRequest = new XMLHttpRequest();
var addNewFriendButton = document.getElementById('addNewFriendButton');
addNewFriendButton.onclick = function () {
    addNewFriend();
}

function addNewFriend () {
    var newFriend = document.getElementById("friend").value;

    newFriendRequest.open("POST", "Controller?action=AddFriend", true);
    newFriendRequest.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
    newFriendRequest.send("newFriend="+newFriend);
    newFriendRequest.onreadystatechange = getFriends;
}

var removeFriendRequest = new XMLHttpRequest();
var removeFriendButton = document.getElementById('removeFriendButton');
removeFriendButton.onclick = function () {
    removeFriend();
}

function removeFriend () {
    var oldFriend = document.getElementById("friend").value;

    removeFriendRequest.open("POST", "Controller?action=RemoveFriend", true);
    removeFriendRequest.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
    removeFriendRequest.send("oldFriend="+oldFriend);
    removeFriendRequest.onreadystatechange = getFriends;
}

function getStatus() {
    getStatusRequest.open("GET", "Controller?action=GetStatus", true);
    getStatusRequest.onreadystatechange = getStatusData;
    getStatusRequest.send(null);
}

function getStatusData () {
    if (getStatusRequest.status == 200) {
        if (getStatusRequest.readyState == 4) {
            var status = getStatusRequest.responseText;
            var statusDiv = document.getElementById("myCurrentStatus");
            var statusParagraph = statusDiv.childNodes[0];

            if (statusParagraph == null) {
                statusParagraph = document.createElement('div');
                statusParagraph.id = "newStatusText";
                var statusText = document.createTextNode(status);
                statusParagraph.appendChild(statusText);
                statusDiv.appendChild(statusParagraph);
            }
            else {
                var statusText = document.createTextNode(status);
                statusParagraph.removeChild(statusParagraph.childNodes[0]);
                statusParagraph.appendChild(statusText);
            }
            setTimeout(getStatus, 4000);
        }
    }
}

var changeStatusRequest = new XMLHttpRequest();
var changeStatusButton = document.getElementById('changeStatusButton');
changeStatusButton.onclick = function () {
    changeStatus();
}

function changeStatus () {
    var newStatus = document.getElementById("newStatus").value;

    changeStatusRequest.open("POST", "Controller?action=ChangeStatus", true);
    changeStatusRequest.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
    changeStatusRequest.send("newStatus="+newStatus);
    changeStatusRequest.onreadystatechange = getStatus;
}