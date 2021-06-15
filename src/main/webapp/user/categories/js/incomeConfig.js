const addBtn = document.getElementById('addBtn');

const extraInformationContainer = document.getElementById('extraInformation');
const salarioInformationContainer = document.getElementById('salarioInformation');

const getAllIncomes = () =>{
    let session = JSON.parse(window.localStorage.getItem('session'));
    let xhr = new XMLHttpRequest();
    xhr.addEventListener('readystatechange', ()=>{
        if(xhr.readyState === 4){
            let json = xhr.responseText;
            let response = JSON.parse(json);
            console.log(response);
            extraInformationContainer.innerHTML = '';
            salarioInformationContainer.innerHTML = '';
            for(let i = 0; i<response.length;i++){
                let income = response[i];
                let view = new loadIncomeElements(income);

                view.onDeleteFinish = () =>{
                    console.log(income.idDefaultCategory);
                    if(income.idUserCategory === 90000013){
                        salarioInformationContainer.removeChild(document.getElementById('income' + income.id));
                    } else{
                        extraInformationContainer.removeChild(document.getElementById('income' + income.id));
                    }

                };
                if(income.idUserCategory === 90000013){
                    salarioInformationContainer.appendChild(view.render());
                } else{
                    extraInformationContainer.appendChild(view.render());
                }
            }
        }
    });
    xhr.open('GET', 'http://localhost:8081/LukasKeeper_war/api/incomes/list?email=' + session.email);
    xhr.send();
};

getAllIncomes();

loadContainerAdd=()=>{
    window.location="../add/addIncomes.html";
    console.log("add");
}

authSession=()=> {
    if (localStorage.getItem('session') === null) {
        window.location="../general/login.html";
    }
}

authSession();
addBtn.addEventListener('click', loadContainerAdd);
