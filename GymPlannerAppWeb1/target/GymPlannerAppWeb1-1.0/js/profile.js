var username = new URL(location.href).searchParams.get("username");
var user;

$(document).ready(function () {


    fillUsuario().then(function () {

        $("#user-username").html(user.username);

        getHistorials(user.username);
    });

    $("#escoger-btn").attr("href", `crearutina.html?username=${username}`);

    $("#form-modificar").on("submit", function (event) {

        event.preventDefault();
        modificarUsuario();
    });

    $("#aceptar-eliminar-cuenta-btn").click(function () {

        eliminarCuenta().then(function () {
            location.href = "index.html";
        })
    })

});

async function fillUsuario() {
    await $.ajax({
        type: "GET",
        dataType: "html",
        url: "./ServletUsuarioPedir",
        data: $.param({
            username: username,
        }),
        success: function (result) {
            let parsedResult = JSON.parse(result);

            if (parsedResult != false) {
                user = parsedResult;

                $("#input-username").val(parsedResult.username);
                $("#input-contrasena").val(parsedResult.contrasena);
                $("#input-nombre").val(parsedResult.nombre);
                $("#input-apellidos").val(parsedResult.apellidos);
                $("#input-email").val(parsedResult.email);
                $("#input-sexo").val(parsedResult.sexo);
                $("#input-altura").val(parsedResult.altura);
                $("#input-peso").val(parsedResult.peso);
                $("#input-actividad_fisica").val(parsedResult.actividad_fisica);
                $("#input-edad").val(parsedResult.edad);
                $("#input-nivel_fisico").val(parsedResult.nivel_fisico);


            } else {
                console.log("Error recuperando los datos del usuario");
            }
        }
    });
}

function getHistorials(username) {


    $.ajax({
        type: "GET",
        dataType: "html",
        url: "./ServletHistorialListar",
        data: $.param({
            username: username,
        }),
        success: function (result) {
            let parsedResult = JSON.parse(result);

            if (parsedResult != false) {

                mostrarHistorial(parsedResult)

            } else {
                console.log("Error recuperando los datos de selección");
            }
        }
    });
}

function mostrarHistorial(rutina) {
    let contenido = "";
    if (rutina.length >= 1) {
        $.each(rutina, function (index, rutina) {
            rutina = JSON.parse(rutina);
            let niv;
            if (rutina.nivel == 1) {
                niv = "Principiante";
            } else if (rutina.nivel == 2) {
                niv = "Intermedio";
            } else {
                niv = "Avanzado";
            }
            contenido += '<tr><th scope="row">' + rutina.id_rutina + '</th>' +
                    '<td>' + rutina.ejercicio + '</td>' +
                    '<td>' + rutina.nivel + '</td>' +
                    '<td><input type="checkbox" name="nivel" id="nivel' + rutina.id_rutina
                    + '" disabled ';
            if (rutina.nivel == 2) {
                contenido += 'checked'
            }
            contenido += '></td><td>' + rutina.dia+ '</td>' +
                    '<td><button id="terminar-btn" onclick= "terminarrutina(' + rutina.id_rutina
                    + ');" class="btn btn-danger">Terminar rutina</button></td></tr>';

        });
        $("#historial-tbody").html(contenido);
        $("#historial-table").removeClass("d-none");
        $("#historial-vacio").addClass("d-none");

    } else {
        $("#historial-vacio").removeClass("d-none");
        $("#historial-table").addClass("d-none");
    }
}


function terminarRutina(id_rutina) {

    $.ajax({
        type: "GET",
        dataType: "html",
        url: "./ServletRutinaTerminar",
        data: $.param({
            username: username,
            id_rutina: id_rutina,
        }),
        success: function (result) {

            if (result != false) {

                location.reload();

            } else {
                console.log("Error devolviendo el Pelicula");
            }
        }
    });

}

function modificarUsuario() {

    let username = $("#input-username").val();
    let contrasena = $("#input-contrasena").val();
    let nombre = $("#input-nombre").val();
    let apellidos = $("#input-apellidos").val();
    let email = $("#input-email").val();
    let sexo = $("#input-sexo").val();
    let altura = $("#input-altura").val();
    let peso = $("#input-peso").val();
    let actividad_fisica = $("#input-actividad_fisica").val();
    let edad = $("#input-edad").val();
    let nivel_fisico = $("#input-nivel_fisico").val();
    
    $.ajax({
        type: "GET",
        dataType: "html",
        url: "./ServletUsuarioModificar",
        data: $.param({
            username: username,
                contrasena: contrasena,
                nombre : nombre,
                apellidos : apellidos,
                email : email,
                sexo : sexo,
                altura : altura,
                peso : peso,
                actividad_fisica : actividad_fisica,
                edad : edad,
                nivel_fisico : nivel_fisico
        }),
        success: function (result) {

            if (result != false) {
                $("#modificar-error").addClass("d-none");
                $("#modificar-exito").removeClass("d-none");
            } else {
                $("#modificar-error").removeClass("d-none");
                $("#modificar-exito").addClass("d-none");
            }

            setTimeout(function () {
                location.reload();
            }, 3000);

        }
    });

}

async function eliminarCuenta() {

    await $.ajax({
        type: "GET",
        dataType: "html",
        url: "./ServletUsuarioEliminar",
        data: $.param({
            username: username
        }),
        success: function (result) {

            if (result != false) {

                console.log("Usuario eliminado")

            } else {
                console.log("Error eliminando el usuario");
            }
        }
    });
}

