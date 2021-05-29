var name = document.getElementById('name');
var lastName = document.getElementById('lastname');
var dateOfBirth = document.getElementById('borndate');

var telephone = document.getElementById('telephone');
var direction = document.getElementById('direction');
var city = document.getElementById('city');

var password = document.getElementById('password');
var repassword = document.getElementById('repassword');

var button = document.getElementById('saveButton');
var session = JSON.parse(window.localStorage.getItem('session'));
const checkCredentials = new CheckCredentials();


const updateInfo=(bank, occupation)=>{
    let xhr = new XMLHttpRequest();
    const user = new User(name.value, lastName.value, dateOfBirth.value, session.email, password.value, bank, occupation);
    xhr.open("PUT", "http://localhost:8081/LukasKeeper_war/api/user/edit");
    xhr.setRequestHeader('Content-Type', 'application/json');
    xhr.send(JSON.stringify(user));
}

const getSelectors=()=>{
    let index1= document.getElementById("bank").selectedIndex;
    var bank=document.getElementById("bank").options[index1].text;

    let index2= document.getElementById("occupation").selectedIndex;
    var occupation=document.getElementById("occupation").options[index2].text;

    updateInfo(bank, occupation);
}

const fillText=(user, indexB, indexO)=>{
    document.getElementById('name').value = user.name;
    document.getElementById('lastname').value  = user.lastName;

    document.getElementById('telephone');
    document.getElementById('direction');
    document.getElementById('city');

    document.getElementById('bank').selectedIndex = indexB;
    document.getElementById('occupation').selectedIndex = indexO;
    console.log("occupation "+indexO);
    console.log("bank "+indexB);
}

const selectors =(user)=>{
    switch (user.occupation){
        case "Estudiante": var indexO=0; break;
        case "Profesor": var indexO=1; break;
        case "Empleado": var indexO=2; break;
        case "Independiente": var indexO=3; break;
    }
    switch (user.bank){
        case "Bancolombia": var indexB=0;break;
        case "Davivienda": var indexB=1; break;
        case "Colpatria": var indexB=2; break;
        case "Falabella": var indexB=3; break;
    }

    fillText(user, indexB, indexO);
}

const initFields=()=>{
    let xhr = new XMLHttpRequest();
    xhr.addEventListener('readystatechange',()=>{

        if(xhr.readyState===4){
            let json = xhr.responseText;
            let response = JSON.parse(json);
            document.getElementById('nameModel').innerHTML=""+response.name;
            selectors(response);

        }
    });
    xhr.open("GET", "http://localhost:8081/LukasKeeper_war/api/user/getUserInfo?email="+session.email);
    xhr.send();
}

const verifyPassword =()=>{
    if(password.value === repassword.value){
        getSelectors();
    }else {
        alert("Las contraseñas no coinciden");
        document.getElementById('repassword').value="";
    }
}

initFields();
checkCredentials.authSession("login.html");
checkCredentials.logOut();
button.addEventListener('click', verifyPassword);