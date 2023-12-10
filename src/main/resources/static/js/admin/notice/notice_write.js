const form = document.querySelector('#form');
const txtContent = document.querySelector('.content_txt');
const btnSubmit = document.querySelector('#btn-submit');

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

document.getElementById('fileUpload').addEventListener('change', function() {
    var fileName = this.files[0].name;
    document.getElementById('fileName').innerHTML = fileName;
});
btnSubmit.addEventListener('click', () => {
    txtContent.value = editor.getData();
    form.submit();
})