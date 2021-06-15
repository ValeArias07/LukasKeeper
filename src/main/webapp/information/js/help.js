const cardcorreos = document.getElementById('tarjetacorreos')
const cardeditar= document.getElementById('tarjetaeditar')
const cardborrar = document.getElementById('tarjetaborrar')
const cardplanes = document.getElementById('tarjetaplanes')

cardcorreos.addEventListener('click',function(){
    cardcorreos.innerHTML = 'Sólo se puede crear una cuenta con un correo electrónico asociado';
});

cardeditar.addEventListener('click',function(){
    cardeditar.innerHTML = 'Esta información no puede ser editada, a excepción de la información de tu perfil.';
});

cardborrar.addEventListener('click',function(){
    cardborrar.innerHTML = 'Lo sentimos, los datos que decidas eliminar no se pueden recuperar.';
});

cardplanes.addEventListener('click',function(){
    cardplanes.innerHTML = 'No hay límite para la cantidad de planes que se pueden crear.';
});