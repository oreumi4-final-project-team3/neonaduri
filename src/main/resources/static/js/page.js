function goToHerePage() {
    window.location.href = "/spots";
}
function goToReviewPage(){
    window.location.href = "/reviews";
}
function goToMainPage() {
    window.location.href = "/neonaduri";
}
function goToTogetherPage(){
    window.location.href = "/companions"
}
// 페이지 렌더링을 위해 관리자 id로 userId 임시 설정
function goToMyPage() {
    window.location.href = "/api/mypage/admin_id";
}
function goToLoginPage() {
    window.location.href = "/login";
}
function goToWishListPage(){
    window.location.href = "/api/wishlist/admin_id";
}