

// 연령 계산
const postElements = document.querySelectorAll(".tourist-site");

postElements.forEach(function(postElement) {

    const birthElement = postElement.querySelector(".userBirth");
    const birthStr = birthElement.textContent;
    const birthStrDate = birthStr.split("T")[0];
    const birthDate = new Date(birthStrDate);

    const koreanAge = calculateKoreanAge(birthDate);
    const ageGroup = calculateAgeGroup(koreanAge);

    const ageElement = postElement.querySelector(".userAge");

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

// 각 지역 선택 시 게시글 리스트 처리
document.addEventListener('DOMContentLoaded', function () {
    const regionButtons = document.querySelectorAll('.region-btn');
    regionButtons.forEach(button => {
        button.addEventListener('click', function() {
            const areaCode = this.getAttribute('data-area-code');
            fetchPosts(areaCode);
            window.history.pushState({areaCode: areaCode}, `Region ${areaCode}`, `/companions/${areaCode}`);
            location.href = `/companions/${areaCode}`;
        });
    });
});

function fetchPosts(areaCode) {
    fetch(`/companions/${areaCode}`)
        .then(response => response.json())
        .then(data => {
            const postsList = data.map(post => `
                <div class="tourist-sites">
                   
                </div>
            `).join('');
            document.querySelector('.tourist-sites').innerHTML = postsList;
        })
        .catch(error => console.error('Error:', error));
}

//CJW
//업로드 기능
const createButton = document.getElementById('create-btn');

if(createButton){
    createButton.addEventListener('click',event=>{
        event.preventDefault();

        const inputData={
            title : document.getElementById('title').value,
            content: document.getElementById('content').value,
            category: "companion",
            areaCode: document.getElementById('areaCode').value,
            spotName: document.getElementById('spotName').value,
            address: document.getElementById('address').value,

            comRecruit: document.getElementById('comRecruit').value,
            comStart: document.getElementById('comStart').value,
            comEnd: document.getElementById('comEnd').value
        }

        const formData = new FormData();
        formData.append('data', new Blob([JSON.stringify(inputData)], {type: "application/json",}));
        const fileInput = document.getElementById('fileInput');
        formData.append('file', fileInput.files[0]);

        fetch('/api/companions',{
            method: 'POST',
            body: formData
        }).then(()=>{
          alert('등록 완료되었습니다');
          location.replace("companions");
        })
    });
}