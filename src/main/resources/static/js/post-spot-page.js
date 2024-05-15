
document.addEventListener('DOMContentLoaded', function() {
    addLineBreaks(); // 페이지 로드 완료 후 함수 호출
});

function addLineBreaks() {
    var pElement = document.querySelector('.spot-details p');
    if (!pElement) return; // p 요소가 없다면 함수 종료

    var text = pElement.innerText;
    var sentences = text.split('.');
    var newText = '';
    var count = 0;

    // 문장별로 처리
    sentences.forEach(function(sentence) {
        if (sentence.trim() !== '') {
            newText += sentence + '.';
            count++;
            // 매 두 번째 '.' 후에 줄바꿈 추가
            if (count % 2 === 0) {
                newText += '<br>';
            }
        }
    });

    // 결과를 p 요소에 적용
    pElement.innerHTML = newText;
}

// areaCode에 해당하는 지역명과 관광지 사진 대체 로직

const areaDetails = {
    1: { name: "서울", image: "/images/seoul.png" },
    31: { name: "경기", image: "/images/kyungki.jpg" },
    2: { name: "인천", image: "/images/incheon.jpg" },
    32: { name: "강원", image: "/images/kangwon.jpg" },
    33: { name: "충북", image: "/images/chungbuk.jpg" },
    34: { name: "충남", image: "/images/chungnam.jpg" },
    35: { name: "경북", image: "/images/kyungbuk.jpg" },
    36: { name: "경남", image: "/images/kyungnam.jpg" },
    37: { name: "전북", image: "/images/jeonbuk.jpg" },
    38: { name: "전남", image: "/images/jeonnam.jpg" },
    39: { name: "제주", image: "/images/jeju.jpg" }
};

function updateAreaInfo() {
    const area = areaDetails[areaCode]; // areaCode를 사용하여 지역 정보 찾기
    if (area) {
        document.getElementById('area-image').src = area.image;
        document.getElementById('area-name').textContent = area.name;
    } else {
        console.log('지역 코드가 유효하지 않습니다.');
    }
}

updateAreaInfo(); // 페이지 로드 시 함수 실행

function reserveCompanion(spotName, spotAddr, areaCode){

}


