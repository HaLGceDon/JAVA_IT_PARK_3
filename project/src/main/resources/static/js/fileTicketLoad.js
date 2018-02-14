function uploadFile(file, ticketId) {
    var formData = new FormData();
    formData.append("file", file);
    formData.append("destination", "ticket");
    formData.append("ticketId", ticketId);


    $.ajax({
        type: "POST",
        url: "/files",
        data: formData,
        contentType: false,
        processData: false,
        success: function (data) {
            window.location = 'http://localhost/tickets_redaction';
        },
        error: function (data) {
            alert(data.status);
        }
    })
}