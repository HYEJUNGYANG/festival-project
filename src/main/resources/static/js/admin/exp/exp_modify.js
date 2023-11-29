const form = document.querySelector('#form');
const txtDetail = document.querySelector('#txt_detail');
const txtContent = document.querySelector('#txt_content');
const txtWarning = document.querySelector('#txt_warning');
const btnSubmit = document.querySelector('#btn-submit');

let editorD;
let editorC;
let editorW;

ClassicEditor.create(document.querySelector('#editor_detail'), {
    language: 'ko',
    toolbar: ['heading', '|', 'bold', 'italic']
})
    .then(newEditor => {
        editorD = newEditor;
    })
    .catch(error => {
        console.error(error);
    });
ClassicEditor.create(document.querySelector('#editor_content'), {
    language: 'ko',
    toolbar: ['heading', '|', 'bold', 'italic']
})
    .then(newEditor => {
        editorC = newEditor;
    })
    .catch(error => {
        console.error(error);
    });
ClassicEditor.create(document.querySelector('#editor_warning'), {
    language: 'ko',
    toolbar: ['heading', '|', 'bold', 'italic']
})
    .then(newEditor => {
        editorW = newEditor;
    })
    .catch(error => {
        console.error(error);
    });

btnSubmit.addEventListener('click', () => {
    txtDetail.value = editorD.getData();
    txtContent.value = editorC.getData();
    txtWarning.value = editorW.getData();
    form.submit();
})