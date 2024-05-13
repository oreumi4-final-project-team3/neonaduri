
function searchSpot() {
    // 입력 필드에서 값 가져오기
    var searchText = document.getElementById("searchInput").value;

    // 만약 검색어가 비어 있으면 알림 표시
    if (searchText === "") {
        alert("검색어가 비어있습니다.");
        return;
    }

    // 입력된 도시 이름으로 검색
    window.location.href = "/api/search?searchText=" + encodeURIComponent(searchText);
}

function getPostIdAndNavigate() {
    const postId = document.querySelector('.postId').value;
    console.log("Post ID is: ", postId);
    window.location.replace("/api/spot/" + postId);
}


document.addEventListener("DOMContentLoaded", function() {
    const userBirthElements = document.querySelectorAll(".userBirth");
    const userAgeElements = document.querySelectorAll(".userAge");

    userBirthElements.forEach(function(userBirthElement, index) {
        const userBirth = userBirthElement.textContent;
        const birthYear = parseInt(userBirth.substring(0, 4));
        const currentYear = new Date().getFullYear();
        const age = currentYear - birthYear + 1;
        var ageText = '';

        if (age < 20) {
            ageText = "10대";
        } else if (age >= 20 && age < 30) {
            ageText = "20대";
        } else if (age >= 30 && age < 40) {
            ageText = "30대";
        } else if (age>=40 && age<50){
            ageText = "40대";
        } else{
            ageTex="50대 이상";
        }

        // 각 요소에 대해 연령 정보 설정
        userAgeElements[index].textContent = ageText;
    });
})
