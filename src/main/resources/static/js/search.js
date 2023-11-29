const inputDate = document.querySelector('.input-date');
const dateLabel = document.querySelector('.date-label');
const inputPlace = document.querySelector('.input-place');
const selectAreaCon = document.querySelector('.place-select-con');
const btnAreaClose = document.querySelector('.btn-close-con');
const btnAreaSelectAll = document.querySelector('.btn-all');
const areaLists = document.querySelectorAll('.area-list > li');
const btnAreaCheck = document.querySelector('.btn-check');

function handleAreaConClose() {
  selectAreaCon.classList.remove('show');
}

inputDate.addEventListener('change', () => {
  dateLabel.innerHTML = inputDate.value;
});

inputPlace.addEventListener('click', () => {
  selectAreaCon.classList.toggle('show');
});

btnAreaClose.addEventListener('click', () => {
  handleAreaConClose();
});

btnAreaSelectAll.addEventListener('click', () => {
  if (btnAreaSelectAll.classList.contains('all')) {
    areaLists.forEach(list => {
      list.classList.remove('area-click');
    });
  } else {
    areaLists.forEach(list => {
      list.classList.add('area-click');
    });
  }
  btnAreaSelectAll.classList.toggle('all');
});

areaLists.forEach(list => {
  list.addEventListener('click', () => {
    list.classList.toggle('area-click');
  });
});

btnAreaCheck.addEventListener('click', () => {
  const areaCheckLists = document.querySelectorAll('.area-click');
  console.log(areaCheckLists);
  let check = '';
  areaCheckLists.forEach((checkList, idx) => {
    if (idx == areaCheckLists.length - 1) {
      check += `${checkList.innerHTML}`;
      return;
    }
    check += `${checkList.innerHTML},`;
  });
  console.log(check);
  inputPlace.value = check;
  handleAreaConClose();
});
