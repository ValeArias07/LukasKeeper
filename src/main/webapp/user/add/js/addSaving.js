const amount = document.getElementById('txtAmount');
const planSelecter = document.getElementById('planSelecter');

btAdd.addEventListener('click', toRegister);

function toRegister(){
    let saving = {amount = amount.value, plan = planSelecter.selectedIndex};

    //POST
    let xhr = new XMLHttpRequest();
    xhr.addEventListener('readystatechange', ()=>{
        console.log(xhr.responseText);
    });
    xhr.open('POST', "url");
    xhr.setRequestHeader('Content-type', 'application/json');
    xhr.send(JSON.stringify(saving)); //toJson
}

function loadOptionsOfPlanSelecter(){

    let xhr = new XMLHttpRequest();
    xhr.addEventListener('readystatechange', ()=>{
        if(xhr.readyState === 4){
            let json = xhr.responseText;
            let response = JSON.parse(json);
            console.log(response);
            for(let i=0; response.length; i++){
                let plan = response[i];
                var option = document.createElement("option");
                option.text = plan;
                planSelecter.add(option);
            }
        }
    });
    xhr.open('GET', "url");
    xhr.send();
}

loadOptionsOfPlanSelecter();