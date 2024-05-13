function updateUser() {
    // 사용자가 입력한 데이터를 가져옵니다.
    var userEmail = document.getElementById('userEmail').value;
    var userRegion = document.getElementById('userRegion').value;
    var userName = document.getElementById('userName').value;

    // 현재 페이지 URL에서 userId 추출
    var userId = window.location.pathname.split('/').pop();

    // 가져온 데이터를 JSON 형식으로 변환합니다.
    var userData = {
        userEmail: userEmail,
        userRegion: userRegion,
        userName: userName
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

// 페이지 링크
function goToMainPage() {
    window.location.href = "/api/main";
}

function goToHerePage() {
    window.location.href = "/api/spots";
}
function goToReviewPage() {
    window.location.href = "/reviews";
}

function goTogether() {
    window.location.href = "/companions";
}

function reloadPage() {
    location.reload();
}

// 프로필 사진 업로드 기능
// 파일 업로드 input 요소
var fileInput = document.getElementById('file-upload');

// 파일 업로드 버튼을 클릭할 때 이미지 업로드 함수 호출
fileInput.addEventListener('change', uploadImage);

function uploadImage() {
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
            // 이미지 경로를 받아와서 화면에 표시
            var profileImg = document.querySelector(".profile_img");
            profileImg.src = data; // 이미지 경로를 받아와서 화면에 표시
        })
        .catch(error => {
            console.error('Error:', error);
        });
}

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