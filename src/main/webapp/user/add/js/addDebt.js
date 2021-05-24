const value = document.getElementById('amount');
const description = document.getElementById('description');
const fee = document.getElementById('numFee');
const interest = document.getElementById('interestPer');
const button = document.getElementById('buttonContainer');

const addDebt=()=>{

    let xhr = new XMLHttpRequest();
    const debts = new Debt(value.value, description.value, fee.value, interest.value);
    xhr.open("POST", "http://localhost:8081/LukasKeeper_war/api/debts/add");
    xhr.setRequestHeader('Content-Type', 'application/json');
    xhr.send(JSON.stringify(debts));
    alert("Deuda añadida!");
}