const value = document.getElementById('amount');
const description = document.getElementById('description');
const date = document.getElementById('date');
const fee = document.getElementById('numFee');
const interest = document.getElementById('interestPer');
const button = document.getElementById('button');

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

loadContainerPeriod = () => {
    window.location="../categories/debts.html";
}

loadContainerTimeLine = () => {
    window.location="../categories/debts.html";
}

loadContainerCompare = () => {
    window.location="../categories/debts.html";
}

loadContainerIndicador = () => {
    window.location="../categories/debts.html";
}

authSession=()=> {
    if (localStorage.getItem('session') === null) {
        window.location="../general/login.html";
    }
}

authSession();
periodBtn.addEventListener('click', loadContainerPeriod);
timelineBtn.addEventListener('click', loadContainerTimeLine);
compareBtn.addEventListener('click', loadContainerCompare);
indicatorsBtn.addEventListener('click', loadContainerIndicador);
