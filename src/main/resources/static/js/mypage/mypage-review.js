const btnModifys = document.querySelectorAll('.btn-modify');

btnModifys.forEach(btnModify => {
  btnModify.addEventListener('click', () => {
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
