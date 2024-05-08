// mypage의 각 데이터 영역에서 연필 모양 수정 버튼을 클릭하면 데이터를 수정할 수 있음
var dto = {
    userName: "", // 사용자 이름
    userEmail: "", // 사용자 이메일
    userImg: "", // 사용자 이미지
    userRegion: 0, // 사용자 지역 코드
};

document.querySelectorAll('.edit').forEach(button => {
    button.addEventListener('click', function() {
        dto.userName = document.getElementById('userName').value;
        dto.userEmail = document.getElementById('userEmail').value;
        dto.userRegion = document.getElementById('userRegion').value;

        // DTO를 JSON 문자열로 변환하여 서버로 전송
        fetch('/updateUserData', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(dto)
        })
            .then(response => {
                // 서버 응답에 따른 처리
                if (response.ok) {
                    // 성공적으로 업데이트되었을 때의 처리
                } else {
                    // 실패했을 때의 처리
                }
            })
            .catch(error => {
                console.error('Error:', error);
            });
    });
});

// 프로필 이미지가 존재하면 띄우고, 없으면 default 이미지를 띄움.
document.addEventListener("DOMContentLoaded", function() {
    var userImg = document.getElementById("userImg").innerText.trim();
    var profileImg = document.querySelector(".profile_img");

    if (userImg) {
        profileImg.src = userImg; // 프로필 이미지가 있으면 해당 이미지로 설정
    } else {
        profileImg.src = "../static/images/havenotimage.png"; // 프로필 이미지가 없으면 디폴트 이미지로 설정
    }
});