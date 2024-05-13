function updateUser() {
    // 사용자가 입력한 데이터를 가져옵니다.
    var userEmail = document.getElementById('userEmail').value;
    var userRegion = document.getElementById('userRegion').value;

    // 현재 페이지 URL에서 userId 추출
    var userId = window.location.pathname.split('/').pop();

    // 가져온 데이터를 JSON 형식으로 변환합니다.
    var userData = {
        userEmail: userEmail,
        userRegion: userRegion,
    };

    // AJAX 요청을 수행합니다.
    fetch('/api/users/' + userId, {
        method: 'PUT',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(userData)
    })
        .then(response => {
            if (response.ok) {
                // 성공적으로 업데이트되었을 때의 처리
            } else {
                // 실패했을 때의 처리
            }
        })
        .catch(error => {
            console.error('Error:', error);
        });
}

function updateUserDetails() {
    var userIntro = document.getElementById('userIntro').value;
    var userStyle = document.getElementById('userStyle').value;
    var userMbti = document.getElementById('userMbti').value;
    var userId = window.location.pathname.split('/').pop();

    var userDetailsData = {
        userIntro: userIntro,
        userStyle: userStyle,
        userMbti: userMbti
    };

    fetch('/api/userDetails/' + userId, {
        method: 'PUT',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(userDetailsData)
    })
        .then(response => {
            if (response.ok) {
                // 성공적으로 업데이트되었을 때의 처리
            } else {
                // 실패했을 때의 처리
            }
        })
        .catch(error => {
            console.error('Error updating user details:', error);
        });
}

function reloadPage() {
    location.reload();
}

function uploadImage() {
    var fileInput = document.getElementById('file-upload');
    var file = fileInput.files[0];
    var formData = new FormData();
    formData.append('file', file);

    fetch('/uploadImage', {
        method: 'POST',
        body: formData
    })
        .then(response => response.text())
        .then(data => {
            console.log('Uploaded image path:', data);
            // 여기서 이미지 경로를 받아와서 화면에 표시하거나 다른 동작을 수행합니다.
        })
        .catch(error => {
            console.error('Error:', error);
        });
}

// Users 테이블의 userImg 경로 가져오기
// function uploadImage(input) {
//     if (input.files && input.files[0]) {
//         var formData = new FormData();
//         formData.append("file", input.files[0]);
//
//         // AJAX를 사용하여 이미지 업로드
//         fetch('/uploadImage', {
//             method: 'POST',
//             body: formData
//         })
//             .then(response => response.json())
//             .then(data => {
//                 // 데이터베이스에 저장된 이미지 경로를 가져와서 화면에 표시
//                 document.querySelector('.profile_img').src = data.imageUrl;
//             })
//             .catch(error => {
//                 console.error('Error:', error);
//             });
//     }
// }

// 프로필 이미지가 존재하면 띄우고, 없으면 default 이미지를 띄움.
document.addEventListener("DOMContentLoaded", function() {
    let userImg = document.getElementById("userImg").innerText.trim();
    let profileImg = document.querySelector(".profile_img");

    if (userImg) {
        profileImg.src = userImg; // 프로필 이미지가 있으면 해당 이미지로 설정
    } else {
        profileImg.src = "/images/havenotimage.png"; // 프로필 이미지가 없으면 디폴트 이미지로 설정
    }
});

// 푸터의 너나들이 로고 누르면 페이지 최상단으로 이동
function scrollToTop() {
    window.scrollTo({top: 0, behavior: 'smooth'});
}