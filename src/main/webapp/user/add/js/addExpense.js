const value = document.getElementById('amount');
const description = document.getElementById('description');
const date = document.getElementById('date');
const frequency = document.getElementById('frequencyType');
const button = document.getElementById('button');

const getSelectors = () => {
    let index1 = document.getElementById("expenseType").selectedIndex;
    let idCategory = document.getElementById("expenseType").options[index1].value;

    let index2 = frequency.selectedIndex;
    let frequencyType = frequency.options[index2].text;

    addExpense(idCategory, frequencyType);
}

const addExpense = (idCategory, frequencyType) => {

    let xhr = new XMLHttpRequest();
    const expense = new Expense(value.value, description.value, date.value, frequencyType, idCategory);
    let session = JSON.parse(window.localStorage.getItem('session'));

    xhr.open("POST", "http://localhost:8081/LukasKeeper_war/api/expenses/add?email="+session.email);
    xhr.setRequestHeader('Content-Type', 'application/json');
    xhr.send(JSON.stringify(expense));
    alert("Gasto añadido!");
}

button.addEventListener('click', getSelectors);

authSession=()=> {
    if (localStorage.getItem('session') === null) {
        window.location="../general/login.html";
    }
}
authSession();


