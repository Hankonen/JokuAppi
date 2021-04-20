//js for details.html
const id = new URLSearchParams(window.location.search).get('id');
const container = document.querySelector('.details');
const form = document.querySelector('form');

const renderDetails = async () => {
    //this only fetch single item from localhost and then look property id
    const res = await fetch('http://localhost:3000/posts/' + id);

    const post = await res.json();
    //console.log(post);
    

    const template = `
    <h1>${post.title}</h1>
    <p>${post.body}</p>
    <input type="text" name="title" required placeholder='${post.title}' />
      <textarea name="body" >${post.body}</textarea>
      <button>Create</button>
    `

    form.innerHTML = template;

}

const createPost = async (e) => {
    e.preventDefault();
 
    const doc = {
        title: form.title.value,
        body: form.body.value
        
    }
    
    await fetch('http://localhost:3000/posts/' + id, {
        method: 'PUT',
        body: JSON.stringify(doc),
        headers: { 'Content-Type' : 'application/json' }
    });
    
    console.log(doc);
    window.location.replace('index.html');
}

window.addEventListener('submit', createPost);
window.addEventListener('DOMContentLoaded', () => renderDetails());