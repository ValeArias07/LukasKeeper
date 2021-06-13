const value = document.getElementById('amount');
const description = document.getElementById('description');
const date = document.getElementById('date');
const fee = document.getElementById('numFee');
const interest = document.getElementById('interestPer');
const button = document.getElementById('button');
const periodBtn = document.getElementById('periodBtn');
const compareBtn = document.getElementById('compareBtn');

const addDebt=()=>{

    let xhr = new XMLHttpRequest();
    const debts = new Debt(value.value, description.value, date.value, fee.value, interest.value);
    console.log(JSON.stringify(debts));
    let session = JSON.parse(window.localStorage.getItem('session'));
    xhr.open("POST", "http://localhost:8081/LukasKeeper_war/api/debts/add?email="+session.email);
    xhr.setRequestHeader('Content-Type', 'application/json');
    xhr.send(JSON.stringify(debts));
    alert("Deuda añadida!");

}

button.addEventListener('click', addDebt);

goToMain = () => {
    window.location="../categories/debts.html";
}

authSession=()=> {
    if (localStorage.getItem('session') === null) {
        window.location="../general/login.html";
    }
}

authSession();
periodBtn.addEventListener('click', goToMain);
compareBtn.addEventListener('click', goToMain);
