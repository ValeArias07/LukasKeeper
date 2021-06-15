const debtsInformation = document.getElementById('debtsInformation');

const getAllDebts = () =>{
    let session = JSON.parse(window.localStorage.getItem('session'));
    let xhr = new XMLHttpRequest();
    xhr.addEventListener('readystatechange', ()=>{
        if(xhr.readyState === 4){
            let json = xhr.responseText;
            let response = JSON.parse(json);
            console.log(response);
            let component = document.createElement('label'); //<div></div>
            component.className = 'elementsTitle';
            component.innerHTML = "Deudas";
            debtsInformation.innerHTML = '';
            debtsInformation.appendChild(component);

            for(let i = 0; i<response.length;i++){
                let debts = response[i];
                let view = new loadDebtsElements(debts);
                view.onDeleteFinish = () =>{
                        debtsInformation.removeChild(document.getElementById('debts' + debts.id));
                };
                debtsInformation.appendChild(view.render());

            }
        }
    });
    xhr.open('GET', 'http://localhost:8081/LukasKeeper_war/api/debts/list?email=' + session.email);
    xhr.send();
};

getAllDebts();
