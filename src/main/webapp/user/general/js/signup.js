const name = document.getElementById('name');
const lastname = document.getElementById('lastname');
const dateOfBirth = document.getElementById('dateOfBirth');
const email = document.getElementById('email');
const occupation = document.getElementById('ocupation');
const password = document.getElementById('password');
const repassword = document.getElementById('repassword');
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
    const user = new User(name.value, lastname.value, dateOfBirth.value, email.value, occupation.value, password.value, repassword.value);
    let xhr = new XMLHttpRequest();
    xhr.open("POST", "http://localhost:8081/LukasKeeper_war/api/category/signup");
    xhr.setRequestHeader('Content-Type', 'application/json');
    xhr.send(JSON.stringify(user));
}

button.addEventListener('click', verifyPassword);