const amount = document.getElementById('amount');
const description = document.getElementById('description');
const idCategory = document.getElementById('expenseType');
const button = document.getElementById('buttonContainer');

const getSelectors=()=>{
    let index1= document.getElementById("idCategory").selectedIndex;
    var idCategory=document.getElementById("idCategory").options[index1].text;
    addIncome(idCategory);
}

const addExpense=(idCategory)=>{

    let xhr = new XMLHttpRequest();
    const expense = new Income(amount.value, description.value, idCategory);
    xhr.open("POST", "http://localhost:8081/LukasKeeper_war/api/expenses/add");
    xhr.setRequestHeader('Content-Type', 'application/json');
    xhr.send(JSON.stringify(expense));
    alert("Ingreso añadido!");
}