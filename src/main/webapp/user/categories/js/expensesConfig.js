const entretenimientoInformation = document.getElementById('entretenimientoInformation');
const saludInformation = document.getElementById('saludInformation');

const getAllExpenses = () =>{
    let session = JSON.parse(window.localStorage.getItem('session'));
    let xhr = new XMLHttpRequest();
    xhr.addEventListener('readystatechange', ()=>{
        if(xhr.readyState === 4){
            let json = xhr.responseText;
            let response = JSON.parse(json);
            console.log(response);
            entretenimientoInformation.innerHTML = '';
            saludInformation.innerHTML = '';

            for(let i = 0; i<response.length;i++){
                let expenses = response[i];
                let view = new loadExpensesElements(expenses);
                view.onDeleteFinish = () =>{
                    if(expenses.idDefaultCategory === 90000008) {
                        saludInformation.removeChild(document.getElementById('expenses' + expenses.id));
                    } else{
                        entretenimientoInformation.removeChild(document.getElementById('expenses' + expenses.id));
                    }
                };

                saludInformation.appendChild(view.render());

            }
        }
    });
    xhr.open('GET', 'http://localhost:8081/LukasKeeper_war/api/expenses/list?email=' + session.email);
    xhr.send();
};

getAllExpenses();
