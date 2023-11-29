const replyCon = document.querySelectorAll('.qna-detail-reply');
const qnaTitles = document.querySelectorAll('.list-align > .qna-title');
const btnWrite = document.querySelector('.btn-write');
const btnModifys = document.querySelectorAll('.btn-modify');

let conCount = -1;

// 지금은 이렇지만 나중에 로그인 되어있을 때, 로그인 안되어 있을 때 구분 해야하고
// 로그인 되어 있을 때도 현재 로그인 되어 있는 아이디 값 잘 념겨줘야 함
btnWrite.addEventListener('click', () => {
  location.href = `/qna/write`;
});

qnaTitles.forEach((title, idx) => {
  title.addEventListener('click', () => {
    if (title.firstElementChild.classList.contains('secret')) {
      alert('비공개 문의내역은 작성자 본인만 확인할  수 있습니다.');
      return;
    }
    replyCon[idx].classList.toggle('show');
    if (conCount != -1 && !(idx == conCount)) {
      replyCon[conCount].classList.remove('show');
    }
    conCount = idx;
  });
});

btnModifys.forEach(btnModify => {
  btnModify.addEventListener('click', () => {
    location.href = '/qna/write';
  });
});
