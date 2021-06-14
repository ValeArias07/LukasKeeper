class loadIncomeElements{

    constructor(income){
        this.income = income;
        this.onDeleteFinish = null;
    }

    render = () =>{
        let component = document.createElement('div'); //<div></div>
        component.className = 'income' + this.income.id;

        let fieldCantidad = document.createElement('div'); //<div></div>
        component.className = 'field';
        let cantidadLabel = document.createElement('p'); //<p></p>
        cantidad.className = 'cantidadLabel'; 
        let cantidadIncome =document.createElement('p');
        cantidadIncome.id = "cantidadIncome";

        let fieldDescripcion = document.createElement('div'); //<div></div>
        component.className = 'field';
        let descripcionLabel = document.createElement('p'); //<small></small>
        descripcion.className = 'descripcionLabel';
        let descripcionIncome =document.createElement('p');
        descripcionIncome.id = "descripcionIncome";
        
        let fieldFecha = document.createElement('div'); //<div></div>
        component.className = 'field';
        let fechaLabel = document.createElement('p'); //<small></small>
        fechaLabel.className = 'fechaLabel';
        let fechaIncome =document.createElement('p');
        fechaIncome.id = "fechaIncome";

        let delBtn = document.createElement('button');
        delBtn.innerHTML = 'Eliminar';
        delBtn.className = 'delBtn';
        
        cantidadLabel.innerHTML = "Cantidad"; //<p>Nota 1</p>
        descripcionLabel.innerHTML = "Descripción";
        fechaLabel.innerHTML = "Fecha";
        cantidadIncome.innerHTML = this.income.value;
        descripcionIncome.innerHTML = this.income.description;
        fechaIncome.innerHTML = this.income.date;

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
        
        delBtn.addEventListener('click', this.deleteNote);

        return component;
    }
}
