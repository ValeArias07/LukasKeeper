const button = document.getElementById('logOutButton');

button.addEventListener('click', logOut = () => {
    window.localStorage.removeItem('session');
    window.localStorage.removeItem('name');
    window.location.href = '../../index.html';
});