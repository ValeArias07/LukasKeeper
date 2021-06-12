class loadDebtsElements{

    constructor(debts){
        this.debts = debts;
        this.onDeleteFinish = null;
    }

    render = () =>{
        let component = document.createElement('div'); //<div></div>
        component.className = 'debts' + this.debts.id;

        let fieldCantidad = document.createElement('div'); //<div></div>
        component.className = 'field';
        let cantidadLabel = document.createElement('p'); //<p></p>
        cantidad.className = 'cantidadLabel'; 
        let cantidadDebts =document.createElement('p');
        cantidadDebts.id = "cantidadDebts";

        let fieldDescripcion = document.createElement('div'); //<div></div>
        component.className = 'field';
        let descripcionLabel = document.createElement('p'); //<small></small>
        descripcion.className = 'descripcionLabel';
        let descripcionDebts =document.createElement('p');
        descripcionDebts.id = "descripcionDebts";
        
        let fieldFecha = document.createElement('div'); //<div></div>
        component.className = 'field';
        let fechaLabel = document.createElement('p'); //<small></small>
        fechaLabel.className = 'fechaLabel';
        let fechaDebts =document.createElement('p');
        fechaDebts.id = "fechaDebts";

        let delBtn = document.createElement('button');
        delBtn.innerHTML = 'Eliminar';
        delBtn.className = 'delBtn';
        
        cantidadLabel.innerHTML = "Cantidad"; //<p>Nota 1</p>
        descripcionLabel.innerHTML = "Descripción";
        fechaLabel.innerHTML = "Fecha";
        cantidadDebts.innerHTML = this.Debts.value;
        descripcionDebts.innerHTML = this.Debts.description;
        fechaDebts.innerHTML = this.Debts.date;

        component.appendChild(fieldCantidad); //<div><p></p></div>
        component.appendChild(fieldDescripcion); //div<p></p><small></small></div>
        component.appendChild(fieldFecha);
        component.appendChild(delBtn);

        fieldCantidad.appendChild(cantidadLabel);
        fieldCantidad.appendChild(cantidadDebts);
        fieldDescripcion.appendChild(descripcionLabel);
        fieldDescripcion.appendChild(descripcionDebts);
        fieldFecha.appendChild(fechaLabel);
        fieldFecha.appendChild(fechaDebts);
        
        delBtn.addEventListener('click', this.deleteNote);

        return component;
    }
}
