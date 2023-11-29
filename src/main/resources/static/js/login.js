const pwInput = document.querySelector('.input-pw');
const pwToggleBtn = document.querySelector('.pw-show');

let isClick = false;

pwToggleBtn.addEventListener('click', () => {
  pwInput.focus();
  pwInput.type = isClick ? 'password' : 'text';
  if (isClick) {
    pwToggleBtn.firstElementChild.classList.replace('fa-eye-slash', 'fa-eye');
  } else {
    pwToggleBtn.firstElementChild.classList.replace('fa-eye', 'fa-eye-slash');
  }
  isClick = !isClick;
});
