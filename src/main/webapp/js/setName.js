setName =()=>{
if(localStorage.getItem('userName')===null){
        let session = JSON.parse(localStorage.getItem('session'));
        let xhr = new XMLHttpRequest();
        xhr.addEventListener('readystatechange',()=>{
            if(xhr.readyState===4){
                let json = xhr.responseText;
                localStorage.setItem('userName', JSON.parse(json).name);
            }
        });

        xhr.open("GET", "http://localhost:8081/LukasKeeper_war/api/user/getUserInfo?email="+session.email);
        xhr.setRequestHeader('Content-Type', 'application/json');
        xhr.send();
    }
    document.getElementById('nameModel').innerText=localStorage.getItem('userName');
}
setName();