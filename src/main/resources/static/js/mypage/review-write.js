const starBtns = document.querySelectorAll('.star');
const txt = document.querySelector('.input-txt');
const charNum = document.querySelector('.char-num > p > span');
const btnClose = document.querySelector('.btn-close');

let starCount = 0; // 0은 입력 안된 상태, 1~5까지 값이 입력된 상태임

function handleStarIcon(idx) {
  starBtns.forEach(star => {
    star.firstElementChild.innerHTML = `<i class="fa-regular fa-star"></i>`;
  });
  for (let i = 0; i <= idx; i++) {
    const icon = starBtns[i].firstElementChild;
    icon.innerHTML = `<i class="fa-solid fa-star"></i>`;
  }
}

// esc 키 눌렀을 때 창 닫히도록 설정
window.addEventListener('keyup', e => {
  const key = e.key;
  if (key == 'Escape') {
    window.close();
  }
});

starBtns.forEach((starBtn, idx) => {
  starBtn.addEventListener('click', () => {
    handleStarIcon(idx);
    starCount = idx + 1;
  });
});

txt.addEventListener('input', () => {
  charNum.innerHTML = txt.value.length;
});

btnClose.addEventListener('click', () => {
  window.close();
});
