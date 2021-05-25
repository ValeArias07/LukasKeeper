const value = document.getElementById('amount');
const description = document.getElementById('description');
const date = document.getElementById('date');
const frequency = document.getElementById('frequencyType');
const idCategory = document.getElementById('incomeType');
const button = document.getElementById('button');

const getSelectors=()=>{
    var idCategory= document.getElementById("incomeType").selectedIndex;
    var idFrequency= document.getElementById("frequencyType").selectedIndex;
    addIncome(idCategory,idFrequency) ;
}

const addIncome=(idCategory, idFrequency)=>{

    let xhr = new XMLHttpRequest();
    const income = new Income(value.value, description.value, date.value, idFrequency, idCategory);
    console.log(JSON.stringify(income));
   // xhr.open("POST", "http://localhost:8081/LukasKeeper_war/api/incomes/add");
   // xhr.setRequestHeader('Content-Type', 'application/json');
   // xhr.send(JSON.stringify(income));
    alert("Ingreso añadido!");
}

button.addEventListener('click', getSelectors);