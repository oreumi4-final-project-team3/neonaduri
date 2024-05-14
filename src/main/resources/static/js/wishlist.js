
// 관심있는 매칭 클릭 시 이동 , 시큐리티 필요
// function goToWishlistPage(){
//     window.location.href = "/api/wishlist";
// }
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
