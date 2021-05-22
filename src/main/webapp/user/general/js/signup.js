const name = document.getElementById('name');
const lastName = document.getElementById('lastname');
const email = document.getElementById('email');
const password = document.getElementById('password');
const repassword = document.getElementById('repassword');
const dateOfBirth = document.getElementById('dateOfBirth');
const bank = document.getElementById('bank');
const occupation = document.getElementById('ocupation');
const button = document.getElementById('buttonRegist');

const verifyPassword =()=>{
    if(password.value === repassword.value){
        signUp();
    }else {
    alert("Las contrasenas no coinciden");
    document.getElementById('repassword').value="";
    }
}

const signUp=()=>{
    const user = new User(name.value, lastName.value, dateOfBirth.value, email.value, password.value, bank.value, occupation.value, );
    let xhr = new XMLHttpRequest();
    xhr.open("POST", "http://localhost:8081/LukasKeeper_war/api/category/signup");
    xhr.setRequestHeader('Content-Type', 'application/json');
    xhr.send(JSON.stringify(user));
}

button.addEventListener('click', verifyPassword);