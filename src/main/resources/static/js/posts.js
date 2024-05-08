const deleteReviewButton = document.getElementById('delete-post-btn');
const modifyReviewButton = document.getElementById('modify-btn');
const createReviewButton = document.getElementById('create-btn');

if(deleteReviewButton){
    deleteReviewButton.addEventListener('click', event => {
        let id = document.getElementById('review-id').value;
        fetch('/api/posts/'+id,{
            method: 'DELETE'
        }).then(()=>{
            alert('삭제가 완료되었습니다.');
            location.replace('/reviews');
        });
    });
}

if (modifyReviewButton) {
    modifyReviewButton.addEventListener('click', event => {
        let params = new URLSearchParams(location.search);
        let id = params.get('id');

        fetch(`/api/posts/`+id, {
            method: 'PUT',
            headers: {
                "Content-Type": "application/json",
            },
            body: JSON.stringify({
                title: document.getElementById('title').value,
                content: document.getElementById('content').value
            })
        }).then(() => {
            alert('수정이 완료되었습니다');
            location.replace('/reviews/'+id);
        });
    });
}

if (createReviewButton) {
    createReviewButton.addEventListener('click', event => {
        fetch(`/api/posts`, {
            method: 'POST',
            headers: {
                "Content-Type": "application/json"
            },
            body : JSON.stringify({
                title: document.getElementById('title').value,
                content: document.getElementById('content').value
            }),
        }).then(() => {
            alert('등록 완료되었습니다');
            location.replace("/reviews");
        })
    })
}