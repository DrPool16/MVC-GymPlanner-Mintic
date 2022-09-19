$(document).ready(function () {

    $("#form-login").submit(function (event) {

        event.preventDefault();
        autenticarUsuario();
    });

    $("#form-register").submit(function (event) {

        event.preventDefault();
        registrarUsuario();
    });

});

function autenticarUsuario() {

    let username = $("#usuario").val();
    let contrasena = $("#contrasena").val();

    $.ajax({
        type: "GET",
        dataType: "html",
        url: "./ServletUsuarioLogin",
        data: $.param({
            username: username,
            contrasena: contrasena
        }),
        success: function (result) {
            let parsedResult = JSON.parse(result);
            if (parsedResult != false) {
                $("#login-error").addClass("d-none");
                let username = parsedResult['username'];
                document.location.href = "home.hmtl?username=" + username;
            } else {
                $("#login-error").removeClass("d-none");
            }
        }
    });
}

function registrarUsuario() {

    let username = $("#input-username").val();
    let contrasena = $("#input-contrasena").val();
    let contrasenaConfirmacion = $("#input-contrasena-repeat").val();
    let nombre = $("#input-nombre").val();
    let apellidos = $("#input-apellidos").val();
    let email = $("#input-email").val();
    let sexo = $("#input-sexo").val();
    let altura = $("#input-altura").val();
    let peso = $("#input-peso").val();
    let actividad_fisica = $("#input-actividad_fisica").val();
    let edad = $("#input-edad").val();
    let nivel_fisico = $("#input-nivel_fisico").val();

    if (contrasena == contrasenaConfirmacion) {
        $.ajax({
            type: "GET",
            dataType: "html",
            url: "./ServletUsuarioRegister",
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
            success: function (result){
                let parsedResult = JSON.parse(result);
                
                if (parsedResult != false){
                    $("#register-error").addClass("d-none");
                    let username = parsedResult['username'];
                    document.location.href = "home.html?username="+username;
                }else {
                    $("#register-error").removeClass("d-none");
                    $("#register-error").html("Error en el registro del usuario");
                }
                
            }
        });
    } else {
        $("#register-error").removeClass("d-none");
        $("#register-error").html("Las contraseñas no coinciden");
    }



}

