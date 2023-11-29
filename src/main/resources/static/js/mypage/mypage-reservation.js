const btnReviews = document.querySelectorAll('.btn-review');
const btnReserDetails = document.querySelectorAll('.btn-r-detail');

btnReviews.forEach(btnReview => {
  btnReview.addEventListener('click', () => {
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

btnReserDetails.forEach(btnDetail => {
  btnDetail.addEventListener('click', () => {
    const width = window.screen.width;
    const height = window.screen.height;

    const popWidth = 900;
    const popHeight = 650;
    open(
      '/mypage/reservation/detail',
      'review',
      `resizable=no width=${popWidth}, height=${popHeight} top=${
        height / 2 - popHeight / 2
      } left=${width / 2 - popWidth / 2}`
    );
  });
});
