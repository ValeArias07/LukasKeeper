const head= document.getElementById('header');
const footer= document.getElementById('footer');

loadElements=()=>{

    head.innerHTML= '<header>\n' +
        '<a class="logo" href="/"><img src="../../images/logo.png" alt="logo" width="200px"> </a>\n' +
        '    <nav>\n' +
        '        <ul class="nav__links">\n' +
        '            <li><a href="../general/dashboard.html ">Dashboard</a></li>\n' +
        '            <li><a href="incomes.html">Ingresos</a></li>\n' +
        '            <li><a href="expenses.html">Gastos</a></li>\n' +
        '            <li><a href="debts.html">Deudas</a></li>\n' +
        '            <li><a href="savings.html">Ahorros</a></li>\n' +
        '            <li><a href="../about/help.html ">Ayuda </a></li>\n' +
        '            <li><a href="../about/contact.html ">Contactanos</a></li>\n' +
        '            <li> <button id="logOutButton" href="../../index.html"> Cerrar Sesión </button>\n' +
        '        </ul>\n' +
        '    </nav>\n' +
        '    </header>';



    footer.innerHTML= '<footer>\n' +
        '    <a class=" logo " href="/ "><img src="../../images/logo.png " alt="logo " width="200px "> </a>\n' +
        '    <nav>\n' +
        '        <ul class="nav__links ">\n' +
        '            <li><a href="../general/dashboard.html ">Dashboard</a></li>\n' +
        '            <li><a href="incomes.html">Ingresos</a></li>\n' +
        '            <li><a href="expenses.html">Gastos</a></li>\n' +
        '            <li><a href="debts.html">Deudas</a></li>\n' +
        '            <li><a href="savings.html">Ahorros</a></li>\n' +
        '            <li><a href="../about/help.html ">Ayuda </a></li>\n' +
        '            <li><a href="../about/contact.html ">Contactanos</a></li>\n' +
        '        </ul>\n' +
        '    </nav>\n' +
        '</footer>';
}
loadElements();