authSession=()=> {
    console.log(localStorage.getItem('session'));
    if (localStorage.getItem('session') === undefined) {
        window.location="login.html";
    } else if (localStorage.getItem('session') === null) {
        window.location="login.html";
    }
}
authSession();