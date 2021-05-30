const bLogOut = document.getElementById('logOutButton');
bLogOut.addEventListener('click',   logut=() => {
    window.localStorage.removeItem('session');
    window.localStorage.removeItem('name');
    window.location.href = '../../index.html';
});
