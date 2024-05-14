document.addEventListener('DOMContentLoaded', function () {
    const replyButton = document.getElementById('replyButton');

    replyButton.addEventListener('click', function(event) {
        // 기본 동작을 방지
        event.preventDefault();

        const postId = document.getElementById('review-id').value;
        const content = document.querySelector('.tour-info-comment-form input[type="text"]').value;

        if (!content.trim()) {
            alert('댓글을 입력해 주세요.');
            return; // 함수 종료
        }

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
                throw new Error(`HTTP 에러: ${response.status}`);
            }
            return response.json();
        })
            .then(data => {
                window.location.reload();
            })
            .catch((error) => {
                alert('댓글 등록에 실패하였습니다.');
            });
    });
});
// 댓글 수정
document.addEventListener('DOMContentLoaded', function () {
    const commentContainers = document.querySelectorAll('.comment-container');

    commentContainers.forEach(container => {
        const editButton = container.querySelector('.edit-button');
        const commentContent = container.querySelector('.comment-content');
        const userId = container.querySelector('.user-id').value;
        const postId = document.getElementById('review-id').value;
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
                        throw new Error('댓글 수정 실패');
                    }
                    return response.json();
                }).then(data => {
                }).catch((error) => {
                    alert('예기치 못한 오류로 실패했습니다.');
                });
            }
        });
    });
});

//댓글 삭제
document.addEventListener('DOMContentLoaded', function () {
    const commentContainers = document.querySelectorAll('.comment-container');

    commentContainers.forEach(container => {
        const deleteButton = container.querySelector('.delete-button');
        const userId = container.querySelector('.user-id').value;
        const replyId = deleteButton.getAttribute('data-id');

        deleteButton.addEventListener('click', function () {
            if (confirm('댓글을 삭제하시겠습니까?')) {
                fetch(`/api/posts/${replyId}/${userId}`, {
                    method: 'DELETE'
                }).then(response => {
                    if (response.ok) {
                        return response.json();
                    } else {
                        throw new Error('댓글 삭제 실패');
                    }
                }).then(data => {
                    container.remove();
                }).catch(error => {
                    alert('댓글 삭제에 실패했습니다.');
                });
            }
        });
    });
});
function goToMyPage() {
    window.location.href = "/api/mypage/admin_id";
}

// 각 지역 선택시 관광지 게시글 리스트 처리
document.addEventListener('DOMContentLoaded', function() {
    const regionButtons = document.querySelectorAll('.region-btn');
    regionButtons.forEach(button => {
        button.addEventListener('click', function() {
            const areaCode = this.getAttribute('data-area-code');
            fetchSpots(areaCode);
            window.history.pushState({areaCode: areaCode}, `Region ${areaCode}`, `/reviews/${areaCode}`);
            location.href = `/reviews/${areaCode}`; // 주소를 변경 후 페이지를 새로고침합니다.
        });
    });
});
function fetchSpots(areaCode) {
    fetch(`/reviews/${areaCode}`)
        .then(response => response.json())
        .then(data => {
            const reviewsList = data.map(review => `
                <div class="tourist-site">
                    <img src="${review.imgLink}" alt="관광지 이미지">
                    <p>${review.postTitle}</p>
                    <h3>${review.spotName}</h3>
                    <p>${review.user.getUserName()}</p>
                </div>
            `).join('');
            document.querySelector('.tourist-sites').innerHTML = reviewsList;
        })
        .catch(error => console.error('Error:', error));
}

// 지역 별 대표 이미지 처리
document.querySelectorAll('.region-btn').forEach(button => {
    button.addEventListener('click', function(event) {
        event.preventDefault();
        const region = this.getAttribute('data-area-code'); // 지역 코드 가져오기
        localStorage.setItem('selectedRegion', region); // 로컬 스토리지에 저장
        updateRegionImage(region); // 이미지 업데이트 함수 호출
    });
});

// 지역 코드에 따른 이미지 경로 반환 함수
function getImagePathByRegion(region) {
    switch(region) {
        case '1': return '/images/seoul.png';
            break;
        case '2': return '/images/incheon.jpg';
            break;
        case '31': return '/images/kyungki.jpg';
            break;
        case '32': return '/images/kangwon.jpg';
            break;
        case '33': return '/images/chungbuk.png';
            break;
        case '34': return '/images/chungnam.jpg';
            break;
        case '35': return '/images/kyungbuk.jpg';
            break;
        case '36': return '/images/kyungnam.jpg';
            break;
        case '37': return '/images/jeonbuk.jpg';
            break;
        case '38': return '/images/jeonnam.jpg';
            break;
        case '39': return '/images/jeju.jpg';
            break;

        default: return '/images/seoul.png';
    }
}


function getAreaName(areaCode){
    switch (areaCode){
        case 1:
            return "서울";
            break;
        case 2:
            return "인천";
            break;
        case 31:
            return "경기";
            break;
        case 32:
            return "강원";
            break;
        case 33:
            return "충북";
            break;
        case 34:
            return "충남";
            break;
        case 35:
            return "경북";
            break;
        case 36:
            return "경남";
            break;
        case 37:
            return "전북";
            break;
        case 38:
            return "전남";
            break;
        case 39:
            return "제주";
            break;

    }
}
document.addEventListener('DOMContentLoaded', function() {
    // areaCode 값을 정수형으로 변환
    const areaCode = parseInt(document.getElementById('areaCode').value, 10);
    const areaText = document.getElementById('areaText');
    areaText.innerText = "지역 : " + getAreaName(areaCode);
});


