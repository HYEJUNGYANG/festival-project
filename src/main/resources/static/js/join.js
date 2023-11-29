const domainSel = document.querySelector('.select-email-domain');
const inputDomain = document.querySelector('.other-domains');
const pwShowBtn = document.querySelector('.pw-show');
const pwCheckShowBtn = document.querySelector('.pw-check-show');
const inputTel = document.querySelector('.input-tel');
const btnJoin = document.querySelector('.btn-join');
const btnClose = document.querySelector('.btn-close');

function handlePwShow(element) {
  const input = element.previousElementSibling;
  input.focus();
  if (input.type == 'password') {
    input.type = 'text';
    element.firstElementChild.classList.replace('fa-eye', 'fa-eye-slash');
  } else {
    input.type = 'password';
    element.firstElementChild.classList.replace('fa-eye-slash', 'fa-eye');
  }
}

domainSel.addEventListener('change', () => {
  if (domainSel.options[domainSel.selectedIndex].value == 'otherDomains') {
    domainSel.classList.add('other');
    inputDomain.classList.add('show');
  }
});

pwShowBtn.addEventListener('click', () => {
  handlePwShow(pwShowBtn);
});

pwCheckShowBtn.addEventListener('click', () => {
  handlePwShow(pwCheckShowBtn);
});

btnClose.addEventListener('click', () => {
  if (
    confirm('작성중인 내용을 모두 잃게됩니다. 이전 페이지로 이동하시겠습니까?')
  ) {
    location.replace(document.referrer);
  }
});

inputTel.addEventListener('input', () => {
  inputTel.value = inputTel.value
    .replace(/[^0-9]/g, '')
    .replace(/^(\d{2,3})(\d{3,4})(\d{4})$/, `$1-$2-$3`);
});
