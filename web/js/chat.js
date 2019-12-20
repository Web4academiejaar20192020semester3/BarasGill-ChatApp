var contactPerson;

$(function(){
        $("#openChat").on("click",function(){
                $("div#chat").fadeIn("slow");
                $("button#closeChat").show();
                $("button#openChat").hide();
        });
        $("#closeChat").on("click",function(){
                $("div#chat").hide();
                $("button#openChat").show();
                $("button#closeChat").hide();
                $("p#chatStart").show();
                $("p#chatStartButton").show();
                $("p#messageStart").hide();
                $("p#messageStartButton").hide();
                $("div#messages").hide();
        });
        $("#startChatWith").on("click", function () {
                $("p#chatStart").hide();
                $("p#chatStartButton").hide();
                $("p#messageStart").show();
                $("p#messageStartButton").show();
                $("div#messages").show();
        })
});

$(function () {
        $("#startChatWith").on("click", function () {
                var contactPersonUserId = document.getElementById("contactPerson").value;
                openChat(contactPersonUserId);
        })
});

function openChat(contactPersonUserId) {
        contactPerson = contactPersonUserId;
        var messageBoxBody =
            "<h4>Chatting with " + contactPerson + "</h4>" +
            "<div id='messageContent'></div>" +
            "<p id='messageStart'>" +
                "<label for='message'>Message</label>" +
                "<textarea id='message' name='message'></textarea>" +
            "</p>" +
            "<p id='sendMessageButton'>" +
                "<button type=\"button\" id=\"sendMessage\" onclick=\"sendMessage('" + contactPerson + "')\">Send</button>" +
            "</p>";
        $("div#messages").html(messageBoxBody);
        getChat();
        setInterval(getChat, 3000);
}


function getChat() {
        if(contactPerson !== ""){
                $.ajax({
                        method: "GET",
                        url: "Controller?action=GetChat&contactPerson=" + contactPerson,
                        success: function (serverResponse) {
                                console.log(serverResponse);
                                $("div#messageContent").empty();
                                for (var i = 0; i < serverResponse.length; i++) {
                                        $("div#messageContent").append("<p>" + serverResponse[i] + "</p>")
                                }
                        },
                        error: function() {
                                console.log("Something went wrong with the chat connection");
                        }
                });
        }
}

function sendMessage(id) {
        var message = $("textarea#message").val();
        console.log(message, id, "Send Message");
        $.post("Controller", {action: "SendMessage", message: message, contactPersonUserId: id});
}
