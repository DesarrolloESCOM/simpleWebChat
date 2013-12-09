function getPreviewOfFile(nameOfFile) {
    var type = "";
    var container = ""
    console.log("Name of File : " + nameOfFile);
    $.ajax({
        type: "GET",
        contentType: "JSON",
        url: "getTypeOfFile",
        data: {
            nameOfFile: nameOfFile
        }
    }).done(function(response) {
        type = response;
        console.log(response);
        console.log("Response type" + type);
        var splittedType = type.split("/");
        if (splittedType[0] == "image") {
            container = "<img class=\"imagePreview\" src=\"../files/" + nameOfFile + "\"/>";
        } else if (splittedType[0] == "video") {
            container = "<div style=\"margin:200px 0 0 0;\"><video controls autoplay name=\"media\">";
            container += "<source src=\"../files/" + nameOfFile + "\" type=\"" + type + "\"/>";
            container += "</video></div>";
        } else if (splittedType[0] == "audio") {
            container = "<div style=\"margin:200px 0 0 0;\"><video controls autoplay name=\"media\">";
            container += "<source src=\"../files/" + nameOfFile + "\" type=\"" + type + "\"/>";
            container += "</video></div>";
        } else if (splittedType[0] == "text") {
            container = "<iframe src=\"../files/" + nameOfFile + "\" width=\"100%\" height=\"100%\" frameborder=\"0\">";
        } else {
            container = "<h3>Contenido no soportado</h3>"
        }
        $("#previewContent").html(container);
    });
}
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
        $("#chatLog").scrollTop($("#chatLog")[0].scrollHeight);
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
            $("#filePanel").append("<div class=\"chatBlock\"><a href=\"#\"><input type=\"hidden\" name=\"fileName\" value=\"" + chatObject.nameofFile + "\"/><b>[" + chatObject.username + "]</b> <span>" + chatObject.nameofFile + "</span></a></div>");
        }
        var draggableContent = $("#filePanel a");
        $.each(draggableContent, function() {
            $(this).draggable();
        });
    }).fail(function(response) {
        $("#filePanel").html("");
        $("#filePanel").append("<div class=\"chatBlock\"><a href=\"#\">" + response.responseText + "</a></div>");
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
    if ($(this).val().trim().length > 0) {
        $("#sendMessage").removeAttr('disabled');
    } else {
        $("#sendMessage").attr('disabled', true);
    }
});
$(document).on("click", "#sendMessage", function() {
    var content = $("#message").val();
    tellMeSomething(content);
    $("#message").val("");
    //$("#mydiv").scrollTop($("#mydiv")[0].scrollHeight);
});
$(document).ready(function() {
    var valorCookie = $.cookie("successBanner") == false ? false : true;
    setInterval(function() {
        getChatLog();
    }, 350);
    setInterval(function() {
        getFileLog();
    }, 5000);
    if (!valorCookie) {
        $("#successBanner").dialog({
            autoOpen: valorCookie,
            height: 200,
            width: 500,
            close: function() {
                $.cookie("successBanner", false, {expires: 1});
            }
        });
    } else {
        $("#successBanner").dialog({
            autoOpen: !valorCookie,
            height: 200,
            width: 500,
            close: function() {
                $.cookie("successBanner", false, {expires: 1});
            }
        });
    }
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
            //console.log(ui);           
            var $element = ui.draggable;
            var nameOfFile = $element.find("input").val();
            $element.fadeOut(function() {
                getFileLog();
            });
            $("#titleReceiver").html("Vista previa [" + nameOfFile + "]")
            //console.log(nameOfFile);
            getPreviewOfFile(nameOfFile);
        }
    });
});
$(document).on("click", "#successBanner", function() {
    $(this).fadeOut();
});
$(document).on("click","#closeSession",function(){
    $("#logoutForm").submit();
});
//$("#draggable").draggable();
