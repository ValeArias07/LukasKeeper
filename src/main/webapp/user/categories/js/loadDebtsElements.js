class loadDebtsElements{

    constructor(debt){
        this.debt = debt;
        this.onDeleteFinish = null;
    }

    deleteDebt = () =>{
        let xhr = new XMLHttpRequest();
        xhr.addEventListener('readystatechange', ()=>{
            if(xhr.readyState === 4){
                console.log(xhr.responseText);
                if(this.onDeleteFinish!=null){
                    this.onDeleteFinish();
                }
            }
        });
        xhr.open('DELETE', 'http://localhost:8081/LukasKeeper_war/api/debts/delete/'+this.debt.id);
        xhr.send();
    }

    render = () =>{
        let component = document.createElement('div'); //<div></div>
        component.id = 'debts' + this.debt.id;
        component.className = 'elementsComponent';

        let fieldCantidad = document.createElement('div'); //<div></div>
        component.className = 'field';
        let cantidadLabel = document.createElement('label'); //<p></p>
        cantidadLabel.className = 'cantidadLabel';
        let cantidadDebts =document.createElement('label');
        cantidadDebts.id = 'cantidadDebts';

        let fieldDescripcion = document.createElement('div'); //<div></div>
        component.className = 'field';
        let descripcionLabel = document.createElement('label'); //<small></small>
        descripcionLabel.className = 'descripcionLabel';
        let descripcionDebts =document.createElement('label');
        descripcionDebts.id = "descripcionDebts";
        
        let fieldFecha = document.createElement('div'); //<div></div>
        component.className = 'field';
        let fechaLabel = document.createElement('label'); //<small></small>
        fechaLabel.className = 'fechaLabel';
        let fechaDebts =document.createElement('label');
        fechaDebts.id = "fechaDebts";

        let delBtn = document.createElement('button');
        delBtn.innerHTML = 'Eliminar';
        delBtn.className = 'delBtn';
        
        cantidadLabel.innerHTML = "Cantidad   "; //<p>Nota 1</p>
        descripcionLabel.innerHTML = "Descripción   ";
        fechaLabel.innerHTML = "Fecha   ";
        cantidadDebts.innerHTML = this.debt.value;
        descripcionDebts.innerHTML = this.debt.description;
        fechaDebts.innerHTML = this.debt.date;

        fieldCantidad.appendChild(cantidadLabel);
        fieldCantidad.appendChild(cantidadDebts);
        fieldDescripcion.appendChild(descripcionLabel);
        fieldDescripcion.appendChild(descripcionDebts);
        fieldFecha.appendChild(fechaLabel);
        fieldFecha.appendChild(fechaDebts);

        component.appendChild(fieldCantidad); //<div><p></p></div>
        component.appendChild(fieldDescripcion); //div<p></p><small></small></div>
        component.appendChild(fieldFecha);
        component.appendChild(delBtn);
        
        delBtn.addEventListener('click', this.deleteDebt);
        return component;
    }
}