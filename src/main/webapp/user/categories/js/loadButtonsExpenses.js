const addBtn = document.getElementById('addBtn');
const periodBtn = document.getElementById('periodBtn');
const compareBtn = document.getElementById('compareBtn');

goToAdd=()=>{
    window.location="../add/addExpenses.html";
}

goToMain = () => {
    window.location="../add/addExpenses.html";
}

addBtn.addEventListener('click', goToAdd);
periodBtn.addEventListener('click', goToMain);
compareBtn.addEventListener('click', goToMain);
