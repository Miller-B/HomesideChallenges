$(document).ready(function () {

    $('#send-button').click(function (event) {

$.ajax({
    type: "POST",
    url: "http://textbelt.com/text + phone + 
    data: JSON.stringify({
        phone: $("#add-phone").val(),
        message: $("#add-message").val(),
    
       
    }),
    headers: {
        "Accept": "application/json",
        "Content-Type": "application/json"
    },


})
    })
});