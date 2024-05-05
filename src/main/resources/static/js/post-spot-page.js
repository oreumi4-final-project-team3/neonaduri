// "여기갈까?" 버튼 클릭 시 새로고침
function goToHerePage() {
    window.location.href = "/api/spots";
}
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