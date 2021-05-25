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
   // xhr.open("POST", "http://localhost:8081/LukasKeeper_war/api/debts/add");
   // xhr.setRequestHeader('Content-Type', 'application/json');
    //xhr.send(JSON.stringify(debts));
    alert("Deuda añadida!");

}

button.addEventListener('click', addDebt);