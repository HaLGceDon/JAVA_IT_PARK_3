function uploadFile(file) {
    if (!file || !file.type.match(/image.*/)) return alert("Неправильный формат файла! Выберите JPG, GIF или PNG.");
    if (file.size > 1048576) return alert("Размер файла слишком большой, допустимо не более 1 MB.");
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

