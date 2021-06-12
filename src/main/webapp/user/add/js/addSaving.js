const amount = document.getElementById('txtAmount');
const planSelecter = document.getElementById('planSelecter');
const btAdd = document.getElementById("btAdd");
 toRegister=()=>{
    let saving = {
        amount: amount.value,
        plan: planSelecter.options[planSelecter.selectedIndex].value,
        date: (new Date(Date.now)).toLocaleDateString()
    };

    //POST
    let xhr = new XMLHttpRequest();
    xhr.open('POST', "url");
    xhr.setRequestHeader('Content-type', 'application/json');
    xhr.send(JSON.stringify(saving)); //toJson
}
 loadOptionsOfPlanSelecter=()=>{

    let xhr = new XMLHttpRequest();
    xhr.addEventListener('readystatechange', ()=>{
        if(xhr.readyState === 4){
            let json = xhr.responseText;
            let response = JSON.parse(json);
            console.log(response);
            for(let i=0; response.length; i++){
                let plan = response[i];
                var option = document.createElement("option");
                option.value=i;
                option.innerHTML=plan;
                planSelecter.add(option);
            }
        }
    });
    xhr.open('GET', "url");
    xhr.send();
}

loadOptionsOfPlanSelecter();
btAdd.addEventListener('click', toRegister);