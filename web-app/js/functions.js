function getChatLog() {
    $.ajax({
        type: "GET",
        contenType: "JSON",
        url: "getLastChatContent"
    }).done(function(response) {
        $("#chatLog").html("");
        var chatArray = response.response;
        var chatObject;
        for (var i = 0; i < chatArray.length; i++) {
            chatObject = chatArray[i];
            $("#chatLog").append("<b>[" + chatObject.userName + "]</b> <span class=\"chatConten\">" + chatObject.content + "</span><p class=\"tiny\">" + chatObject.createdDate + "</p><br>");
        }
    });
}
function getFileLog() {
    /*$.ajax({
        type: "GET",
        contenType: "JSON",
        url: "Chat/getLastChatContent"
    }).done(function(response) {
        $("#chatLog").html("");
        var chatArray = response.response;
        var chatObject;
        for (var i = 0; i < chatArray.length; i++) {
            chatObject = chatArray[i];
            $("#chatLog").append("<b>[" + chatObject.userName + "]</b> <span class=\"chatConten\">" + chatObject.content + "</span><p class=\"tiny\">" + chatObject.createdDate + "</p><br>");
        }
    });*/
}
function tellMeSomething(content) {
    content = content.trim();
    var idUser = $("#idUser").val();
    $.ajax({
        type:"GET",
        contentType:"JSON",
        url:"addLineToChat",
        data:{
            idUser:idUser,
            content:content
        }
    }).fail(function(error){
        console.error(error.message);
    });
}
$(document).on("keyup", "#message", function() {
    if ($(this).val().length > 0) {
        $("#sendMessage").removeAttr('disabled');
    } else {
        $("#sendMessage").attr('disabled', true);
    }
});
$(document).on("click", "#sendMessage", function() {
    var content = $("#message").val();
    tellMeSomething(content);
});
$(document).ready(function() {
    setInterval(function() {
        getChatLog();
        getFileLog();
    }, 350);
    setTimeout(function(){
        $("#successBanner").fadeOut();
    },500);
});
$(document).on("click","#successBanner",function(){
    $(this).fadeOut();
});
$( window ).unload(function() {
alert( "Handler for .unload() called." );
});
/*
$( window ).unload(function() {
    alert("u.u");
    var idUser = $("#idUser").val();
    $.ajax({
        type:"GET",
        contentType:"JSON",
        url:"addLineToChat",
        data:{
            idUser:idUser,
            content:"El usuario ha cerrado sesi&oacute;n"
        }
    }).done(function(){
        alert("adios")
    });
    //tellMeSomething("<span style=\"color:red;\"><b>Ha cerrado sesi&oacute;n</b></span>");
});*/
    