//js for create.html
const form = document.querySelector('form');
const id = new URLSearchParams(window.location.search).get('id');

const createPost = async (e) => {
    e.preventDefault();

    const doc = {
        title: form.title.value,
        body: form.body.value
    }

    await fetch('http://localhost:3000/posts/' + 1, {
        method: 'PUT',
        body: JSON.stringify(doc),
        headers: { 'Content-Type' : 'application/json' }
    });
    console.log(form);
    form.innerHTML = doc;
    
    //window.location.replace('index.html');
}

form.addEventListener('submit', createPost);