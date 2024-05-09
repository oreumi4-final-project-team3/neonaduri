document.addEventListener("DOMContentLoaded", function () {

    const loadingElement = document.getElementById('loading');
    // EventSource를 사용하여 서버에서 발송하는 이벤트를 구독합니다.
    const eventSource = new EventSource(`/api/alan/${spotName}`);

    // 결과를 표시할 요소를 미리 가져옵니다.
    const resultsElement = document.getElementById('aiResults');

    eventSource.onmessage = function (event) {
        // 서버에서 받은 데이터를 파싱합니다.
        loadingElement.style.display = 'none';

        const data = JSON.parse(event.data);

        if (data.type === 'action') {
            // action 타입의 메시지를 h1 태그에 담아 처리
            const newElement = document.createElement('h2');
            newElement.textContent = data.data.speak;
            resultsElement.appendChild(newElement);
        } else if (data.type === 'continue' || data.type === 'complete') {
            // continue 또는 complete 타입의 메시지를 가장 최근 p 태그에 추가
            let lastPElement = resultsElement.querySelector('p:last-child');
            if (!lastPElement) {
                lastPElement = document.createElement('p');
                resultsElement.appendChild(lastPElement);
            }
            const content = data.type === 'complete' ? convertTextToLinks(data.data.content) : data.data.content;
            lastPElement.innerHTML += content;

            // 마침표가 포함되어 있으면 <br> 추가
            if (content.includes('.')) {
                lastPElement.innerHTML += '<br>';
            }
        }
    };


    eventSource.onerror = function (error) {
        console.error("EventSource failed:", error);
        eventSource.close();
    };
});


function convertTextToLinks(text) {
    const urlRegex = /\[\(출처(\d+)\)\]\((https?:\/\/[^\s]+)\)/g;
    return text.replace(urlRegex, (match, num, url) => `<a href="${url}">출처${num}</a><br>`);
}