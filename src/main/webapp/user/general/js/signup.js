const name = document.getElementById('name');
const lastName = document.getElementById('lastname');
const email = document.getElementById('email');
const password = document.getElementById('password');
const repassword = document.getElementById('repassword');
const dateOfBirth = document.getElementById('dateOfBirth');
const bank = document.getElementById('bank');
const occupation = document.getElementById('ocupation');
const button = document.getElementById('buttonSignUp');

const getSelectors=()=>{
    let index1= document.getElementById("occupation").selectedIndex;
    let index2= document.getElementById("bank").selectedIndex;
    var occupation=document.getElementById("occupation").options[index1].text;
    var bank=document.getElementById("bank").options[index2].text;
    signUp(bank, occupation);

}
const verifyPassword =()=>{
    if(password.value === repassword.value){
        getSelectors();
    }else {
    alert("Las contraseñas no coinciden");
    document.getElementById('repassword').value="";
    }
}

const signUp=(bank, occupation)=>{

    let xhr = new XMLHttpRequest();
    const user = new User(name.value, lastName.value, dateOfBirth.value, email.value, password.value, bank, occupation);
    xhr.open("POST", "http://localhost:8081/LukasKeeper_war/api/user/signup");
    xhr.setRequestHeader('Content-Type', 'application/json');
    xhr.send(JSON.stringify(user));
    alert("Registro exitoso!");
    const clean=()=>{
        document.getElementById('name').value="";
        document.getElementById('lastname').value="";
        document.getElementById('email').value="";
        document.getElementById('password').value="";
        document.getElementById('repassword').value="";
        document.getElementById('dateOfBirth').value="";
    };
    clean();
}

button.addEventListener('click', verifyEmail=()=>{
    let xhr = new XMLHttpRequest();
    let session = JSON.parse(window.localStorage.getItem('session'));
    xhr.addEventListener('readystatechange',()=>{

        if(xhr.readyState===4){
            let json = xhr.responseText;
            let response = JSON.parse(json);
            if(response===true){
                verifyPassword();
            }else{
                alert("Este correo ya existe tiene una cuenta asociada");
            }
        }
    });
    xhr.open("GET", "http://localhost:8081/LukasKeeper_war/api/user/checkEmail?email="+email.value);
    xhr.send();
});
