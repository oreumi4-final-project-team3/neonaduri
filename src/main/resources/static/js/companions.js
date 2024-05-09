function goToHerePage() {
    window.location.href = "/api/spots";
}
function goToCompanionsPage() {
    window.location.href = "/api/posts";
}

// 연령 계산
const postElements = document.querySelectorAll(".tourist-site");

postElements.forEach(function(postElement) {

    const birthElement = postElement.querySelector(".user-birth");
    const birthStr = birthElement.textContent;
    const birthStrDate = birthStr.split("T")[0];
    const birthDate = new Date(birthStrDate);

    const koreanAge = calculateKoreanAge(birthDate);
    const ageGroup = calculateAgeGroup(koreanAge);

    const ageElement = postElement.querySelector(".age");

    ageElement.textContent = ageGroup;
});

// 연령 계산(대한민국)
function calculateKoreanAge(birthDate) {
    const currentYear = new Date().getFullYear();
    const birthYear = birthDate.getFullYear();
    const koreanAge = currentYear - birthYear + 1;
    return koreanAge;
}

// 연령대 분류
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
        return "50대이상";
    }
}