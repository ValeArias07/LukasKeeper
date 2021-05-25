const value = document.getElementById('amount');
const description = document.getElementById('description');
const date = document.getElementById('date');
const frequency = document.getElementById('frequencyType');
const button = document.getElementById('button');

const getSelectors = () => {
    let index1 = document.getElementById("expenseType").selectedIndex;
    let idCategory = document.getElementById("expenseType").options[index1].text;

    let index2 = document.getElementById("frequencyType").selectedIndex;
    let frequencyType = document.getElementById("frequencyType").options[index2].text;

    addExpense(idCategory, frequencyType);
}

const addExpense = (idCategory, frequencyType) => {

    let xhr = new XMLHttpRequest();
    const expense = new Expense(value.value, description.value, date.value, frequencyType, idCategory);

    console.log( JSON.stringify(expense));
    //xhr.open("POST", "http://localhost:8081/LukasKeeper_war/api/expenses/add?email=bengi1234@gmail.com");
    //xhr.setRequestHeader('Content-Type', 'application/json');
    //xhr.send(JSON.stringify(expense));
    alert("Gasto añadido!");
}

button.addEventListener('click', getSelectors);