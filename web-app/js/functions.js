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
            $("#chatLog").append("<div class=\"chatBlock\"><span class=\"username\">[" + chatObject.userName + "]</span> <span class=\"content\">" + chatObject.content + "</span><span class=\"tiny\">" + chatObject.createdDate + "</span></div>");
        }
    });
}
function getFileLog() {
    $.ajax({
        type: "GET",
        contenType: "JSON",
        url: "getfileLog"
    }).done(function(response) {
        $("#filePanel").html("");
        var chatArray = response.fileResponse;
        var chatObject;
        for (var i = 0; i < chatArray.length; i++) {
            chatObject = chatArray[i];
            //<a class="btn btn-link" href="${createLink(action: 'signUp')}" target="_self">¿A&uacute;n no eres miembro? &Uacute;nete! Registrate aqu&iacute;!</a>
            $("#filePanel").append("<div class=\"chatBlock\"><li><a href=\"#\"><input type=\"hidden\" name=\"fileName\" value=\"" + chatObject.nameofFile + "\"/><b>[" + chatObject.username + "]</b> <span>" + chatObject.nameofFile + "</span></a></li></div>");
        }
        var draggableContent = $("#filePanel li");
        $.each(draggableContent, function() {
            console.log($(this).html());
            $(this).draggable();
        });
    });
}
function tellMeSomething(content) {
    content = content.trim();
    var idUser = $("#idUser").val();
    $.ajax({
        type: "GET",
        contentType: "JSON",
        url: "addLineToChat",
        data: {
            idUser: idUser,
            content: content
        }
    }).fail(function(error) {
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
    }, 350);
    setTimeout(function() {
        getFileLog();
    }, 350);
    $("#successBanner").dialog({
        autoOpen: true,
        height: 200,
        width: 500
    });
    $("#dialog-form").dialog({
        autoOpen: false,
        height: 500,
        width: 500,
        modal: true,
        buttons: {
            "Subir": function() {
                $("#fileUploader").submit();
            },
            Cancel: function() {
                $(this).dialog("close");
            }
        },
        close: function() {
            getFileLog();
            return true;
        }
    });
    $("#openUploadDialog").button().click(function() {
        $("#dialog-form").dialog("open");
    });
    $("#preview").droppable({
        drop: function(event, ui) {            
            console.log(ui);           
        }
    });
});
$(document).on("click", "#successBanner", function() {
    $(this).fadeOut();
});
//$("#draggable").draggable();
