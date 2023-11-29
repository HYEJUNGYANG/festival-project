const inputDate = document.querySelector('.input-date');
const btnSelDate = document.querySelector('.btn-sel-date');
const btnMinus = document.querySelector('.btn-minus');
const btnPlus = document.querySelector('.btn-plus');
const inputPeople = document.querySelector('.input-people');
const totalValue = document.querySelector('.total-value > span');
const payMethods = document.getElementsByName('method');
const btnRe = document.querySelector('.btn-re');

console.log(!!inputDate.value.length);
console.log(payMethods);

const PAY = 6000;
let isMethod = false;

inputDate.addEventListener('change', () => {
  btnSelDate.innerHTML = inputDate.value;
  btnSelDate.classList.add('sel-date');
});

btnMinus.addEventListener('click', () => {
  if (inputPeople.value == 1) {
    return;
  }
  btnPlus.classList.remove('none');
  inputPeople.value = Number(inputPeople.value) - 1;
  totalValue.innerHTML = (PAY * Number(inputPeople.value)).toLocaleString();
  if (inputPeople.value == 1) {
    btnMinus.classList.add('none');
  }
});

btnPlus.addEventListener('click', () => {
  if (inputPeople.max == inputPeople.value) {
    return;
  }
  btnMinus.classList.remove('none');
  inputPeople.value = Number(inputPeople.value) + 1;
  totalValue.innerHTML = (PAY * Number(inputPeople.value)).toLocaleString();
  if (inputPeople.max == inputPeople.value) {
    btnPlus.classList.add('none');
  }
});

btnRe.addEventListener('click', () => {
  // 결제 수단 체크여부
  payMethods.forEach(method => {
    if (method.checked) isMethod = true;
  });
  if (isMethod && inputDate.value.length > 0) {
    location.href = '/reservation/result';
  } else {
    alert('모든 항목을 선택해주세요');
  }
});
