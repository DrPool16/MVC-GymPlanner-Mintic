var username = new URL(location.href).searchParams.get("username");
var user;

$(document).ready(function () {

    $(function () {
        $('[data-toggle="tooltip"]').tooltip();
    });

    getUsuario().then(function () {

        $("#mi-perfil-btn").attr("href", "profile.html?username=" + username);

        $("#user-username").html(user.username);

        getRutinas(false, "ASC");

        $("#ordenar-rutina").click(ordenarRutinas);
    });
});

async function getUsuario() {

    await $.ajax({
        type: "GET",
        dataType: "html",
        url: "./ServletUsuarioPedir",
        data: $.param({
            username: username
        }),
        success: function (result) {
            let parsedResult = JSON.parse(result);

            if (parsedResult != false) {
                user = parsedResult;
            } else {
                console.log("Error recuperando los datos del usuario");
            }
        }
    });
}

function getRutinas(ordenar, orden) {

    $.ajax({
        type: "GET",
        dataType: "html",
        url: "./ServletRutinaListar",
        data: $.param({
            ordenar: ordenar,
            orden: orden
        }),
        success: function (result) {
            let parsedResult = JSON.parse(result);

            if (parsedResult != false) {
                mostrarRutinas(parsedResult);
            } else {
                console.log("Error recuperando los datos de las rutinas");
            }
        }
    });
}


function mostrarRutinas(rutinas) {

    let contenido = "";

    $.each(rutinas, function (index, rutina) {

        rutina = JSON.parse(rutina);
        let niv;
        if (rutina.nivel == 1){
            niv = "Principiante";
        }else if (rutina.nivel == 2){
            niv = "Intermedio";
        }else{
            niv = "Avanzado";
        }
        
        contenido += '<tr><th scope="row">' + rutina.id_rutina + '</th>' +
                //'<td>' + rutina.nivel + '</td>' +
                '<td>' + rutina.grupo_muscular + '</td>' +
                '<td>' + rutina.tipo + '</td>' +
                '<td>' + rutina.ejercicio + '</td>' +
                '<td><input type="checkbox" name="nivel" id="nivel' + rutina.id_rutina + '" disabled ';
        if (rutina.nivel == user.nivel_fisico) {
            contenido += 'checked';
        }
        contenido += '></td>' +
                '<td>' + niv + '</td>' +
                '<td><button onclick="selecRutina(' + rutina.id_rutina + ',' + niv + ');" class="btn btn-success" ';
        if (rutina.nivel != user.nivel_fisico) {
            contenido += ' disabled ';
        }

        contenido += '>Escoger</button></td></tr>'


    });
    $("#rutinas-tbody").html(contenido);
}

function ordenarRutinas() {
    if ($("#icono-ordenar").hasClass("fa-sort")) {
        getRutinas(true, "ASC");
        $("#icono-ordenar").removeClass("fa-sort");
        $("#icono-ordenar").addClass("fa-sort-down");
    } else if ($("#icono-ordenar").hasClass("fa-sort-down")) {
        getRutinas(true, "DESC");
        $("#icono-ordenar").removeClass("fa-sort-down");
        $("#icono-ordenar").addClass("fa-sort-up");
    } else if ($("#icono-ordenar").hasClass("fa-sort-up")) {
        getRutinas(false, "ASC");
        $("#icono-ordenar").removeClass("fa-sort-up");
        $("#icono-ordenar").addClass("fa-sort");
    }
}

function selecRutina(id_rutina) {
    $.ajax({
        type: "GET",
        dataType: "html",
        url: "./ServletRutinaSeleccionar",
        data: $.param({
            id_rutina: id_rutina,
            username: username
        }),
        
        success: function (result) {
            let parsedResult = JSON.parse(result);

            if (parsedResult != false) {
                user = parsedResult;
            } else {
                console.log("Error recuperando los datos del usuario");
            }
        }
         /*
        success: function (result) {
           
            let parsedResult = JSON.parse(result);
            if (parsedResult != false) {
                restarNivel(nivel).then(function () {
                    location.reload();
                })
            } else {
                console.log("Error para seleccionar rutina");
            }
        }
        */
    });
}
 