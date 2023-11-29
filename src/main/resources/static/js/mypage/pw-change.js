const pwShows = document.querySelectorAll('.pw-show');
const btnChange = document.querySelector('.btn-change');
const btnClose = document.querySelector('.btn-close');

addEventListener('keydown', e => {
  const key = e.key;
  if (key == 'Escape') {
    window.close();
  }
});

pwShows.forEach(pwShow => {
  pwShow.addEventListener('click', () => {
    const input = pwShow.previousElementSibling;
    const icon = pwShow.firstElementChild;
    const condition = input.type == 'password';
    icon.classList.replace(
      `${condition ? 'fa-eye' : 'fa-eye-slash'}`,
      `${condition ? 'fa-eye-slash' : 'fa-eye'}`
    );
    input.focus();
    input.type = condition ? 'text' : 'password';
  });
});

btnClose.addEventListener('click', () => {
  window.close();
});
