const session = JSON.parse(window.localStorage.getItem('session'));

setName =()=>{

        let xhr = new XMLHttpRequest();
        xhr.addEventListener('readystatechange',()=>{
            if(xhr.readyState===4){
                let json = xhr.responseText;
                var user= JSON.parse(json);
                window.localStorage.setItem('name', user.name);
            }
        });

        xhr.open("GET", "http://localhost:8081/LukasKeeper_war/api/user/getUserInfo?email="+session.email);
        xhr.setRequestHeader('Content-Type', 'application/json');
        xhr.send();

        console.log(localStorage.getItem('name'));
    document.getElementById('nameModel').innerText=localStorage.getItem('name');
}
setName();