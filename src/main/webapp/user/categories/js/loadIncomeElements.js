class loadIncomeElements{

    constructor(income){
        this.income = income;
        this.onDeleteFinish = null;
    }

    deleteIncome = () =>{
        let xhr = new XMLHttpRequest();
        xhr.addEventListener('readystatechange', ()=>{
            if(xhr.readyState === 4){
                console.log(xhr.responseText);
                if(this.onDeleteFinish!=null){
                    this.onDeleteFinish();
                }
            }
        });
        xhr.open('DELETE', 'http://localhost:8081/LukasKeeper/api/incomes/delete/'+this.income.id);
        xhr.send();
    }



    render = () =>{
        let component = document.createElement('div'); //<div></div>
        component.id = 'income' + this.income.id;
        component.className = 'elementsComponent';

        let fieldCantidad = document.createElement('div'); //<div></div>
        fieldCantidad.className = 'field';
        let cantidadLabel = document.createElement('label'); //<p></p>
        cantidadLabel.className = 'label';
        let cantidadIncome =document.createElement('small');
        cantidadIncome.id = "cantidadIncome";

        let fieldDescripcion = document.createElement('div'); //<div></div>
        fieldDescripcion.className = 'field';
        let descripcionLabel = document.createElement('label'); //<small></small>
        descripcionLabel.className = 'label';
        let descripcionIncome =document.createElement('small');
        descripcionIncome.id = "descripcionIncome";

        let fieldFecha = document.createElement('div'); //<div></div>
        fieldFecha.className = 'field';
        let fechaLabel = document.createElement('label'); //<small></small>
        fechaLabel.className = 'label';
        let fechaIncome =document.createElement('small');
        fechaIncome.id = "fechaIncome";

        let delBtn = document.createElement('button');
        delBtn.innerHTML = 'Eliminar';
        delBtn.className = 'buttonDelete';

        cantidadLabel.innerHTML = "Cantidad"; //<p>Nota 1</p>
        descripcionLabel.innerHTML = "Descripción";
        fechaLabel.innerHTML = "Fecha";
        cantidadIncome.innerHTML = this.income.value;
        descripcionIncome.innerHTML = this.income.description;
        fechaIncome.innerHTML = this.income.date.substring(0,9);

        component.appendChild(fieldCantidad); //<div><p></p></div>
        component.appendChild(fieldDescripcion); //div<p></p><small></small></div>
        component.appendChild(fieldFecha);
        component.appendChild(delBtn);

        fieldCantidad.appendChild(cantidadLabel);
        fieldCantidad.appendChild(cantidadIncome);
        fieldDescripcion.appendChild(descripcionLabel);
        fieldDescripcion.appendChild(descripcionIncome);
        fieldFecha.appendChild(fechaLabel);
        fieldFecha.appendChild(fechaIncome);

        delBtn.addEventListener('click', this.deleteIncome);

        return component;
    }
}