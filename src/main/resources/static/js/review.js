// "여기갈까?" 버튼 클릭 시 관광지 게시글 리스트로 이동
function goToHerePage() {
    window.location.href = "/api/spots";
}
// 전체 버튼 클릭 시 전체리스트로 이동
function goToAllPage() {
    window.location.href = "/reviews";
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

// 지역 이미지 업데이트 함수
function updateRegionImage(regionCode) {
    const imageElement = document.getElementById('regionImage');
    const imagePath = getImagePathByRegion(regionCode);
    imageElement.src = imagePath;
}

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

// 페이지 로드 시 선택된 지역 이미지 설정
document.addEventListener('DOMContentLoaded', function() {
    const selectedRegion = localStorage.getItem('selectedRegion') || '1'; // 로컬 스토리지에서 선택된 지역 코드 가져오기, 기본값은 '1'
    updateRegionImage(selectedRegion); // 가져온 지역 코드로 이미지 업데이트
});

// 전체 버튼에 대한 클릭 이벤트 처리
document.querySelector('.region-all-btn').addEventListener('click', function(event) {
    event.preventDefault();
    const defaultRegion = '1'; // 서울을 나타내는 지역 코드
    localStorage.setItem('selectedRegion', defaultRegion); // 로컬 스토리지에 저장
    updateRegionImage(defaultRegion); // 대표 이미지 업데이트 함수 호출
});

function goToReviewPage(){
    window.location.href = "/reviews";
}
function goToMainPage(){
    window.location.href = "/api/main";
}
