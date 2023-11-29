const btnSubmit = document.querySelector('.btn-submit');

let editor;

ClassicEditor.create(document.querySelector('#editor'), {
  language: 'ko',
  toolbar: ['heading', '|', 'bold', 'italic']
})
  .then(newEditor => {
    editor = newEditor;
  })
  .catch(error => {
    console.error(error);
  });

btnSubmit.addEventListener('click', () => {
  // 값 가져오기
  // editor.getData();
  // 값 세팅
  // editor.setData('<p>Hi</p>');
});
