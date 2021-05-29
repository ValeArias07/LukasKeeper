const button = document.getElementById('logOutButton');
button.addEventListener('click',   logut=() => {
    window.localStorage.removeItem('session');
    window.localStorage.removeItem('name');
    window.location.href = '../../index.html';
});

