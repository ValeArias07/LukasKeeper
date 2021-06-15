class loadExpensesElements{

    constructor(expenses){
        this.expenses = expenses;
        this.onDeleteFinish = null;
    }

    deleteExpenses = () =>{
        let xhr = new XMLHttpRequest();
        xhr.addEventListener('readystatechange', ()=>{
            if(xhr.readyState === 4){
                console.log(xhr.responseText);
                if(this.onDeleteFinish!=null){
                    this.onDeleteFinish();
                }
            }
        });
        xhr.open('DELETE', 'http://localhost:8081/LukasKeeper_war/api/expenses/delete/'+this.debt.id);
        xhr.send();
    }

    render = () =>{
        let component = document.createElement('div'); //<div></div>
        component.id = 'expenses' + this.expenses.id;
        component.className = 'elementsComponent';

        let fieldCantidad = document.createElement('div'); //<div></div>
        component.className = 'field';
        let cantidadLabel = document.createElement('label'); //<p></p>
        cantidadLabel.className = 'cantidadLabel';
        let cantidadExpenses =document.createElement('label');
        cantidadExpenses.id = 'cantidadExpenses';

        let fieldDescripcion = document.createElement('div'); //<div></div>
        component.className = 'field';
        let descripcionLabel = document.createElement('p'); //<small></small>
        descripcionLabel.className = 'descripcionLabel';
        let descripcionExpenses =document.createElement('p');
        descripcionExpenses.id = "descripcionExpenses";

        let fieldFecha = document.createElement('div'); //<div></div>
        component.className = 'field';
        let fechaLabel = document.createElement('p'); //<small></small>
        fechaLabel.className = 'fechaLabel';
        let fechaExpenses =document.createElement('p');
        fechaExpenses.id = "fechaExpenses";

        let delBtn = document.createElement('button');
        delBtn.innerHTML = 'Eliminar';
        delBtn.className = 'delBtn';

        cantidadLabel.innerHTML = "Cantidad "; //<p>Nota 1</p>
        descripcionLabel.innerHTML = "Descripción ";
        fechaLabel.innerHTML = "Fecha ";
        cantidadExpenses.innerHTML = this.expenses.value;
        descripcionExpenses.innerHTML = this.expenses.description;
        fechaExpenses.innerHTML = this.expenses.date;

        fieldCantidad.appendChild(cantidadLabel);
        fieldCantidad.appendChild(cantidadExpenses);
        fieldDescripcion.appendChild(descripcionLabel);
        fieldDescripcion.appendChild(descripcionExpenses);
        fieldFecha.appendChild(fechaLabel);
        fieldFecha.appendChild(fechaExpenses);

        component.appendChild(fieldCantidad); //<div><p></p></div>
        component.appendChild(fieldDescripcion); //div<p></p><small></small></div>
        component.appendChild(fieldFecha);
        component.appendChild(delBtn);

        delBtn.addEventListener('click', this.deleteExpenses);
        return component;
    }
}
