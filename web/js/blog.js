var webSocket;

openSocket();

function openSocket(){
    webSocket = new WebSocket("ws://localhost:8081/Web_4_Jan_Web_exploded/blog");

    webSocket.onopen = function(event){
        console.log("Socket is opened");
    };
    webSocket.onmessage = function(event){
        writeResponse(event.data);
    };
    webSocket.onclose = function(event){
        writeResponse("Connection closed");
    };
}

class Comment {
    constructor(topicId, name, commentText, rating, guid) {
        this.topicId = topicId
        this.name = name;
        this.commentText = commentText;
        this.rating = rating;
        this.guid = guid;
    }
}

function send(topicId){
    var name = document.getElementById("name"+topicId).value;
    var commentText = document.getElementById("commentText"+topicId).value;
    var rating = document.getElementById("rating"+topicId).value;
    var guid = generateGuid();

    if(name === "" || commentText === "" || rating === "")
    {
        alert("All fields must be filled in!");
    }
    else
    {
        var commentToSend = new Comment(topicId, name, commentText, rating, guid);
        webSocket.send(JSON.stringify(commentToSend));
    }
}

function closeSocket(){
    webSocket.close();
}

function generateGuid() {
    return 'xxxxxxxx-xxxx-4xxx-yxxx-xxxxxxxxxxxx'.replace(/[xy]/g, function(c) {
        var r = Math.random() * 16 | 0, v = c == 'x' ? r : (r & 0x3 | 0x8);
        return v.toString(16);
    });
}

function writeResponse(comment) {
    var comments = JSON.parse(comment);
    console.log(comments);
    for (var i = comments.length-1; i < comments.length; i++) {
        var commentsDiv = document.getElementById("Comments"+comments[i].topicId);
        commentsDiv.innerHTML += "<p id='" + comments[i].guid + "'>" + comments[i].name + " reacted: '" + comments[i].commentText + "' and gave a rating of: " + comments[i].rating + "</p>";
    }
}
