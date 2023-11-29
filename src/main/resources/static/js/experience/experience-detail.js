const likeBtn = document.querySelector('.like');
const btnReservation = document.querySelector('.btn-re');
const scrollBtn = document.querySelector('.scroll');
const modifyBtns = document.querySelectorAll('.btn-modify');

// db에 넘기기 전에는 like 여부 알 수 없으니 테스트용으로 변수 생성
let isLike = false;

addEventListener('scroll', () => {
  const y = scrollY;
  if (y > 150) {
    scrollBtn.classList.add('show');
  } else {
    scrollBtn.classList.remove('show');
  }
});

likeBtn.addEventListener('click', () => {
  const heartNone = document.querySelector('.heart-none');
  const heartFull = document.querySelector('.heart-full');
  if (isLike) {
    heartNone.style.display = 'block';
    heartFull.style.display = 'none';
  } else {
    heartNone.style.display = 'none';
    heartFull.style.display = 'block';
  }
  isLike = !isLike;
});

btnReservation.addEventListener('click', () => {
  location.href = '/reservation';
});

scrollBtn.addEventListener('click', () => {
  scrollTo({ top: 0, behavior: 'smooth' });
});

modifyBtns.forEach(modify => {
  modify.addEventListener('click', () => {
    const width = window.screen.width;
    const height = window.screen.height;

    const popWidth = 650;
    const popHeight = 500;
    open(
      '/mypage/review/write',
      'review',
      `resizable=no width=${popWidth}, height=${popHeight} top=${
        height / 2 - popHeight / 2
      } left=${width / 2 - popWidth / 2}`
    );
  });
});
