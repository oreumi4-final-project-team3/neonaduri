const bookingButton = document.getElementById('booking-btn');

function goToMainPage() {
    window.location.href = "/api/main";
}
function goToHerePage() {
    window.location.href = "/api/spots";
}
function goToCompanionsPage() {
    window.location.href = "/companions";
}
function goToReviewPage(){
    window.location.href = "/reviews";
}

function goToMyPage() {
    window.location.href = "/api/mypage/admin_id";
}