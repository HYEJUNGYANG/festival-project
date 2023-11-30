const domainSel = document.querySelector('.select-email-domain');
const inputDomain = document.querySelector('.other-domains');
const btnDupli = document.querySelector('.btn-dupli');
const idWarning = document.querySelector('.id-warning');
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

// 전화번호 하이픈 표시
inputTel.addEventListener('input', () => {
  inputTel.value = inputTel.value
    .replace(/[^0-9]/g, '')
    .replace(/^(\d{2,3})(\d{3,4})(\d{4})$/, `$1-$2-$3`);
});

const xhr = new XMLHttpRequest();

btnDupli.addEventListener('click', () => {
  const id = `${document.querySelector('.input-id').value}@${domainSel.options[domainSel.selectedIndex].value}`;
  xhr.open('POST', '/join/check_id', true);
  xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
  xhr.send(`id=${id}`);
  xhr.onreadystatechange = function () {
    if (xhr.readyState == XMLHttpRequest.DONE && xhr.status == 200) {
      if (xhr.response) {
        alert('중복된 아이디가 존재합니다!!');
        idWarning.innerHTML = '중복된 아이디가 존재합니다!!';
      }
      else {
        alert('사용 가능한 아이디 입니다!!👋🏻');
        idWarning.innerHTML = '';
      }
    }
    else if (xhr.status == 500){
      alert('실패하였습니다!');
    }
  };
});