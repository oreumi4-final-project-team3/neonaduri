
function searchSpot() {
    // 입력 필드에서 값 가져오기
    var spotName = document.getElementById("searchInput").value;

    // 만약 검색어가 비어 있으면 알림 표시
    if (spotName === "") {
        alert("도시 이름을 입력하세요.");
        return;
    }

    // 입력된 도시 이름으로 검색
    window.location.href = "/api/spots/name/" + encodeURIComponent(spotName);
}

function navigateToSpotDetail(element) {
    const spotId = element.getAttribute('data-spotId');
    window.location.href = "/api/spot/" + spotId;
}
function getSpotIdAndNavigate(element) {
    const spotId = element.parentNode.querySelector('.spotId').value;
    window.location.replace("/api/spot/" + spotId);
}
function goToHerePage() {
    window.location.href = "/api/spots";
}
function goToReviewPage(){
    window.location.href = "/api/reviews";
}