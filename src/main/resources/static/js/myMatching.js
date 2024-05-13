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

function goToMyPage() {
    window.location.href = "/api/mypage/admin_id";
}

// 푸터의 너나들이 로고 누르면 페이지 최상단으로 이동
function scrollToTop() {
    window.scrollTo({top: 0, behavior: 'smooth'});
}