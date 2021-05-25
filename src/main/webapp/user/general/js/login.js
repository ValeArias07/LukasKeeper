const email = document.getElementById('emailTF');
const password = document.getElementById('passwordTF');
const button = document.getElementById('buttonSignUp');


const verifyUser= ()=>{
    let xhr = new XMLHttpRequest();
    var session = new Session(email.value, password.value);
    xhr.open("PUT", "http://localhost:8081/LukasKeeper_war/api/user/login");

    xhr.addEventListener('readystatechange',()=>{

        if(xhr.readyState===4){
            let json = xhr.responseText;
            let response = JSON.parse(json);
            console.log(response);
            if(response===true){
                console.log(JSON.stringify(session))
                window.localStorage.setItem('session', JSON.stringify(session));
                window.location.href = 'dashboard.html'
            }else{
                alert("No existe una cuenta vinculada");
            }
        }
    });

    xhr.setRequestHeader('Content-Type', 'application/json');
    xhr.send(JSON.stringify(session));
}


button.addEventListener('click',verifyUser);




