const likeBtn = document.querySelector('.like');
const scrollBtn = document.querySelector('.scroll');

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

scrollBtn.addEventListener('click', () => {
  scrollTo({ top: 0, behavior: 'smooth' });
});
