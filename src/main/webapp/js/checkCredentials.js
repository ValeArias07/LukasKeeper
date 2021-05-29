class CheckCredentials{

    authSession=(url)=> {
         if (localStorage.getItem('session') === null) {
            window.location=url;
        }
    }
}


