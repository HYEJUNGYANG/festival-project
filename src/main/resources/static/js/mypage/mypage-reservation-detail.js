const btnCancel = document.querySelector('.btn-cancel');
const btnClose = document.querySelector('.btn-close');

addEventListener('keydown', e => {
  const key = e.key;
  if (key == 'Escape') {
    window.close();
  }
});

btnClose.addEventListener('click', () => {
  window.close();
});
