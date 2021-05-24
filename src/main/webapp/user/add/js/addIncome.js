const value = document.getElementById('amount');
const description = document.getElementById('description');
const frequency = document.getElementById('frequency');
const idCategory = document.getElementById('incomeType');
const button = document.getElementById('buttonContainer');

const getSelectors=()=>{
    let index1= document.getElementById("idCategory").selectedIndex;
    var idCategory=document.getElementById("idCategory").options[index1].text;
    addIncome(idCategory);
}

const addIncome=(idCategory)=>{

    let xhr = new XMLHttpRequest();
    const income = new Income(value.value, description.value, frequency.value, idCategory);
    xhr.open("POST", "http://localhost:8081/LukasKeeper_war/api/incomes/add");
    xhr.setRequestHeader('Content-Type', 'application/json');
    xhr.send(JSON.stringify(income));
    alert("Ingreso añadido!");
}