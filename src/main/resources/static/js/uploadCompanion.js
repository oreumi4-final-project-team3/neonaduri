var fileInput = document.getElementById('fileInput');

var uploadName = document.querySelector('.upload-name');

fileInput.addEventListener('change', function() {
    if (fileInput.files.length > 0) {
        uploadName.value = fileInput.files[0].name;
    } else {
        uploadName.value = "미 첨부 시, 기본 사진으로 게시됩니다.";
    }
});