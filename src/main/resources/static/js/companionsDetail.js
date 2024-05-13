const bookingButton = document.getElementById('booking-btn');
const wishingButton = document.getElementById('wishing-btn');

function goToMainPage() {
    window.location.href = "/api/main";
}

function goToHerePage() {
    window.location.href = "/api/spots";
}

function goToCompanionsPage() {
    window.location.href = "/companions";
}

function goToReviewPage() {
    window.location.href = "/reviews";
}

function goToMyPage() {
    window.location.href = "/api/mypage/admin_id";
}

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