const button = document.getElementById('logOutButton');

button.addEventListener('click', logOut = () => {
    window.localStorage.removeItem('session');
    window.location.href = '../../index.html';
});