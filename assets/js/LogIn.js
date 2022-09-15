//funcion que captura datos del formulario iniciar sesoon


//funcion que captura datos del formulario iniciar sesoon
function inicioSesion(){
    let correo= document.getElementById('correo').value;
    let contraseña= document.getElementById('password').value;
    const expresionCorreo = /\w+@\w+\.+[a-z]/;
    const expresionPass = /^.{4,12}$/;

 /*    if (correo==''){
        alert('Ingrese correo');
        document.getElementById("correo").focus();
        return false;
    }
     if (contraseña==''){
        alert('Ingrese contraseña');
        document.getElementById("contraseña").focus();
        return false;
    } */
     if (!expresionCorreo.test(correo)){
        alert('El correo es invalido')
        document.getElementById("correo").focus();
        return false;
        
    }
     if (!expresionPass.test(contraseña)){
        alert('la contraseña es Invalida'+'\nLa contraseña debe tener de 4 a 12 caracteres')
        document.getElementById("password").focus();
        return false;

    } else{
        console.log(correo+" "+contraseña);
        document.getElementById('correo').value="";
        document.getElementById('password').value="";

    }


    let sesion = {correo, contraseña}
    let sesionJson = JSON.stringify(sesion);
    console.log(sesion);
    console.log(sesionJson);
    return false;
               
}

