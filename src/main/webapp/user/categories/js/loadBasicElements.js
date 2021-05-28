const head= document.getElementById('header');
const sidebar = document.getElementById('sidebar');
const footer= document.getElementById('footer');

loadElements=()=>{

    head.innerHTML= '<header>\n' +
        '<a class="logo" href="/"><img src="../../images/logo.png" alt="logo" width="200px"> </a>\n' +
        '    <nav>\n' +
        '        <ul class="nav__links">\n' +
        '            <li><a href="../general/dashboard.html ">Dashboard</a></li>\n' +
        '            <li><a id="own1">Ingresos</a></li>\n' +
        '            <li><a href="expenses.html">Gastos</a></li>\n' +
        '            <li><a href="debts.html">Deudas</a></li>\n' +
        '            <li><a href="savings.html">Ahorros</a></li>\n' +
        '            <li><a href="../about/help.html ">Ayuda </a></li>\n' +
        '            <li><a href="../about/contact.html ">Contactanos</a></li>\n' +
        '            <li><a href="../../index.html  ">Cerrar sesion</a></li>\n' +
        '        </ul>\n' +
        '    </nav>\n' +
        '    </header>';

    sidebar.innerHTML = ' <div class="sidebar">\n' +
        '<center>'+
        '                <img src="../../images/model.jpg" class="profile_image" alt="">\n' +
        '                <h4>Hola, ! </h4>\n' +
        '</center>'+
        '            <a href="../add/addIncomes.html"><img src="../../images/addIncome.png" class="icons" align="center"><span>Agregar ingreso</span></a>\n' +
        '            <a href="#"><img src="../../images/period.png" class="icons" align="center"><span>Ver por periodo</span></a>\n' +
        '            <a href="#"><img src="../../images/timeline.png" class="icons" align="center"><span>Comparar en el tiempo</span></a>\n' +
        '            <a href="#"><img src="../../images/compare.png" class="icons" align="center"><span>Comparar entre categorias</span></a>\n' +
        '            <a href="#"><img src="../../images/indicators.png" class="icons" align="center"><span>Ver indicadores</span></a>\n' +
        '\n' +
        '            <h5> Recomiendanos a un amigo<br> LukasKeeper © 2021 </h5>\n' +
        '        </div>';

    footer.innerHTML= '<footer>\n' +
        '    <a class=" logo " href="/ "><img src="../../images/logo.png " alt="logo " width="200px "> </a>\n' +
        '    <nav>\n' +
        '        <ul class="nav__links ">\n' +
        '            <li><a href="../general/dashboard.html ">Dashboard</a></li>\n' +
        '            <li><a id="own2">Ingresos</a></li>\n' +
        '            <li><a href="expenses.html">Gastos</a></li>\n' +
        '            <li><a href="debts.html">Deudas</a></li>\n' +
        '            <li><a href="savings.html">Ahorros</a></li>\n' +
        '            <li><a href="../about/help.html ">Ayuda </a></li>\n' +
        '            <li><a href="../about/contact.html ">Contactanos</a></li>\n' +
        '            <li><a href="../../index.html  ">Cerrar sesion</a></li>\n' +
        '        </ul>\n' +
        '    </nav>\n' +
        '</footer>';
}
loadElements();