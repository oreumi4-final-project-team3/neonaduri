const bookingButton = document.getElementById('booking-btn');
const wishingButton = document.getElementById('wishing-btn');

//예약 버튼
if (bookingButton) {
    bookingButton.addEventListener('click', event => {
        event.preventDefault();

        const comId = document.getElementById('companion-id').value;

        fetch('/api/bookers/' + comId, {
            method: 'POST'
        }).then(() => {
            fetch('/api/companions/' + comId + '/bookers', {
                method: 'PUT'
            })
            //이메일 발송 or controller 에 넘겨도 되고
            alert('예약이 완료되었습니다.')
            location.replace('/companions/id/' + comId);
        });
    });
}

if (wishingButton) {
    wishingButton.addEventListener('click', event => {
        event.preventDefault();

        const comId = document.getElementById('companion-id').value;
        const postId = document.getElementById('post-id').value;

        fetch('/api/wishlist/' + postId, {
            method: 'POST'
        }).then(() => {
            fetch('/api/companions/'+comId+'/wishlist',{
                method: 'PUT'
            })
            alert('찜이 완료되었습니다.')
            location.replace('/companions/id/' + comId);
        })


    })
}


// 연령 계산
const birthElement = document.querySelector(".userBirth");
const birthStr = birthElement.textContent;
const birthStrDate = birthStr.split("T")[0];
const birthDate = new Date(birthStrDate);

// 연령 계산(대한민국)
const koreanAge = calculateKoreanAge(birthDate);
const ageGroup = calculateAgeGroup(koreanAge);

// 연령대를 표시할 요소에 연령대 텍스트 설정
const ageElement = document.querySelector(".userAge");
ageElement.textContent = ageGroup;

// 연령대 계산 함수
function calculateKoreanAge(birthDate) {
    const currentYear = new Date().getFullYear();
    const birthYear = birthDate.getFullYear();
    const koreanAge = currentYear - birthYear + 1;
    return koreanAge;
}

// 연령대 분류 함수
function calculateAgeGroup(koreanAge) {
    if (koreanAge >= 10 && koreanAge < 20) {
        return "10대";
    } else if (koreanAge >= 20 && koreanAge < 30) {
        return "20대";
    } else if (koreanAge >= 30 && koreanAge < 40) {
        return "30대";
    } else if (koreanAge >= 40 && koreanAge < 50) {
        return "40대";
    } else {
        return "50대 이상";
    }
}
document.addEventListener('DOMContentLoaded', function () {
    const replyButton = document.getElementById('replyButton');

    replyButton.addEventListener('click', function(event) {
        // 기본 동작을 방지
        event.preventDefault();


        const postId = document.getElementById('post-id').value;
        const content = document.querySelector('.tour-info-comment-form input[type="text"]').value;

        const requestBody = {
            content: content
        };

        // API 요청 보내기
        fetch(`/api/posts/${postId}`, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(requestBody)
        }).then(response => {
            if (!response.ok) {
                throw new Error(`HTTP error! status: ${response.status}`);
            }
            return response.json();
        })
            .then(data => {
                console.log('Success:', data);
                window.location.reload();
            })
            .catch((error) => {
                console.error('Error:', error);
                alert('댓글 등록에 실패하였습니다.');
            });
    });
});

document.addEventListener('DOMContentLoaded', function () {
    const commentContainers = document.querySelectorAll('.comment-container');

    commentContainers.forEach(container => {
        const editButton = container.querySelector('.edit-button');
        const commentContent = container.querySelector('.comment-content');
        const userId = container.querySelector('.user-id').value;
        const postId = container.querySelector('.posts-id').value;
        const replyId = editButton.getAttribute('data-id');

        editButton.addEventListener('click', function () {
            if (editButton.textContent === '수정') {
                const currentText = commentContent.textContent;
                commentContent.innerHTML = `<input type="text" value="${currentText}" class="edit-input">`;
                editButton.textContent = '저장';
            } else {
                const updatedText = commentContent.querySelector('.edit-input').value;
                commentContent.textContent = updatedText;
                editButton.textContent = '수정';

                // API 호출 부분
                fetch(`/api/posts/${postId}/${replyId}/${userId}`, {
                    method: 'PUT',
                    headers: {
                        'Content-Type': 'application/json',
                    },
                    body: JSON.stringify({ content: updatedText })
                }).then(response => {
                    if (!response.ok) {
                        throw new Error('Network response was not ok');
                    }
                    return response.json();
                }).then(data => {
                    console.log('Success:', data);
                }).catch((error) => {
                    console.error('Error:', error);
                });
            }
        });
    });
});