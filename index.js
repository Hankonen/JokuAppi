// js for index.html
const container = document.querySelector('.cards');
const renderPosts = async () => {
    let uri = 'http://localhost:3000/posts';

    const res = await fetch(uri);
    const posts = await res.json();
    console.log(posts);
    var kuva = 0;
    let template = '';
    
    posts.forEach(post => {
        
        kuva += 1;
        template += `
        <div class="post">
        <div class="pokekort">
        <div class="pokekuva">
        <img src="kuva${kuva}.jpg" alt="ei kuvaa">
        </div>
        <div class="pokeotsikko">
        <h2>${post.title}</h2>
        </div>
        <div class="pokebod">
        <p>${post.body}</p>
        <button type="details.html?id=${post.id}">Muokkaus</button>
        </div>
         </div>
        </div>
        `
    })
    
    container.innerHTML = template;
}

window.addEventListener('DOMContentLoaded', () => renderPosts());

const id = new URLSearchParams(window.location.search).get('id');
const containerr = document.querySelector('.details');
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