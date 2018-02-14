function uploadFile(file) {
    var formData = new FormData();
    formData.append("file", file);
    formData.append("destination", "gallery");

    $.ajax({
        type: "POST",
        url: "/files",
        data: formData,
        contentType: false,
        processData: false,
        success: function (data) {
            window.location = 'http://localhost/gallery';
        },
        error: function (data) {
            alert(data.status);
        }
    })
}

